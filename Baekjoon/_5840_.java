import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5840_ { // Breed Proximity

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		int result = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= K; j++) {
				if (i + j < N) {
					if (arr[i] == arr[i + j]) {
						result = Math.max(result, arr[i]);
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
