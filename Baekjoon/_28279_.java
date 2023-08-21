import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _28279_ { // 덱 2

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			int num = Integer.parseInt(st.nextToken());
			if (num == 1) {
				int x = Integer.parseInt(st.nextToken());
				deque.addFirst(x);
			} else if (num == 2) {
				int x = Integer.parseInt(st.nextToken());
				deque.addLast(x);
			} else if (num == 3) {
				if (!deque.isEmpty()) {
					bw.write(deque.pollFirst() + "\n");
				} else {
					bw.write(-1 + "\n");
				}
			} else if (num == 4) {
				if (!deque.isEmpty()) {
					bw.write(deque.pollLast() + "\n");
				} else {
					bw.write(-1 + "\n");
				}
			} else if (num == 5) {
				bw.write(deque.size() + "\n");

			} else if (num == 6) {
				if (deque.isEmpty()) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
			} else if (num == 7) {
				if (!deque.isEmpty()) {
					bw.write(deque.peekFirst() + "\n");
				} else {
					bw.write(-1 + "\n");
				}
			} else if (num == 8) {
				if (!deque.isEmpty()) {
					bw.write(deque.peekLast() + "\n");
				} else {
					bw.write(-1 + "\n");
				}
			}
		}
		bw.flush();
	}
}