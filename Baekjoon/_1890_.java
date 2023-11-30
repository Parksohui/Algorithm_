import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1890_ { // 점프

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long move[][] = new long[n][n];
		long count[][] = new long[n][n];

		move[0][0] = 1;
		count[0][0] = 1;
		long idx = 1;
		boolean flag = false;
		long result = 0;
		ArrayList<long[]> list = new ArrayList<>();

		while (true) {
			flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == n - 1 && j == n - 1) {
						continue;
					}
					if (move[i][j] == idx) {
						if (arr[i][j] == 0) {
							continue;
						}
						flag = true;
						if (j + arr[i][j] < n) {
							list.add(new long[] { i, j + arr[i][j], count[i][j] });
						}
						if (i + arr[i][j] < n) {
							list.add(new long[] { i + arr[i][j], j, count[i][j] });
						}
					}
				}
			}
			for (long[] temp : list) {
				int a = (int) temp[0];
				int b = (int) temp[1];
				if (move[a][b] != idx + 1) {
					if (a == n - 1 && b == n - 1) {
						result += count[a][b];
					}
					count[a][b] = 0;
				}
				move[a][b] = idx + 1;
				count[a][b] += temp[2];
			}
			idx++;
			list.clear();
			if (!flag) {
				break;
			}
		}
		System.out.println(result + count[n - 1][n - 1]);
	}
}
