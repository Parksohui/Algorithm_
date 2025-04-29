import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _4335_ { // 숫자 맞추기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = 0, start = 0, end = 11, result = 0;
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			st = new StringTokenizer(bf.readLine());

			String a = st.nextToken();
			String b = st.nextToken();

			if (b.equals("high")) {
				end = Math.min(end, n);
			} else if (b.equals("low")) {
				start = Math.max(start, n);
			} else {
				result = n;

				if (n > start && n < end) {
					bw.write("Stan may be honest\n");
				} else {
					bw.write("Stan is dishonest\n");
				}
				start = 0;
				end = 11;
			}
		}
		bw.flush();
	}
}
