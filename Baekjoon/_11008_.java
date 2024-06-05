import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _11008_ { // 복붙의 달인

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(bf.readLine());

			String s = st.nextToken();
			String p = st.nextToken();

			int time = 0, idx = 0;

			while (idx < s.length()) {
				if (idx + p.length() - 1 < s.length() && s.substring(idx, idx + p.length()).equals(p)) {
					idx += p.length();
				} else {
					idx += 1;
				}
				time += 1;
			}
			bw.write(time + "\n");
		}
		bw.flush();
	}
}
