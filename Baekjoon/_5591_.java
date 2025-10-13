import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5591_ { // 最大の和

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		int start = 0, end = k, sum = 0;
		for (int i = start; i < end; i++) {
			sum += arr[i];
		}

		int max = sum;

		while (end < n) {
			sum -= arr[start];
			start += 1;

			sum += arr[end];
			end += 1;

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}
