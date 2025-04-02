import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3211_ { // kino

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr);

		int result = 0;
		int max = arr[0];
		while (result < N) {
			result += (max - result);
			max = Math.max(max, arr[result]);

			if (result >= max) {
				break;
			}
		}
		System.out.println(result + 1);
	}
}
