import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11054_ { // 가장 긴 바이토닉 부분 수열

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int a[] = new int[n];
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int dp1[] = new int[n];
		int dp2[] = new int[n];

		for (int i = 0; i < n; i++) {
			dp1[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
				}
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			dp2[i] = 1;
			for (int j = n - 1; j > i; j--) {
				if (a[i] > a[j]) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				}
			}
		}

		int result = 1;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp1[i]);
			result = Math.max(result, dp2[i]);
			result = Math.max(result, dp1[i] + dp2[i] - 1);
		}

		System.out.println(result);
	}
}
