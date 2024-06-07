import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11971_ { // 속도 위반

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			queue.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		int result = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());

			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			while (d > 0) {
				if (queue.peek()[1] < s) {
					result = Math.max(result, s - queue.peek()[1]);
				}
				if (queue.peek()[0] > d) {
					queue.peek()[0] -= d;
					break;
				} else {
					d -= queue.poll()[0];
				}
			}
		}
		System.out.println(result);
	}
}
