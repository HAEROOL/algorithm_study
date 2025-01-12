import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static class Node{
		Node[] childs;
		boolean endOfWord;
		public Node() {
			this.childs = new Node[10];
			this.endOfWord = false;
		}
		public boolean insert(String word) {
			Node node = this;
			for(int i = 0 ; i < word.length() ; i++) {
				int idx = word.charAt(i) - '0';
				
				if(node.childs[idx] == null) {
					node.childs[idx] = new Node();
				}
				
				node = node.childs[idx];
				
				if(node.endOfWord && i != word.length() - 1) {
					return false;
				}
			}
			for(int i = 0 ; i < 10 ; i++) {
				if(node.childs[i] != null) {
					return false;
				}
			}
			node.endOfWord = true;
			return true;
		}
		
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		for(int tc = 0 ; tc < TC ; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean ans = true;
			Node root = new Node();
			for(int i = 0 ; i < N ; i++) {
				String input = br.readLine();
				if(!root.insert(input)) {
					ans = false;
				}

			}
			bw.write((!ans?"NO":"YES") + "\n");
			
		}
		bw.close();
	}

}