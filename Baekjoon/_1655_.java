import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class _1655_ { // 가운데를 말해요

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(bf.readLine());

			if (left.size() < 1) {
				left.add(num);
			} else {
				if ((right.size()>0 && right.peek() >= num)|| left.peek()>=num)
					left.add(num);
				else
					right.add(num);

				if (left.size() - right.size() > 1) {
					int temp = left.poll();
					right.add(temp);
				} else if (right.size() - left.size() > 1) {
					int temp = right.poll();
					left.add(temp);
				}
			}
			if ((i + 1) % 2 == 0) {
				bw.write(Integer.toString(left.peek()) + "\n");
			} else {
				if (left.size() > right.size())
					bw.write(Integer.toString(left.peek()) + "\n");
				else
					bw.write(Integer.toString(right.peek()) + "\n");
			}
		}
		bw.flush();
	}

}
