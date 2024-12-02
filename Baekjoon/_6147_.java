import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _6147_ { // Bookshelf

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr, Collections.reverseOrder());

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			if (sum >= B) {
				System.out.println(i + 1);
				break;
			}
		}
	}
}
