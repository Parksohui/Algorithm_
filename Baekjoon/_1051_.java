import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1051_ { // 숫자 정사각형

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int arr[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int result = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int size = 1;
				while (i + size < n && j + size < m) {

					if (arr[i][j] == arr[i + size][j] && arr[i][j] == arr[i][j + size]
							&& arr[i][j] == arr[i + size][j + size]) {
						result = Math.max(result, size + 1);
					}
					size += 1;
				}
			}
		}
		System.out.println(result * result);
	}
}
