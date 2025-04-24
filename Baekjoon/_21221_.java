import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _21221_ { // Bold

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char arr[][] = new char[n][m];

		int dx[] = { 0, 1, 1 };
		int dy[] = { 1, 0, 1 };

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '.' && arr[i][j] == '#') {
					continue;
				}
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == '#') {
					for (int k = 0; k < 3; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if (x >= 0 && x < n && y >= 0 && y < m) {
							arr[x][y] = '#';
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.write(arr[i][j] + "");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
