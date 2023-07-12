import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21921_ { // 블로그

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());
		int arr[] = new int[n];

		int sum = 0, idx = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (idx < x) {
				sum += arr[i];
				idx += 1;
			}
		}
		int max = sum, cnt = 1;

		for (int i = 1; i < n - x + 1; i++) {
			sum -= arr[i - 1];
			sum += arr[i + x - 1];
			if (max < sum) {
				max = sum;
				cnt = 1;
			} else if (max == sum) {
				cnt += 1;
			}
		}

		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
