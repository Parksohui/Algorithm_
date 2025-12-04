import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _10654_ { // Cow Jog

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		Stack<Long[]> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			stack.add(new Long[] { Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()) });
		}

		Stack<Long> result = new Stack<>();

		while (!stack.isEmpty()) {
			Long[] info = stack.pop();
			long d = info[0] + info[1] * t;
			if (result.isEmpty()) {
				result.add(d);
			} else {
				if (result.peek() > d) {
					result.add(d);
				}
			}
		}
		System.out.println(result.size());
	}
}
