import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			bw.write(check(str));
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
	
	private static String check(String str) {
		Stack<Integer> stack = new Stack<>();
		for(int j = 0; j < str.length(); j++) {
			if('(' == str.charAt(j)) stack.push(1);
			else {
				if(stack.empty()) return "NO";
				else stack.pop();
			}
		}
		if(stack.empty()) return "YES";
		else return "NO";
	}

}
