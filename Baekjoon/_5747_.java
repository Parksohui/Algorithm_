import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5747_ { // Odd or Even

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = 0;

		while ((n = Integer.parseInt(bf.readLine())) != 0) {

			int xOdd = 0, xEven = 0;

			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());

				if (num % 2 == 0) {
					xEven += 1;
				} else {
					xOdd += 1;
				}
			}

			int yOdd = 0, yEven = 0;

			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());

				if (num % 2 == 0) {
					yEven += 1;
				} else {
					yOdd += 1;
				}
			}

			bw.write(n - (Math.min(xEven, yOdd) + Math.min(xOdd, yEven)) + "\n");
		}
		bw.flush();
	}
}
