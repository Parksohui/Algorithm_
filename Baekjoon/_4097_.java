import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _4097_ { // 수익

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = 0;

		while ((n = Integer.parseInt(bf.readLine())) != 0) {

			int arr[] = new int[n];
			int dp[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(bf.readLine());
				dp[i] = arr[i];
			}

			int result = Integer.MIN_VALUE;

			for (int i = 1; i < n; i++) {
				dp[i] = Math.max(dp[i], dp[i - 1] + arr[i]);
				result = Math.max(result, dp[i]);
			}

			bw.write(result + "\n");
		}
		bw.flush();
	}
}
