import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _16815_ { // Star in Parentheses

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();

		Stack<Character> stack = new Stack<>();
		boolean flag = false;
		int result = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				if (!flag) {
					stack.add(str.charAt(i));
				}
			} else if (str.charAt(i) == '*') {
				flag = true;
			} else {
				if (stack.size() > 0) {
					stack.pop();
					if (flag) {
						result += 1;
					}
				}
			}
		}
		System.out.println(result);
	}
}
