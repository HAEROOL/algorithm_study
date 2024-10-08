import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static class node{
		int val;
		node left, right;
		node(int val){
			this.val = val;
		}
		void insert(int n) {
			if(n < this.val) {
				if(this.left == null) {
					this.left = new node(n);
				}else {
					this.left.insert(n);
				}
			}else {
				if(this.right == null) {
					this.right = new node(n);
				}else {
					this.right.insert(n);
				}
			}
		}
	}
	static void postorder(node node) throws IOException {
		if(node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		bw.write(node.val + "\n");
	}
	public static void main(String[] args) throws IOException {
		String n = br.readLine();
		node root = new node(Integer.parseInt(n));
		String input = null;
		while(true) {
			input = br.readLine();
			if(input == null || input.equals("")) {
				break;
			}
			root.insert(Integer.parseInt(input));
		}
		postorder(root);
		bw.close();
	}
}