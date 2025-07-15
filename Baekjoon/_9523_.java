import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9523_ { // Arithmetic with Morse

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		String str = bf.readLine();

		str = str.replace(" ", "");
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.') {
				int num = 0;
				if (stack.size() > 0 && !stack.peek().equals("+") && !stack.peek().equals("*")) {
					num = Integer.parseInt(stack.pop());
				}
				stack.add(Integer.toString(num + 1));
			} else if (str.charAt(i) == '-') {
				int num = 0;
				if (stack.size() > 0 && !stack.peek().equals("+") && !stack.peek().equals("*")) {
					num = Integer.parseInt(stack.pop());
				}
				stack.add(Integer.toString(num + 5));
			} else if (str.charAt(i) == ':') {
				int num = 0;
				if (stack.size() > 0 && !stack.peek().equals("+") && !stack.peek().equals("*")) {
					num = Integer.parseInt(stack.pop());
				}
				stack.add(Integer.toString(num + 2));
			} else if (str.charAt(i) == '=') {
				int num = 0;
				if (stack.size() > 0 && !stack.peek().equals("+") && !stack.peek().equals("*")) {
					num = Integer.parseInt(stack.pop());
				}
				stack.add(Integer.toString(num + 10));
			} else {
				stack.add(Character.toString(str.charAt(i)));
			}
		}

		Stack<Integer> result = new Stack<>();

		int a = Integer.parseInt(stack.pop());
		while (!stack.isEmpty()) {
			String temp = stack.pop();
			int b = Integer.parseInt(stack.pop());

			if (temp.equals("+")) {
				result.add(a);
				result.add(b);
			} else if (temp.equals("*")) {
				result.add(a * b);
			}
			a = result.pop();
		}

		int answer = a;
		while (!result.isEmpty()) {
			answer += result.pop();
		}
		System.out.println(answer);
	}
}
