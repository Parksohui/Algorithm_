import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _23300_ { // 웹 브라우저 2

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		Deque<Integer> back = new ArrayDeque<>();
		Deque<Integer> front = new ArrayDeque<>();

		int now = -1;

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(bf.readLine());
			char cmd = st.nextToken().charAt(0);

			if (cmd == 'B') {
				if (!back.isEmpty()) {
					front.add(now);
					now = back.pollLast();
				}
			} else if (cmd == 'F') {
				if (!front.isEmpty()) {
					back.add(now);
					now = front.pollLast();
				}
			} else if (cmd == 'A') {
				int num = Integer.parseInt(st.nextToken());
				front.clear();

				if (now != -1) {
					back.add(now);
				}

				now = num;

			} else if (cmd == 'C') {
				Deque<Integer> temp = new ArrayDeque<>();
				for (int x : back) {
					if (temp.isEmpty()) {
						temp.add(x);
					} else {
						if (temp.peekLast() != x) {
							temp.add(x);
						}
					}
				}
				back = temp;
			}
		}

		bw.write(now + "\n");

		if (back.isEmpty()) {
			bw.write(-1 + "\n");
		} else {
			Iterator<Integer> iter1 = back.descendingIterator();
			while (iter1.hasNext()) {
				bw.write(iter1.next() + " ");
			}
			bw.write("\n");
		}

		if (front.isEmpty()) {
			bw.write(-1 + "\n");
		} else {
			Iterator<Integer> iter2 = front.descendingIterator();
			while (iter2.hasNext()) {
				bw.write(iter2.next() + " ");
			}
		}
		bw.flush();
	}
}
