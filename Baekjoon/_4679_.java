import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;

public class _4679_ { // The Snail

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int H, D, F;
		Double U;

		st = new StringTokenizer(bf.readLine());
		while ((H = Integer.parseInt(st.nextToken())) != 0) {
			U = Double.parseDouble(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			F = Integer.parseInt(st.nextToken());

			double p = 0;
			int d = 0;
			double l = U * (double) F / 100;
			boolean flag = false;
			while (true) {
				d += 1;
				
				p += U;
				if (p < 0) {
					flag = true;
					break;
				}
				if (p > H) {
					break;
				}
				
				p -= D;
				if (p < 0) {
					flag = true;
					break;
				}
				if (p >= H) {
					break;
				}
				
				U -= l;
				if (U < 0) {
					U = 0.0;
				}
			}
			if (flag) {
				bw.write("failure on day " + d + "\n");
			} else {
				bw.write("success on day " + d + "\n");
			}
			st = new StringTokenizer(bf.readLine());
		}
		bw.flush();
	}
}
