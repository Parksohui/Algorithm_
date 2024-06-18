import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2072_ { // 오목
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		arr = new int[20][20];
		boolean flag = false;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (i % 2 == 1) {
				arr[x][y] = 1;
			} else {
				arr[x][y] = 2;
			}
			
			if (i < 10) {
				continue;
			}
			
			boolean temp = check(x, y, arr[x][y]);
			if (temp) {
				flag = true;
				System.out.println(i);
				break;
			}
		}
		if (!flag) {
			System.out.println(-1);
		}
	}

	private static boolean check(int x, int y, int num) {
		// 가로
		int b = y - 1;
		int cnt = 1;
		while (b > 0) {
			if (arr[x][b] == num) {
				cnt += 1;
				b -= 1;
			} else {
				break;
			}
		}
		b = y + 1;
		while (b < 20) {
			if (arr[x][b] == num) {
				cnt += 1;
				b += 1;
			} else {
				break;
			}
		}
		if (cnt == 5) {
			return true;
		}

		// 세로
		int a = x - 1;
		cnt = 1;
		while (a > 0) {
			if (arr[a][y] == num) {
				cnt += 1;
				a -= 1;
			} else {
				break;
			}
		}
		a = x + 1;
		while (a < 20) {
			if (arr[a][y] == num) {
				cnt += 1;
				a += 1;
			} else {
				break;
			}
		}
		if (cnt == 5) {
			return true;
		}

		// 대각선
		a = x - 1;
		b = y - 1;
		cnt = 1;
		while (a > 0 && b > 0) {
			if (arr[a][b] == num) {
				cnt += 1;
				a -= 1;
				b -= 1;
			} else {
				break;
			}
		}
		a = x + 1;
		b = y + 1;
		while (a < 20 && b < 20) {
			if (arr[a][b] == num) {
				cnt += 1;
				a += 1;
				b += 1;
			} else {
				break;
			}
		}
		if (cnt == 5) {
			return true;
		}

		a = x - 1;
		b = y + 1;
		cnt = 1;
		while (a > 0 && b < 20) {
			if (arr[a][b] == num) {
				cnt += 1;
				a -= 1;
				b += 1;
			} else {
				break;
			}
		}
		a = x + 1;
		b = y - 1;
		while (a < 20 && b > 0) {
			if (arr[a][b] == num) {
				cnt += 1;
				a += 1;
				b -= 1;
			} else {
				break;
			}
		}
		if (cnt == 5) {
			return true;
		}
		return false;
	}
}
