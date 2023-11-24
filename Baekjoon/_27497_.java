import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class _27497_ { // 알파벳 블록

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		Deque<Character> deque = new ArrayDeque<>();
		Stack<Boolean> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1 || cmd == 2) {
				char x = st.nextToken().charAt(0);
				if (cmd == 1) {
					stack.add(false);
					deque.addLast(x);
				} else {
					stack.add(true);
					deque.addFirst(x);
				}
			} else {
				if (deque.isEmpty()) {
					continue;
				}
				boolean flag = stack.pop();
				if (flag) {
					deque.removeFirst();
				} else {
					deque.removeLast();
				}
			}
		}

		if (deque.isEmpty()) {
			bw.write("0");
		} else {
			while (!deque.isEmpty()) {
				bw.write(deque.pollFirst());
			}
		}
		bw.flush();
	}
}
