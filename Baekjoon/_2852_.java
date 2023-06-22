import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2852_ { // NBA 농구

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		int a = 0, b = 0, result_a = 0, result_b = 0, temp = 0, win=0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			win = Integer.parseInt(st.nextToken());

			String t = st.nextToken();
			String num[] = t.split(":");
			int time = 60 * Integer.parseInt(num[0]) + Integer.parseInt(num[1]);

			if (win == 1) {
				a += 1;
			} else {
				b += 1;
			}

			if (a > b) {
				if (i==0)
					temp = time;
				if (a - 1 < b) {
					result_b += time - temp;
					temp = time;
				} else if (win==1 && a - 1 == b) {
					temp = time;
				}
			} else if (b > a) {
				if (i == 0)
					temp = time;
				if (b - 1 < a) {
					result_a += time - temp;
					temp = time;
				} else if (win==2 && b - 1 == a) {
					temp = time;
				}
			} else if (a == b) {
				if (win ==2) {
					result_a += time - temp;
					temp = time;
				} else if (win==1) {
					result_b += time - temp;
					temp = time;
				}
			}
		}

		if (a >b) {
			result_a += 2880 - temp;
		} else if (b > a) {
			result_b += 2880 - temp;
		}

		int x = result_a / 60;
		if (x / 10 == 0) {
			bw.write("0" + x + ":");
		} else {
			bw.write(x + ":");
		}
		x = result_a % 60;
		if (x / 10 == 0) {
			bw.write("0" + x + "\n");
		} else {
			bw.write(x + "\n");
		}

		x = result_b / 60;
		if (x / 10 == 0) {
			bw.write("0" + x + ":");
		} else {
			bw.write(x + ":");
		}
		x = result_b % 60;
		if (x / 10 == 0) {
			bw.write("0" + x + "\n");
		} else {
			bw.write(x + "\n");
		}
		bw.flush();
	}

}
