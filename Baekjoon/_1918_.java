import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class _1918_ { // 후위 표기식
	static ArrayList<String> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();

		Stack<String> stack = new Stack<>();
		arr = new ArrayList<>();

		// (, )
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				while (!stack.peek().equals("(")) {
					arr.add(stack.pop());
				}
				checkPriority("*", "/");
				checkPriority("+", "-");

				stack.pop();
				stack.add(arr.get(0));
				arr.clear();
			} else {
				stack.add(Character.toString(str.charAt(i)));
			}
		}

		// *, /
		init(stack);
		checkPriority("*", "/");

		// +, -
		checkPriority("+", "-");

		System.out.println(arr.get(0));
	}

	private static void init(Stack<String> stack) {
		arr.clear();
		while (!stack.isEmpty()) {
			arr.add(stack.pop());
		}
	}

	private static void checkPriority(String op1, String op2) {
		Stack<String> stack2 = new Stack<>();
		for (int i = arr.size() - 1; i >= 0; i--) {
			String temp = arr.get(i);
			if (arr.get(i).equals(op1) || arr.get(i).equals(op2)) {
				temp = stack2.pop();
				temp += arr.get(i - 1);
				temp += arr.get(i);
				i -= 1;
			}
			stack2.add(temp);
		}
		init(stack2);
	}
}
