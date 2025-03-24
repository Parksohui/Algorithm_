import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11597_ { // Excellence

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr);

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n / 2; i++) {
			result = Math.min(result, arr[i] + arr[n - 1 - i]);
		}

		System.out.println(result);
	}
}
