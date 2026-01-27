import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501_ { // 퇴사
	static class Pair {
		int t, p;

		public Pair(int t, int p) {
			this.t = t;
			this.p = p;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		Pair arr[] = new Pair[n + 1];
		int dp[] = new int[n + 2];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		/* ex1)
		for (int i = 1; i < n + 1; i++) {
			if (i + arr[i].t < n + 2) {
				dp[i] = arr[i].p;
			}
		}

		
		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j < i; j++) {
				if (j + arr[j].t <= i && i + arr[i].t < n + 2)
					dp[i] = Math.max(dp[i], dp[j] + arr[i].p);
			}
		}
		*/

		for (int i = 1; i < n + 1; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);
			if (i + arr[i].t < n + 2) {
				dp[i + arr[i].t] = Math.max(dp[i + arr[i].t], dp[i] + arr[i].p);
			}
		}

		int result = 0;
		for (int i = 1; i < n + 2; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
