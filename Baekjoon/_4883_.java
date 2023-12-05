import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _4883_ { // 삼각 그래프
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int dx[] = { 0, 1, 1, 1 };
		int dy[] = { 1, 1, 0, -1 };

		int arr[][], result[][];
		int n = 0;
		int idx = 1;
		
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			arr = new int[n][3];
			result = new int[n][3];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 3; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					result[i][j]=Integer.MAX_VALUE;
				}
			}

			result[0][1] = arr[0][1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 3; j++) {
					if (result[i][j] != Integer.MAX_VALUE) {
						for (int k = 0; k < 4; k++) {
							int x = i + dx[k];
							int y = j + dy[k];
							if (x >= 0 && x < n && y >= 0 && y < 3) {
								if (result[x][y] == Integer.MAX_VALUE || (result[x][y] > result[i][j] + arr[x][y])) {
									result[x][y] = result[i][j] + arr[x][y];
								}
							}
						}
					}
				}
			}
			bw.write(idx++ + ". " + result[n - 1][1] + "\n");
		}
		bw.flush();
	}
}
