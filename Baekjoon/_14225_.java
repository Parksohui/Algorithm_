import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14225_ { // 부분수열의 합
	static int arr[], answer[], n;
	static boolean result[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());

		arr = new int[n];
		result = new boolean[2000001];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			result[arr[i]] = true;
		}
		Arrays.sort(arr);

		for (int i = 2; i <= n; i++) {
			answer = new int[i];
			search(i, 0, 0);
		}

		for (int i = 1; i < result.length; i++) {
			if (!result[i]) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void search(int max, int start, int idx) {
		if (idx == max) {
			int sum = 0;
			for (int i = 0; i < idx; i++) {
				sum += answer[i];
			}
			result[sum] = true;
			return;
		}
		for (int i = start; i < n; i++) {
			answer[idx] = arr[i];
			search(max, i + 1, idx + 1);
		}
	}
}
