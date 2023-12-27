import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2847_ { // 게임을 만든 동준이

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		int result = 0;
		if (n > 2) {
			for (int i = n - 2; i >= 0; i--) {
				if (arr[i + 1] <= arr[i]) {
					result += arr[i] - arr[i + 1] + 1;
					arr[i] = arr[i + 1] - 1;
				}
			}
		}
		System.out.println(result);
	}
}
