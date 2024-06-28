import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _4396_ { // 지뢰 찾기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int result[][] = new int[n][n];
		int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
		int cnt = 0;
		boolean flag = false;

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < n; j++) {
				if (str.charAt(j) == 'x') {
					if (arr[i][j] == '*') {
						flag = true;
						continue;
					}
					cnt = 0;
					for (int k = 0; k < 8; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if (x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == '*') {
							cnt += 1;
						}
					}
					result[i][j] = cnt;
				} else {
					result[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (flag && arr[i][j] == '*') {
					bw.write("*");
					continue;
				}
				if (result[i][j] == -1) {
					bw.write(".");
					continue;
				}
				bw.write(result[i][j] + "");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
