import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16194_ { // 카드 구매하기 2

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n+1];
		int dp[] = new int[n+1];

		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			dp[i] = num;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i+j < n+1) {
					dp[i+j] = Math.min(dp[i+j], dp[i]+arr[j]);
				}
			}
		}
		System.out.println(dp[n]);
	}
}
