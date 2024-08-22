import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[][] map;
	static int ans = Integer.MAX_VALUE;

	static void prim() {
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] v = new boolean[N];
		for(int i = 0 ; i < arr.length ; i++) {
			dist[i] = arr[i];
		}
		for (int i = 0; i < N - 1; i++) {
			// 초기화
			int minIdx = -1;
			int minDist = Integer.MAX_VALUE;
			for (int k = 0; k < dist.length; k++) {
				if (!v[k] && dist[k] < minDist) {
					minIdx = k;
					minDist = dist[k];
				}
			}
			if (minIdx == -1)
				break;
			v[minIdx] = true;
			for (int k = 0; k < map[minIdx].length; k++) {
				int n = map[minIdx][k];
				if(!v[k] && dist[k] > n && n != 0) {
					dist[k] = n;
					if(dist[k] > arr[k]) {
						dist[k] = arr[k];
					}
				}
			}
			int total = 0;
//			System.out.println(Arrays.toString(dist));
			for (int x : dist) {
				total += x;
			}
			ans = Math.min(ans, total);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 입력 V, E, 인접리스트
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (i == j) {
					map[i][j] = arr[i];
					continue;
				}
				map[i][j] = n;
			}
		}
//        for(int[] row: map) {
//        	System.out.println(Arrays.toString(row));
//        }
		prim();
		System.out.println(ans);

	}
}