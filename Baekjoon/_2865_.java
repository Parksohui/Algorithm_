import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2865_ { // 나는 위대한 슈퍼스타K

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		double[] arr = new double[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				double score = Double.parseDouble(st.nextToken());

				if (arr[num] < score) {
					arr[num] = score;
				}
			}
		}
		Arrays.sort(arr);

		double result = 0.0;
		for (int i = n; i > n - k; i--) {
			result += arr[i];
		}
		System.out.println(String.format("%.1f", result));

	}
}
