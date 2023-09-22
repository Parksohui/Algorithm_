import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11256_ { // 사탕

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(bf.readLine());

			int j = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int result = 0;

			for (int k = 0; k < n; k++) {
				st = new StringTokenizer(bf.readLine());

				int r = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				queue.add(r * b);
			}

			while (j > 0) {
				result += 1;
				j -= queue.poll();
			}

			bw.write(result + "\n");
			queue.clear();
		}
		bw.flush();
	}
}
