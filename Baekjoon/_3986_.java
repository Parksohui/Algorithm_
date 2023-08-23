import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _3986_ { // 좋은 단어

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		int answer = 0;

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			int idx = 0;
			while (idx < str.length()) {
				if (!stack.isEmpty()) {
					if (stack.peek() == str.charAt(idx)) {
						stack.pop();
					} else {
						stack.add(str.charAt(idx));
					}
				} else {
					stack.add(str.charAt(idx));
				}
				idx += 1;
			}
			if (stack.isEmpty()) {
				answer += 1;
			}
			stack.clear();
		}
		System.out.println(answer);
	}
}
