import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11968_ { // High Card Wins

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		int a[] = new int[N];
		int b[] = new int[N];

		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(a);

		int num = 1, idxA = 0, idxB = 0;
		while (num <= 2 * N) {
			if (idxA<N && num == a[idxA]) {
				num += 1;
				idxA += 1;
			} else {
				b[idxB++] = num++;
			}
		}

		idxA = N - 1;
		idxB = N - 1;
		int result = 0;
		while (idxA >= 0) {
			if (a[idxA] < b[idxB]) {
				idxB -= 1;
				result += 1;
			}
			idxA -= 1;
		}
		System.out.println(result);
	}
}
