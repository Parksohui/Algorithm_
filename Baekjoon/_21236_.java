import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _21236_ { // Comfortable Cows

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[][] = new int[1001][1001];

		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				arr[i][j] = -1;
			}
		}

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		int result = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[x][y] = 0;

			for (int j = 0; j < 4; j++) {
				int x1 = x + dx[j];
				int y1 = y + dy[j];

				if (x1 >= 0 && x1 < 1001 && y1 >= 0 && y1 < 1001) {
					if (arr[x1][y1] > -1) {
						arr[x][y] += 1;

						if (arr[x1][y1] == 3) {
							result -= 1;
						}
						arr[x1][y1] += 1;

						if (arr[x1][y1] == 3) {
							result += 1;
						}
					}
				}
			}

			if (arr[x][y] == 3) {
				result += 1;
			}

			bw.write(result + "\n");
		}
		bw.flush();
	}
}
