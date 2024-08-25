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

public class Solution {
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, 1, 0, -1};
	static int[][] bc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int[] aMove = new int[M + 1];
			int[] bMove = new int[M + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i < M + 1 ; i++) {
				aMove[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i < M + 1 ; i++) {
				bMove[i] = Integer.parseInt(st.nextToken());
			}
			bc = new int[A][4];
			for(int i = 0 ; i < A ; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i] = new int[] {Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())};
			}
			int ax = 1;
			int ay = 1;
			int bx = 10;
			int by = 10;
			int total = 0;
			for(int t = 0 ; t < M + 1 ; t++) {
				ax += dx[aMove[t]];
				ay += dy[aMove[t]];
				bx += dx[bMove[t]];
				by += dy[bMove[t]];
				
				int max = 0;
				for(int a = 0 ; a < A ; a++) {
					for(int b = 0 ; b < A ; b++) {
						int sum = 0;
						int aVal = check(a, ay, ax);
						int bVal = check(b, by, bx);
						if(a != b) {
							sum += aVal + bVal;
						}else {
							sum += Math.max(aVal, bVal);
						}
						max = Math.max(sum, max);
					}
				}
				total += max;
			}
			bw.write("#" + tc + " " + total + "\n");
			bw.flush();
		}
	
		
		
		
		br.close();
		bw.close();
		
		
	}
	static int check(int a, int x, int y) {
		return Math.abs(bc[a][0] - x) + Math.abs(bc[a][1] - y) <= bc[a][2] ? bc[a][3] : 0;
	}
}