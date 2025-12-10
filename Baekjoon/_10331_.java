import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10331_ { // Miscalculation

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();
		int num = Integer.parseInt(bf.readLine());

		int sum = str.charAt(0) - '0';
		for (int i = 2; i < str.length(); i += 2) {
			int temp = str.charAt(i) - '0';
			if (str.charAt(i - 1) == '+') {
				sum += temp;
			} else {
				sum *= temp;
			}
		}

		Stack<Integer> stack = new Stack<>();
		int mul = 0, idx = 0;
		while (idx < str.length()) {
			if (str.charAt(idx) == '*') {
				stack.add(stack.pop() * (str.charAt(idx++ + 1) - '0'));
			} else if (str.charAt(idx) != '+') {
				stack.add(str.charAt(idx) - '0');
			}
			idx+=1;
		}
		while (!stack.isEmpty()) {
			mul += stack.pop();
		}

		if (mul == num && sum == num) {
			System.out.println("U");
		} else if (mul == num) {
			System.out.println("M");
		} else if (sum == num) {
			System.out.println("L");
		} else {
			System.out.println("I");
		}
	}
}
