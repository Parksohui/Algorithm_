import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18290_ { // NM과 K (1)
	static int arr[][], result;
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m];
		result = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				search(k - 1, arr[i][j]);
				visited[i][j] = false;
			}
		}

		System.out.println(result);
	}

	private static void search(int k, int sum) {
		if (k == 0) {
			result = Math.max(result, sum);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (visited[i][j]) {
					continue;
				}
				int cnt = 0;
				int temp = 0;
				for (int l = 0; l < 4; l++) {
					int a = i + dx[l];
					int b = j + dy[l];
					if (a >= 0 && a < arr.length && b >= 0 && b < arr[0].length) {
						temp += 1;
						if (!visited[a][b]) {
							cnt += 1;
						} else {
							break;
						}
					}
				}
				if (cnt == temp) {
					visited[i][j] = true;
					search(k - 1, sum + arr[i][j]);
					visited[i][j] = false;
				}
			}
		}
	}
}
