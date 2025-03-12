import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _12724_ { // Minimum Scalar Product (Large)

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(bf.readLine());

			Integer v1[] = new Integer[n];
			Integer v2[] = new Integer[n];

			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				v1[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				v2[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(v1);
			Arrays.sort(v2, Collections.reverseOrder());

			long sum = 0;
			for (int j = 0; j < n; j++) {
				sum += new Long(v1[j]) * new Long(v2[j]);
			}
			bw.write("Case #" + (i + 1) + ": " + sum + "\n");
		}
		bw.flush();
	}
}
