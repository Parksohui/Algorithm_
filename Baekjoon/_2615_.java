import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2615_ { // 오목
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		arr = new int[20][20];
		for (int i = 1; i <= 19; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean flag = false;
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				if (arr[i][j] != 0) {
					int temp[]=search(i, j, arr[i][j]);
					if (temp != null) {
						flag = true;
						bw.write(arr[i][j] + "\n");
						bw.write(temp[0] + " " + temp[1]);
						break;
					}
				}
			}
			if (flag) {
				break;
			}
		}
		if (!flag) {
			bw.write("0");
		}
		bw.flush();
	}

	private static int[] search(int i, int j, int num) {
		int resultX = 20, resultY = 20;

		// 가로
		int x = i, y = j, cnt = 0;
		while (y < 20) {
			if (arr[x][y] == num) {
				resultY = Math.min(resultY, y);
				cnt += 1;
				y += 1;
			} else {
				break;
			}
		}
		y = j - 1;
		while (y >= 0) {
			if (arr[x][y] == num) {
				resultY = Math.min(resultY, y);
				cnt += 1;
				y -= 1;
			} else {
				break;
			}
		}
		if (cnt == 5) {
			return new int[] { x, resultY };
		}

		// 세로
		resultY = 20;
		y = j;
		cnt = 0;
		while (x < 20) {
			if (arr[x][y] == num) {
				resultX = Math.min(resultX, x);
				cnt += 1;
				x += 1;
			} else {
				break;
			}
		}
		x = i - 1;
		while (x >= 0) {
			if (arr[x][y] == num) {
				resultX = Math.min(resultX, x);
				cnt += 1;
				x -= 1;
			} else {
				break;
			}
		}
		if (cnt == 5) {
			return new int[] { resultX, y };
		}

		// 대각선
		resultX = 20;
		x = i;
		cnt = 0;
		while (x < 20 && y < 20) {
			if (arr[x][y] == num) {
				if (resultY > y) {
					resultX = x;
					resultY = y;
				}
				cnt += 1;
				x += 1;
				y += 1;
			} else {
				break;
			}
		}
		x = i - 1;
		y = j - 1;
		while (x >= 0 && y >= 0) {
			if (arr[x][y] == num) {
				if (resultY > y) {
					resultX = x;
					resultY = y;
				}
				cnt += 1;
				x -= 1;
				y -= 1;
			} else {
				break;
			}
		}
		if (cnt == 5) {
			return new int[] { resultX, resultY };
		}

		resultX = 20;
		resultY = 20;
		x = i;
		y = j;
		cnt = 0;
		while (x < 20 && y >= 0) {
			if (arr[x][y] == num) {
				if (resultY > y) {
					resultX = x;
					resultY = y;
				}
				cnt += 1;
				x += 1;
				y -= 1;
			} else {
				break;
			}
		}
		x = i - 1;
		y = j + 1;
		while (x >= 0 && y < 20) {
			if (arr[x][y] == num) {
				if (resultY > y) {
					resultX = x;
					resultY = y;
				}
				cnt += 1;
				x -= 1;
				y += 1;
			} else {
				break;
			}
		}
		if (cnt == 5) {
			return new int[] { resultX, resultY };
		}
		return null;
	}
}
