import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean check(String base) {

		for(int i = 0 ; i < 3 ; i++) {
			int cnt = 0;
			for(int j = 0 ; j < 3 ; j++) {
				if(map[i][j].equals(base)) cnt++;
			}
			if(cnt == 3) return true;
		}
		
		for(int j = 0 ; j < 3 ; j++) {
			int cnt = 0;
			for(int i = 0 ; i < 3 ; i++) {
				if(map[i][j].equals(base)) cnt++;
			}
			if(cnt == 3) return true;
		}
		
		int cnt = 0;
		for(int i = 0 ; i < 3 ; i++) {
			if(map[i][i].equals(base)) cnt++;
		}
		if(cnt == 3) return true;
		
		cnt = 0;
		for(int i = 0 ; i < 3 ; i++) {
			if(map[3 - i - 1][i].equals(base)) cnt++;
		}
		if(cnt == 3) return true;
		return false;
	}
	static boolean define(int ocnt, int xcnt) {
		if(ocnt + xcnt == 9) {
			if(!check("O") && xcnt - ocnt == 1) {
				return true;
			}
		}else {
			if(!check("O") && check("X") && xcnt - ocnt == 1) {
				return true;
			}else if(!check("X") && check("O") && xcnt == ocnt) {
				return true;
			}
		}
		return false;
	}
	static String[][] map;
	static final String TRUE = "valid", FALSE = "invalid";
	static List<String> ans = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		while(true) {
			String s = br.readLine();
			int xcnt = 0;
			int ocnt = 0;
			if(s.equals("end")) break;
			String[] inputs = s.split("");
			map = new String[3][3];
			for(int i = 0 ; i < 3 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if(inputs[3 * i + j].equals("O")) ocnt++;
					else if(inputs[3 * i + j].equals("X")) xcnt++;
					map[i][j] = inputs[3 * i + j];
				}
			}
			if(define(ocnt, xcnt)) {
				ans.add(TRUE);
			}else {
				ans.add(FALSE);
			}
		}
		for(int i = 0 ; i < ans.size() - 1 ; i++) {
			bw.write(ans.get(i) + "\n");
		}
		bw.write(ans.get(ans.size() - 1));
		bw.close();
	}
}
