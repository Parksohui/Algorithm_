import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2075_ { // N번째 큰 수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				queue.add(Long.parseLong(st.nextToken()));
			}
		}

		long result = -1;
		for (int i = 0; i < n; i++) {
			result = queue.poll();
		}
		System.out.println(result);
	}
}
