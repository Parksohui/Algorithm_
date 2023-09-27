import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _1758_ { // 알바생 강호

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(bf.readLine()));
		}

		long result = 0;
		int idx = 1;

		while (!queue.isEmpty()) {
			int num = queue.poll() - (idx++ - 1);
			if (num > 0)
				result += num;
		}

		System.out.println(result);
	}
}
