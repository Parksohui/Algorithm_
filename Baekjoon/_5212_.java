import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5212_ { // 지구 온난화
	static char[][] arr, result;
	static int r, c;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[r][c];
		result = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				char x = str.charAt(j);
				arr[i][j] = x;
				result[i][j] = x;

			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(arr[i][j]=='X')
					check(i, j);
			}
		}

		int min_x = -1, min_y = -1, max_x = -1, max_y = -1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (result[i][j] == 'X') {
					if (min_x == -1 || min_x > i) {
						min_x = i;
					} 
					if (min_y == -1 || min_y > j) {
						min_y = j;
					} 
					if (max_x == -1 || max_x < i) {
						max_x = i;
					} 
					if (max_y == -1 || max_y < j) {
						max_y = j;
					}
				}
			}
		}

		for (int i = min_x; i <= max_x; i++) {
			for (int j = min_y; j <= max_y; j++) {
				bw.write(result[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
	}

	private static void check(int i, int j) {
		int num = 0;
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x < 0 || x >= r || y < 0 || y >= c) {
				num += 1;
			} else if (x >= 0 && x < r && y >= 0 && y < c && arr[x][y] == '.') {
				num += 1;
			}
		}
		if (num >= 3) {
			result[i][j] = '.';
		}
	}
}
