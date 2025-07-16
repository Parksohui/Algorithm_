import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _8594_ { // Program

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		String str = bf.readLine();

		Stack<Character> stack = new Stack<>();
		int result = 0;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
				stack.add(str.charAt(i));
				result = Math.max(result, stack.size());
			} else if (str.charAt(i) == ')') {
				if (stack.size() > 0 && stack.peek() == '(') {
					stack.pop();
				} else {
					flag = true;
					break;
				}
			} else if (str.charAt(i) == ']') {
				if (stack.size() > 0 && stack.peek() == '[') {
					stack.pop();
				} else {
					flag = true;
					break;
				}
			} else if (str.charAt(i) == '}') {
				if (stack.size() > 0 && stack.peek() == '{') {
					stack.pop();
				} else {
					flag = true;
					break;
				}
			}
		}
		if (flag || stack.size() > 0) {
			System.out.println("NIE");
		} else {
			System.out.println(result);
		}
	}
}
