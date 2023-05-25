import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1937_ { // 욕심쟁이 판다 
	static int arr[][], dp[][], n, result;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		result = 1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dfs(i, j);
			}
		}

		System.out.println(result);
	}

	private static int dfs(int i, int j) {
		int max_value = 1;
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x >= 0 && x < n && y >= 0 && y < n && arr[i][j] < arr[x][y]) {

				if (dp[x][y] > 1) {
					if (max_value < 1 + dp[x][y])
						max_value = 1 + dp[x][y];
				}
				else {
					int num = dfs(x, y);
					if (max_value < 1 + num)
						max_value = 1 + num;
				}
			}
		}
		dp[i][j] = max_value;
		if (result < max_value)
			result = max_value;

		return dp[i][j];
	}
}
