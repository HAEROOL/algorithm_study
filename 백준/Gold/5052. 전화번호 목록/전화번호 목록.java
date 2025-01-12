import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static class Node{
		Map<Character, Node> childs;
		boolean endOfWord;
		public Node() {
			this.childs = new HashMap();
			this.endOfWord = false;
		}
		public void insert(String word) {
			Node node = this;
			for(int i = 0 ; i < word.length() ; i++) {
				char c = word.charAt(i);
				
				node.childs.putIfAbsent(c, new Node());
				node = node.childs.get(c);
				
				if(i == word.length() - 1) {
					node.endOfWord = true;
					return;
				}
			}
		}
		
		public boolean contains(String word) {
			Node node = this;
			for(int i = 0 ; i < word.length() ; i++) {
				char c = word.charAt(i);
				Node n = node.childs.get(c);
				if(n == null) {
					return false;
				}
				node = n;
			}
			if(node.endOfWord) {
				if(node.childs.isEmpty()) {
					return false;
				}
			}
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
			List<String> keys = new ArrayList();
			for(int i = 0 ; i < N ; i++) {
				String input = br.readLine();
				root.insert(input);
				keys.add(input);
			}
			for(String key : keys) {
				if(root.contains(key)) {
					ans = false;
					break;
				}
			}
			bw.write((!ans?"NO":"YES") + "\n");
			
		}
		bw.close();
	}

}