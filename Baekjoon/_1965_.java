import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1965_ { // 상자넣기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int box[] = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}

		int dp[] = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (box[j] < box[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int result = 1;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
	}
}
