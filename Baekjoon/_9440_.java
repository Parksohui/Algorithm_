import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _9440_ { // 숫자 더하기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String input = "";
		int zero = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		while (!(input = (bf.readLine())).equals("0")) {
			st = new StringTokenizer(input);

			int n = Integer.parseInt(st.nextToken());

			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());

				if (num != 0) {
					queue.add(num);
				} else {
					zero += 1;
				}
			}

			String str1 = "";
			String str2 = "";
			boolean flag = false;

			while (!queue.isEmpty()) {
				if (!flag) {
					if (str1.length() > 0 && zero > 0) {
						str1 += "0";
						zero -= 1;
					} else {
						str1 += Integer.toString(queue.poll());
					}
					flag = true;
				} else {
					if (str2.length() > 0 && zero > 0) {
						str2 += "0";
						zero -= 1;
					} else {
						str2 += Integer.toString(queue.poll());
					}
					flag = false;
				}
			}

			while (zero > 0) {
				if (str1.length() > str2.length()) {
					str2 += "0";
				} else {
					str1 += "0";
				}
				zero-=1;
			}

			bw.write((Integer.parseInt(str1) + Integer.parseInt(str2)) + "\n");

		}
		bw.flush();
	}
}
