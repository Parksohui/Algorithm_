import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17550_ { // Inquiry I

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		long square[] = new long[n + 1];
		long sum[] = new long[n + 1];

		for (int i = 1; i < n + 1; i++) {
			square[i] = (arr[i] * arr[i]) + square[i - 1];
			sum[i] = arr[i] + sum[i - 1];
		}

		long result = 0;
		for (int i = 1; i < n; i++) {
			result = Math.max(result, square[i] * (sum[n] - sum[i]));
		}

		System.out.println(result);

	}
}
