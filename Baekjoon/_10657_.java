import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class _10657_ { // Cow Jog

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		ArrayList<Long[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());

			list.add(new Long[] { Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()) });
		}

		Stack<Long[]> stack = new Stack<>();
		boolean flag = false;
		while (true) {
			for (int j = list.size() - 1; j >= 0; j--) {
				if (!stack.isEmpty() && stack.peek()[1] < list.get(j)[1]) {
					flag = true;
				}
				if (stack.isEmpty() || list.get(j)[0] + list.get(j)[1] < stack.peek()[0]) {
					stack.add(new Long[] { list.get(j)[0] + list.get(j)[1], list.get(j)[1] });
				}
			}
			list.clear();
			while (!stack.isEmpty()) {
				list.add(stack.pop());
			}
			if (!flag) {
				System.out.println(list.size());
				break;
			}
			flag = false;
		}
	}
}
