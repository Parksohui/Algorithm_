import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _7585_ { // Brackets

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";
		while (!(str = bf.readLine()).equals("#")) {
			Stack<Character> stack = new Stack<>();
			boolean flag = false;

			for (int i = 0; i < str.length(); i++) {

				if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
					stack.add(str.charAt(i));
				} else if (str.charAt(i) == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						flag = true;
						break;
					}
				} else if (str.charAt(i) == '}') {
					if (!stack.isEmpty() && stack.peek() == '{') {
						stack.pop();
					} else {
						flag = true;
						break;
					}
				} else if (str.charAt(i) == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						flag = true;
						break;
					}
				}
			}
			if (!stack.isEmpty()) {
				flag = true;
			}
			if (flag) {
				bw.write("Illegal\n");
			} else {
				bw.write("Legal\n");
			}
		}
		bw.flush();
	}
}
