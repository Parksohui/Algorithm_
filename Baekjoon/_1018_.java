import java.io.*;
import java.util.*;

public class _1018_ { // 체스판 다시 칠하기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char arr[][] = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		char temp[][] = new char[8][8];
		int result = n * m;
		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				for (int x = i; x < i + 8; x++) {
					for (int y = j; y < j + 8; y++) {
						temp[x - i][y - j] = arr[x][y];
					}
				}
				int cnt = 0;
				char c[] = new char[] { 'B', 'W' };
				int idx = 0;

				for (int x = 0; x < 8; x++) {
					if (x % 2 == 0) {
						idx = 0;
					} else {
						idx = 1;
					}
					for (int y = 0; y < 8; y++) {
						if (x % 2 == 0) {
							if (temp[x][y] != c[idx++]) {
								cnt += 1;
							}
							if (idx == 2) {
								idx = 0;
							}
						} else {
							if (temp[x][y] != c[idx--]) {
								cnt += 1;
							}
							if (idx == -1) {
								idx = 1;
							}
						}
					}
				}
				result = Math.min(result, cnt);

				cnt = 0;
				for (int x = 0; x < 8; x++) {
					if (x % 2 == 0) {
						idx = 1;
					} else {
						idx = 0;
					}
					for (int y = 0; y < 8; y++) {
						if (x % 2 == 0) {
							if (temp[x][y] != c[idx--]) {
								cnt += 1;
							}
							if (idx == -1) {
								idx = 1;
							}
						} else {
							if (temp[x][y] != c[idx++]) {
								cnt += 1;
							}
							if (idx == 2) {
								idx = 0;
							}
						}
					}
				}
				result = Math.min(result, cnt);
			}
		}
		System.out.println(result);
	}
}
