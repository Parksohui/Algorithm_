import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _17952_ { // 과제는 끝나지 않아!

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		Stack<int[]> stack = new Stack<>();
		int answer = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) {
				if (!stack.isEmpty()) {
					int temp[] = stack.pop();
					if (temp[1] == 1)
						answer += temp[0];
					else
						stack.add(new int[] { temp[0], temp[1] - 1 });
				}
			} else {
				int a = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());

				if (t == 1)
					answer += a;
				else
					stack.add(new int[] { a, t - 1 });
			}
		}
		System.out.println(answer);
	}
}
