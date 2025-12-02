import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _13984_ { // Contest Score

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		long result = 0, time = 0;

		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(bf.readLine());

			queue.add(t);
			if (queue.size() == k) {
				time += queue.poll();

				result += time;
			}
		}
		while (!queue.isEmpty()) {
			time += queue.poll();
			result += time;
		}
		System.out.println(result);
	}
}
