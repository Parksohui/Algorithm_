import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _9711_ { // 피보나치

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		int arr[][] = new int[2][t];
		int max = 0;

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[0][i]);
		}

		BigInteger dp[] = new BigInteger[max + 1];
		dp[1] = BigInteger.valueOf(1);
		dp[2] = BigInteger.valueOf(1);
		for (int i = 3; i < max + 1; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}

		for (int i = 0; i < t; i++) {
			bw.write("Case #" + (i + 1) + ": " + (dp[arr[0][i]].mod(BigInteger.valueOf(arr[1][i]))) + "\n");
		}
		bw.flush();
	}
}
