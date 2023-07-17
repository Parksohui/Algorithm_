import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _19638_ { // 센티와 마법의 뿅망치

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(bf.readLine()));
		}

		boolean flag = false;
		for (int i = 0; i < t; i++) {
			if (queue.peek() < h) {
				bw.write("YES\n");
				bw.write(Integer.toString(i));
				flag = true;
				break;
			}
			if (queue.peek() == 1)
				break;
			int num = queue.poll();
			queue.add(num / 2);
		}

		if (!flag) {
			if (queue.peek() < h) {
				bw.write("YES\n");
				bw.write(Integer.toString(t));
			} else {
				bw.write("NO\n");
				bw.write(Integer.toString(queue.peek()));
			}

		}
		bw.flush();
	}
}
