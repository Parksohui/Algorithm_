import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _16918_ { // 봄버맨
	static int arr[][], r, c;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				if (str.charAt(j) == 'O')
					arr[i][j] = 1;
			}
		}

		int time = 1;
		boolean flag = false;
		while (time < n) {
			time += 1;
			if (time % 2 == 0) {
				int temp = 2;
				if (flag)
					temp = 1;
				fill(temp);
			} else {
				if (!flag) {
					bomber(1);
					flag = true;
				} else {
					bomber(2);
					flag = false;
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 0) {
					bw.write(".");
				} else {
					bw.write("O");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}

	private static void fill(int num) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 0)
					arr[i][j] = num;
			}
		}
	}

	private static void bomber(int num) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == num) {
					arr[i][j] = 0;
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if (x >= 0 && x < r && y >= 0 && y < c && arr[x][y] != num) {
							arr[x][y] = 0;
						}
					}
				}
			}
		}
	}
}
