import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _10489_ { // Even Up Solitaire

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (stack.isEmpty() || (stack.peek() + num) % 2 == 1) {
				stack.add(num);
			} else {
				stack.pop();
			}
		}
		System.out.println(stack.size());
	}
}
