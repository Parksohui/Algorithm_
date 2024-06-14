import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12887_ { // 경로 게임
	static boolean arr[][];
	static int dx[] = { 0, -1, 1 };
	static int dy[] = { 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(bf.readLine());

		arr = new boolean[2][m];

		int black = 0;
		for (int i = 0; i < 2; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '#') {
					arr[i][j] = true;
					black += 1;
				} else {
					arr[i][j] = false;
				}
			}
		}

		int result = 0;

		if (!arr[0][0]) {
			int cnt = check(0, 0);
			if (result < 2 * m - cnt - black) {
				result = 2 * m - cnt - black;
			}
		}

		if (!arr[1][0]) {
			int cnt = check(1, 0);
			if (result < 2 * m - cnt - black) {
				result = 2 * m - cnt - black;
			}
		}
		System.out.println(result);
	}

	private static int check(int x, int y) {

		int cnt = 1;

		while (y < arr[0].length - 1) {
			for (int i = 0; i < 3; i++) {
				int a = x + dx[i];
				int b = y + dy[i];
				if (a >= 0 && a < 2 && b >= 0 && b < arr[0].length && !arr[a][b]) {
					cnt += 1;
					if (b == arr[0].length - 1) {
						return cnt;
					}
					x = a;
					y = b;
					break;
				}
			}
		}
		return cnt;
	}
}
