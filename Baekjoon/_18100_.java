import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _18100_ { // Думский регламент

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int k = Integer.parseInt(bf.readLine());

		Stack<String> stack = new Stack<>();

		boolean flag = false;

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bf.readLine());

			String cmd = st.nextToken();
			String x = st.nextToken();

			if (cmd.equals("Add")) {
				stack.add(x);
			} else {
				if (stack.isEmpty() || !stack.peek().equals(x)) {
					flag = true;
					break;
				} else {
					stack.pop();
				}
			}
		}

		if (!stack.isEmpty() || flag) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}
}
