import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11055_ { // 가장 큰 증가하는 부분 수열

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		int sum[] = new int[n];
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			sum[i] = num;
		}

		int result = sum[0];
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] < arr[j] && sum[i] + arr[j] > sum[j]) {
					sum[j] = sum[i] + arr[j];
					result = Math.max(sum[j], result);
				}
			}
		}

		System.out.println(result);
	}
}
