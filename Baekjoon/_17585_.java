import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class _17585_ { // Circuit Math

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		char arr[] = new char[n];
		for (int i = 0; i < n; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		st = new StringTokenizer(bf.readLine());
		Stack<Character> stack = new Stack<>();
		ArrayList<Character> list = new ArrayList<>();

		while (st.hasMoreTokens()) {
			char value = st.nextToken().charAt(0);

			if (Character.isAlphabetic(value)) {
				if (list.contains(value)) {
					stack.add(arr[list.indexOf(value)]);
				} else {
					list.add(value);
					stack.add(arr[list.size() - 1]);
				}
			} else if (value == '*') {
				char x = stack.pop();
				char y = stack.pop();
				stack.add((x == 'T' && y == 'T') ? 'T' : 'F');

			} else if (value == '+') {
				char x = stack.pop();
				char y = stack.pop();
				stack.add((x == 'T' || y == 'T') ? 'T' : 'F');
			} else {
				char x = stack.pop();
				stack.add((x == 'F') ? 'T' : 'F');
			}
		}
		System.out.println(stack.pop());
	}
}
