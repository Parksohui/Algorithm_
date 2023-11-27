import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11052_ { // 카드 구매하기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		int arr[] = new int[n + 1];
		int temp[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			temp[i] = num;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i + j < n+1)
					temp[i + j] = Math.max(temp[i+j], temp[i] + arr[j]);
				else
					break;
			}
		}
		System.out.println(temp[n]);
	}
}
