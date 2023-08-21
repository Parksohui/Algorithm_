import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _23294_ { // 웹 브라우저 1

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int cap[] = new int[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i < n + 1; i++) {
			cap[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> back = new ArrayDeque<>();
		Deque<Integer> front = new ArrayDeque<>();

		int now = -1;
		int front_size = 0;
		int back_size = 0;

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(bf.readLine());
			char cmd = st.nextToken().charAt(0);

			if (cmd == 'B') {
				if (!back.isEmpty()) {
					front.add(now);
					front_size += cap[now];
					back_size -= cap[back.peekLast()];
					now = back.pollLast();
				}
			} else if (cmd == 'F') {
				if (!front.isEmpty()) {
					back.add(now);
					back_size += cap[now];
					front_size -= cap[front.peekLast()];
					now = front.pollLast();
				}
			} else if (cmd == 'A') {
				int num = Integer.parseInt(st.nextToken());
				front_size = 0;
				front.clear();

				if (now != -1) {
					back.add(now);
					back_size += cap[now];
				}

				now = num;

				while (front_size + back_size + cap[now] > c) {
					back_size -= cap[back.pollFirst()];
				}
			} else if (cmd == 'C') {
				Deque<Integer> temp = new ArrayDeque<>();
				for (int x : back) {
					if (temp.isEmpty()) {
						temp.add(x);
					} else {
						if (temp.peekLast() != x) {
							temp.add(x);
						} else {
							back_size -= cap[x];
						}
					}
				}
				back = temp;
			}
		}

		bw.write(now + "\n");

		if (back.isEmpty()) {
			bw.write(-1+"\n");
		} else {
			Iterator<Integer> iter1 = back.descendingIterator();
			while (iter1.hasNext()) {
				bw.write(iter1.next() + " ");
			}
			bw.write("\n");
		}

		
		if (front.isEmpty()) {
			bw.write(-1+"\n");
		} else {
			Iterator<Integer> iter2 = front.descendingIterator();
			while (iter2.hasNext()) {
				bw.write(iter2.next() + " ");
			}
		}
		bw.flush();
	}
}
