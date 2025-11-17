import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _11254_ { // Hydraulic Arm

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			int cnt = 1;
			Stack<Integer> shelf = new Stack<>();
			Queue<Integer> belt = new LinkedList<>();

			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				belt.add(Integer.parseInt(st.nextToken()));
			}

			boolean flag = false;
			while (cnt <= n) {
				if (!belt.isEmpty() && belt.peek() == cnt) {
					belt.poll();
					cnt += 1;
				} else if (!shelf.isEmpty() && shelf.peek() == cnt) {
					shelf.pop();
					cnt += 1;
				} else {
					if (!belt.isEmpty()) {
						shelf.add(belt.poll());
					} else {
						flag = true;
						break;
					}
				}
			}
			if (flag) {
				bw.write("no\n");
			} else {
				bw.write("yes\n");
			}
		}
		bw.flush();
	}
}
