import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10571_ { // 다이아몬드
	static class Pair {
		double w, c;

		public Pair(double w, double c) {
			this.w = w;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			Pair arr[] = new Pair[n];
			int dp[] = new int[n];

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(bf.readLine());
				arr[j] = new Pair(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
				dp[j] = 1;
			}

			for (int j = 1; j < n; j++) {
				for (int k = 0; k < j; k++) {
					if (arr[k].w < arr[j].w && arr[k].c > arr[j].c) {
						dp[j] = Math.max(dp[j], dp[k] + 1);
					}
				}
			}

			int result = 0;
			for (int j = 0; j < n; j++) {
				result = Math.max(result, dp[j]);
			}
			bw.write(result + "\n");
		}
		bw.flush();
	}
}
