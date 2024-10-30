import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _6177_ { // Statistics

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		int arr[] = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			sum += arr[i];
		}

		System.out.println((double) sum / N);

		Arrays.sort(arr);
		if (N % 2 == 0) {
			sum = arr[N / 2 - 1] + arr[N / 2];
			System.out.println((double) sum / 2);

		} else {
			System.out.println(arr[N / 2]);
		}
	}
}
