import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1913_ { // 달팽이

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());

		int arr[][] = new int[n][n];
		int resultX = (n / 2) + 1, resultY = (n / 2) + 1, idx = 1, turn = 1;

		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };

		int x = n / 2, y = n / 2, dir = 0;
		arr[x][y] = idx++;
		while (idx <= n * n) {
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < turn; i++) {
					x += dx[dir];
					y += dy[dir];
					arr[x][y] = idx++;
					if (idx == m + 1) {
						resultX = x + 1;
						resultY = y + 1;
					}
					if (idx > n * n) {
						break;
					}
				}
				dir += 1;
				if (dir == 4) {
					dir = 0;
				}
				if (idx > n * n) {
					break;
				}
			}
			turn += 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.write(resultX + " " + resultY);
		bw.flush();
	}
}
