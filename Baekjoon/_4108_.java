import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _4108_ { // 지뢰찾기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

		int r, c, cnt = 0;
		while ((r = (Integer.parseInt(st.nextToken()))) != 0 && (c = (Integer.parseInt(st.nextToken()))) != 0) {
			char arr[][] = new char[r][c];

			for (int i = 0; i < r; i++) {
				String str = bf.readLine();
				for (int j = 0; j < c; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					cnt = 0;
					if (arr[i][j] == '*') {
						bw.write("*");
						continue;
					}
					for (int k = 0; k < 8; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if (x >= 0 && x < r && y >= 0 && y < c && arr[x][y] == '*') {
							cnt += 1;
						}
					}
					bw.write(cnt+"");
				}
				bw.write("\n");
			}
			st = new StringTokenizer(bf.readLine());
		}
		bw.flush();
	}
}
