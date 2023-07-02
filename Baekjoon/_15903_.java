import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _15903_ { // 카드 합체 놀이

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> queue = new PriorityQueue<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			queue.add(Long.parseLong(st.nextToken()));
		}

		for (int i = 0; i < m; i++) {
			long x = queue.poll();
			long y = queue.poll();
			queue.add(x + y);
			queue.add(x + y);
		}

		long result = 0;
		while (!queue.isEmpty()) {
			result += queue.poll();
		}
		System.out.println(result);
	}
}
