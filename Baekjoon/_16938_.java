import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _16938_ { // 캠프 준비
	static int arr[], n, l, r, x, result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		arr = new int[n];
		result = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		search(0, 0, arr[n-1], -1);

		System.out.println(result);
	}

	private static void search(int sum, int idx, int min, int max) {
		if (idx == n || sum > r) {
			if (sum >= l && sum <= r && max - min >= x) {
				result += 1;
			}
			return;
		}

		search(sum + arr[idx], idx + 1, Math.min(min, arr[idx]), Math.max(max, arr[idx]));
		search(sum, idx + 1, min, max);
	}
}
