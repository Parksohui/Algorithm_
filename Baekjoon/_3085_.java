import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3085_ { // 사탕 게임
	static char arr[][];
	static int n, max;
	static int dx[] = { 1, 0 };
	static int dy[] = { 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		arr = new char[n][n];
		max = 0;

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		candy();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				change(i, j);
			}
		}
		System.out.println(max);
	}

	private static void change(int x, int y) {
		for (int i = 0; i < 2; i++) {
			int a = x + dx[i];
			int b = y + dy[i];

			if (a >= 0 && a < n && b >= 0 && b < n && arr[x][y] != arr[a][b]) {
				char tempx = arr[x][y];
				char tempy = arr[a][b];

				arr[x][y] = tempy;
				arr[a][b] = tempx;

				candy();

				arr[x][y] = tempx;
				arr[a][b] = tempy;
			}
		}

	}

	private static void candy() {
		char x, y;
		int cnt1, cnt2;

		for (int i = 0; i < n; i++) {
			x = arr[i][0];
			y = arr[0][i];
			cnt1 = 1;
			cnt2 = 1;
			for (int j = 1; j < n; j++) {
				if (arr[i][j] == x) {
					cnt1 += 1;
				} else {
					if (max < cnt1) {
						max = cnt1;
					}
					x = arr[i][j];
					cnt1 = 1;
				}

				if (arr[j][i] == y) {
					cnt2 += 1;
				} else {
					if (max < cnt2) {
						max = cnt2;
					}
					y = arr[j][i];
					cnt2 = 1;
				}
			}
			if (max < cnt1) {
				max = cnt1;
			}
			if (max < cnt2) {
				max = cnt2;
			}
		}
	}
}
