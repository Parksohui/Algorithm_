import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6193_ { // Hungry Cows

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		int idx = 0;
		int range = n / 20;
		if (n % 20 != 0) {
			range += 1;
		}

		for (int i = 0; i < range; i++) {
			st = new StringTokenizer(bf.readLine());
			while (st.hasMoreTokens()) {
				arr[idx++] = Integer.parseInt(st.nextToken());
			}
		}

		int dp[] = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);
	}
}
