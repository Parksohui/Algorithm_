import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15705_ { // 단어 찾기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String S = bf.readLine();

		st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char arr[][] = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != S.charAt(0)) {
					continue;
				}
				if (S.length() == 1 || flag) {
					flag = true;
					break;
				}
				for (int k = 0; k < 8; k++) {
					int x = i, y = j, idx = 1;
					while (true) {
						x += dx[k];
						y += dy[k];
						if (x >= 0 && x < N && y >= 0 && y < M && arr[x][y] == S.charAt(idx)) {
							idx++;
						} else {
							break;
						}
						if (idx == S.length()) {
							flag = true;
							break;
						}
					}
					if (flag) {
						break;
					}
				}
			}
			if (flag) {
				break;
			}
		}
		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
