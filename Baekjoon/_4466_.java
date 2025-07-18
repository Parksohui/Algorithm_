import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _4466_ { // A Smart Brain is a Tasty Brain

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int x = Integer.parseInt(bf.readLine());

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(bf.readLine());

			String str = st.nextToken();
			st.nextToken();
			char evaluation = st.nextToken().charAt(0);

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) != ')') {
					stack.add(str.charAt(j));
				} else {
					calc(stack);
				}
			}
			while (stack.size() > 1) {
				calc(stack);
			}

			if (stack.pop() == evaluation) {
				bw.write((i + 1) + ": Good brain\n");
			} else {
				bw.write((i + 1) + ": Bad brain\n");
			}
		}
		bw.flush();
	}

	private static void calc(Stack<Character> stack) {
		char a = stack.pop();
		while (!stack.isEmpty() && stack.peek() != '(') {
			if (stack.peek() == '!') {
				stack.pop();
				a = (a == 't') ? 'f' : 't';
			} else {
				char op = stack.pop();
				char b = stack.pop();
				while (stack.peek() == '!') {
					stack.pop();
					b = (b == 't') ? 'f' : 't';
				}

				if (op == '&') {
					a = (a == 't' && b == 't') ? 't' : 'f';
				} else {
					a = (a == 't' || b == 't') ? 't' : 'f';
				}
			}
		}
		if (!stack.isEmpty() && stack.peek() == '(') {
			stack.pop();
		}
		if (!stack.isEmpty() && stack.peek() == '!') {
			stack.pop();
			a = (a == 't') ? 'f' : 't';
		}
		stack.add(a);
	}
}