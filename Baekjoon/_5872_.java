import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _5872_ { // Clumsy Cows

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();

		Stack<Character> stack = new Stack<>();
		int result = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.add(str.charAt(i));
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					result += 1;
					stack.add('(');
				}
			}
		}
		if (!stack.isEmpty()) {
			result += stack.size() / 2;
		}
		System.out.println(result);
	}
}
