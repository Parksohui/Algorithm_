import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _6123_ { // O Those Fads

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr);

		int result = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (i != 0 && arr[i] != arr[i - 1]) {
				result += cnt;
				L += (K * cnt);
				cnt = 0;
			}
			if (arr[i] <= L) {
				cnt += 1;
			}
		}
		result += cnt;

		System.out.println(result);
	}
}
