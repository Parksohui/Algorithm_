import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2294_ { // 동전 2

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		int dp[] = new int[k + 1];
		for (int i = 1; i < k + 1; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < k + 1; i++) {
			for (int j = 0; j < n; j++) {
				if (i - arr[j] < 0 || dp[i - arr[j]] == Integer.MAX_VALUE) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
			}
		}

		if (dp[k] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
	}
}
