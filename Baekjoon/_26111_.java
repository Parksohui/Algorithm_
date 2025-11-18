import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _26111_ { // Parentheses Tree

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> stack = new Stack<>();
		long result = 0;

		String str = bf.readLine();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.add(str.charAt(i));
			} else {
				stack.pop();
				if (str.charAt(i - 1) == '(') {
					result += stack.size();
				}
			}
		}
		System.out.println(result);
	}
}
