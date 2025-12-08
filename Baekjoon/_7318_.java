import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _7318_ {// Parencodings

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			st = new StringTokenizer(bf.readLine());

			String str = "";
			int cnt = 0;

			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());

				while (cnt < num) {
					str += "(";
					cnt += 1;
				}
				str += ")";
			}

			Stack<Character> stack = new Stack<>();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					stack.add(str.charAt(j));
				} else {
					int result = 0;
					while (stack.peek() != '(') {
						result += stack.pop() - '0';
					}
					stack.pop();
					bw.write((result + 1) + " ");
					stack.add((char) (result + 1 + '0'));
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
