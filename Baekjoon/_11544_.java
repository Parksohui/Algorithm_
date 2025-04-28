import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11544_ { // D as in Daedalus

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int result = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());

			int b = Integer.parseInt(st.nextToken());

			int c1 = Integer.parseInt(st.nextToken());

			int sum = 0;
			for (int j = 0; j < n - 1; j++) {
				sum += Integer.parseInt(st.nextToken());
			}

			int expect = 0;
			if (b > sum) {
				int temp = b - sum;

				if (temp >= 10000) {
					expect = 10000;
				} else if (temp >= 1000) {
					expect = 1000;
				} else if (temp >= 100) {
					expect = 100;
				} else if (temp >= 10) {
					expect = 10;
				} else if (temp >= 1) {
					expect = 1;
				}
			}

			int temp = 0;
			sum += c1;
			if (b >= sum) {
				temp = c1;
			}

			result += (expect - temp);
		}
		System.out.println(result);
	}
}
