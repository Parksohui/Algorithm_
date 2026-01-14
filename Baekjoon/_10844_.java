import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844_ { // 쉬운 계단 수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		int dp[][] = new int[n + 1][10];

		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < 10; j++) {
				if (j != 9) {
					dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % 1000000000;
				}
				if (j != 0) {
					dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000000;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < 10; i++) {
			result = (result + dp[n][i]) % 1000000000;
		}
		System.out.println(result);
	}
}
