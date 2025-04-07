import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _12005_ { // Diamond Collector (Bronze)

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr);

		int result = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = i + 1; j < N; j++) {
				if (arr[j] - arr[i] <= K) {
					cnt += 1;
				}
			}
			result = Math.max(result, cnt + 1);
		}
		System.out.println(result);
	}
}
