import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _6119_ { // Cow Line

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int s = Integer.parseInt(bf.readLine());

		Deque<Integer> deque = new ArrayDeque<>();
		int idx = 1;

		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(bf.readLine());

			char cmd = st.nextToken().charAt(0);
			char dir = st.nextToken().charAt(0);

			if (cmd == 'A') {
				if (dir == 'L') {
					deque.addFirst(idx++);
				} else {
					deque.addLast(idx++);
				}
			} else {
				int k = Integer.parseInt(st.nextToken());

				if (dir == 'L') {
					for (int j = 0; j < k; j++) {
						deque.pollFirst();
					}
				} else {
					for (int j = 0; j < k; j++) {
						deque.pollLast();
					}
				}
			}
		}

		for (int num : deque) {
			bw.write(num + "\n");
		}
		bw.flush();
	}
}
