import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1996_ { // 지뢰 찾기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(bf.readLine());

		int arr[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == '.') {
					continue;
				}
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > 0) {
					bw.write("*");
					continue;
				}
				int cnt = 0;
				for (int k = 0; k < 8; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if (x >= 0 && x < N && y >= 0 && y < N) {
						cnt += arr[x][y];
					}
				}
				if (cnt >= 10) {
					bw.write("M");
				} else {
					bw.write(cnt + "");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
