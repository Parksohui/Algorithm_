import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _15088_ { // Game of Throwns

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int idx = 0;

		Stack<Integer> stack = new Stack<>();
		stack.add(0);

		st = new StringTokenizer(bf.readLine());

		while (st.hasMoreTokens()) {
			String cmd = st.nextToken();

			if (cmd.equals("undo")) {
				int num = Integer.parseInt(st.nextToken());

				for (int i = 0; i < num; i++) {
					stack.pop();
				}
				idx = stack.peek();
				
			} else {
				int num = Integer.parseInt(cmd);

				num %= n;

				idx += num;
				if (idx >= n) {
					idx -= n;
				} else if (idx < 0) {
					idx += n;
				}
				stack.add(idx);
			}
		}
		System.out.println(idx);
	}
}
