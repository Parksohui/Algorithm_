import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class _5599_ { // カードの並び替え

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= 2*n; i++) {
			queue.add(i);
		}

		int m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < m; i++) {
			int k = Integer.parseInt(bf.readLine());
			if (k == 0) {
				Queue<Integer> first = new LinkedList<>();
				Queue<Integer> second = new LinkedList<>();

				for (int j = 0; j < n; j++) {
					first.add(queue.poll());
				}
				while (!queue.isEmpty()) {
					second.add(queue.poll());
				}

				while (!first.isEmpty()) {
					queue.add(first.poll());
					queue.add(second.poll());
				}
			} else {
				for (int j = 0; j < k; j++) {
					queue.add(queue.poll());
				}
			}
		}

		while (!queue.isEmpty()) {
			bw.write(queue.poll() + "\n");
		}
		bw.flush();
	}
}
