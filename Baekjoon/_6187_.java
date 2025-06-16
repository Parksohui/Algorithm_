import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6187_ { // Going to the Movies
	static int result, C;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		result = 0;
		recursion(0, 0);

		System.out.println(result);
	}

	private static void recursion(int idx, int sum) {
		if (idx >= arr.length) {
			return;
		}
		if (sum + arr[idx] <= C) {
			result = Math.max(result, sum + arr[idx]);
			recursion(idx + 1, sum + arr[idx]);
		}
		recursion(idx + 1, sum);
	}
}
