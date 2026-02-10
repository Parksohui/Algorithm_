import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5953_ { // Profits

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		int dp[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			dp[i] = arr[i];
		}

		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1] + arr[i]);
		}

		int result = dp[0];
		for (int i = 1; i < n; i++) {
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);

	}

}
