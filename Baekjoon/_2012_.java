import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _2012_ { // 등수 매기기
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(bf.readLine()));
		}

		int idx = 1;
		long result = 0;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			result += Math.abs(num - idx);
			idx += 1;
		}
		System.out.println(result);
	}
}
