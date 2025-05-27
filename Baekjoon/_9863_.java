import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9863_ { // Calling All Programmers

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = 0;
		while ((n = Integer.parseInt(st.nextToken())) != 0) {
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i <= n; i++) {
				queue.add(i);
			}

			for (int i = 0; i < k; i++) {
				for (int j = 0; j < m; j++) {
					int num = queue.poll();
					if (j == m - 1) {
						if (i == k - 1) {
							bw.write(num + "\n");
						}
					} else {
						queue.add(num);
					}
				}
			}
			st = new StringTokenizer(bf.readLine());
		}
		bw.flush();
	}
}
