import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2696_ { // 중앙값 구하기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();

		for (int i = 0; i < t; i++) {
			int m = Integer.parseInt(bf.readLine());

			bw.write(Integer.toString(m / 2 + 1) + "\n");
			int idx = 0;
			for (int j = 0; j < (m / 10 + 1); j++) {
				st = new StringTokenizer(bf.readLine());

				while (st.hasMoreTokens()) {
					int num = Integer.parseInt(st.nextToken());
					idx += 1;

					if (left.size() == 0)
						left.add(num);
					else {
						if ((right.size() > 0 && right.peek() >= num) || left.peek() > num) {
							left.add(num);
						} else {
							right.add(num);
						}

						if (left.size() - right.size() > 1) {
							int temp = left.poll();
							right.add(temp);
						} else if (right.size() - left.size() > 1) {
							int temp = right.poll();
							left.add(temp);
						}
					}

					if (idx % 2 == 1) {
						if (left.size() > right.size()) {
							bw.write(Integer.toString(left.peek()) + " ");
						} else {
							bw.write(Integer.toString(right.peek()) + " ");
						}
						if ((idx / 2 + 1) % 10 == 0)
							bw.write("\n");
					}
				}
			}

			bw.append("\n");
			left.clear();
			right.clear();
		}
		bw.flush();
	}

}
