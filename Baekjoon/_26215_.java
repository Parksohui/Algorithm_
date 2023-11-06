import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _26215_ { // 눈 치우기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}

		int result = 0;
		while (!queue.isEmpty()) {
			int a = queue.poll();

			if (queue.isEmpty()) {
				result += a;
				break;
			}
			int b = queue.poll();
			result += b;
			queue.add(a - b);
		}

		if (result > 1440)
			System.out.println(-1);
		else
			System.out.println(result);
	}
}
