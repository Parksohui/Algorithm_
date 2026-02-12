import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19622_ { // 회의실 배정 3
	static class Info {
		int start;
		int end;
		int num;

		public Info(int start, int end, int num) {
			this.start = start;
			this.end = end;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		Info arr[] = new Info[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		int dp[] = new int[n];
		dp[0] = arr[0].num;

		if (n > 1) {
			dp[1] = Math.max(dp[0], arr[1].num);
		}

		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i].num, dp[i - 1]);
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);
	}
}
