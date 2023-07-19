import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14235_ { // 크리스마스 선물

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 0) {
				if (queue.isEmpty())
					bw.write(Integer.toString(-1) + "\n");
				else
					bw.write(Integer.toString(queue.poll()) + "\n");
			} else {
				for (int j = 0; j < a; j++) {
					queue.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		bw.flush();
	}
}
