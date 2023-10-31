import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1817_ { // 짐 챙기는 숌

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int result = 0;

		if (n > 0) {
			st = new StringTokenizer(bf.readLine());

			int w = m;
			result = 1;

			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken());
				if (w >= x) {
					w -= x;
				} else {
					result += 1;
					w = m - x;
				}
			}
		}
		System.out.println(result);
	}
}
