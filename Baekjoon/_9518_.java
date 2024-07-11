import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9518_ { // 로마 카톨릭 미사

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int R = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		char arr[][] = new char[R][S];
		for (int i = 0; i < R; i++) {
			String str = bf.readLine();
			for (int j = 0; j < S; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int max = 0, result = 0;
		boolean visited[][] = new boolean[R][S];
		int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < S; j++) {
				if (arr[i][j] == 'o') {
					visited[i][j] = true;
					for (int k = 0; k < 8; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if (x >= 0 && x < R && y >= 0 && y < S && arr[x][y] == 'o' && !visited[x][y]) {
							result += 1;
						}
					}
					continue;
				}
				int cnt = 0;
				for (int k = 0; k < 8; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if (x >= 0 && x < R && y >= 0 && y < S && arr[x][y] == 'o') {
						cnt += 1;
					}
				}
				if (cnt > max) {
					max = cnt;
				}
			}
		}
		System.out.println(result + max);
	}
}
