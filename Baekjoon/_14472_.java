import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14472_ { // 休憩スペース (Refreshment Area)

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		char arr[][] = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int result = 0;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '#') {
					continue;
				}

				for (int k = 0; k < D; k++) {
					if (j + k >= M || arr[i][j + k] == '#') {
						flag = true;
						break;
					}
				}

				if (!flag) {
					result += 1;
				}
				flag = false;

				for (int k = 0; k < D; k++) {
					if (i + k >= N || arr[i + k][j] == '#') {
						flag = true;
						break;
					}
				}

				if (!flag) {
					result += 1;
				}
				flag = false;
			}
		}
		System.out.println(result);
	}
}
