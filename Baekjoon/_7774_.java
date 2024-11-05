import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _7774_ { // 콘센트

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			b.add(Integer.parseInt(st.nextToken()));
		}

		int result = 0;
		while (!a.isEmpty() && !b.isEmpty()) {
			if (a.size() < n) {
				result -= 1;
			}
			int temp = a.poll();

			while (temp-- > 0 && !b.isEmpty()) {
				result += b.poll();
			}
		}
		System.out.println(result);
	}
}
