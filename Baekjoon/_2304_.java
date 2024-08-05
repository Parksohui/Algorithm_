import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2304_ { // 창고 다각형

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());

			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			list.add(new int[] { L, H });
		}

		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		Stack<int[]> stack = new Stack<>();
		stack.add(list.get(0));
		int result = 0;
		for (int i = 1; i < N; i++) {
			if (stack.peek()[1] < list.get(i)[1]) {
				int info[] = stack.pop();
				result += (list.get(i)[0] - info[0]) * info[1];
				stack.add(list.get(i));
			}
		}

		stack.add(list.get(N - 1));
		for (int i = N - 1; i >= 0; i--) {
			if (stack.peek()[1] < list.get(i)[1]) {
				int info[] = stack.pop();
				result += (info[0] - list.get(i)[0] ) * info[1];
				stack.add(list.get(i));
			}
		}

		int info[]=stack.pop();
		if (info[0] == stack.peek()[0]) {
			result += stack.peek()[1];
		} else {
			result += (info[0] + 1 - stack.peek()[0]) * stack.peek()[1];
		}
		System.out.println(result);
	}
}
