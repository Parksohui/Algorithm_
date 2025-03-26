import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24755_ { // Election Paradox

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int result = 0;
		for (int i = 0; i <= N / 2; i++) {
			if (arr[i] % 2 == 0) {
				result += arr[i] / 2 - 1;
			} else {
				result += arr[i] / 2;
			}
		}
		for (int i = N / 2 + 1; i < N; i++) {
			result += arr[i];
		}

		System.out.println(result);
	}
}
