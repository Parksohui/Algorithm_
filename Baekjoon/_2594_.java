import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2594_ { // 놀이공원

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			String x = st.nextToken();
			String y = st.nextToken();

			int start = Integer.parseInt(x.substring(0, 2)) * 60 + Integer.parseInt(x.substring(2, 4));
			int end = Integer.parseInt(y.substring(0, 2)) * 60 + Integer.parseInt(y.substring(2, 4));

			queue.add(new int[] { start, end });
		}

		int result = queue.peek()[0] - 10 - 600;
		int temp[] = null;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			temp[1] += 10;

			while (!queue.isEmpty()) {
				if (temp[1] >= queue.peek()[0] - 10) {
					temp[1] = Math.max(queue.poll()[1] + 10, temp[1]);
				} else {
					result = Math.max(result, queue.peek()[0] - 10 - temp[1]);
					break;
				}
			}
		}

		result = Math.max(result, 22 * 60 - temp[1]);

		if (result < 0)
			result = 0;

		System.out.println(result);
	}
}