import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _26170_ { // 사과 빨리 먹기
	static int arr[][], answer;
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[5][5];
		visited = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		answer = Integer.MAX_VALUE;
		visited[r][c] = true;
		dfs(r, c, 0, 0);

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	private static void dfs(int r, int c, int apple, int d) {
		if (apple == 3) {
			answer = Math.min(answer, d);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int x = r + dx[i];
			int y = c + dy[i];
			if (x >= 0 && x < 5 && y >= 0 && y < 5 && !visited[x][y] && arr[x][y] != -1) {
				visited[x][y] = true;
				if (arr[x][y] == 1) {
					dfs(x, y, apple + 1, d + 1);
				} else {
					dfs(x, y, apple, d + 1);
				}
				visited[x][y] = false;
			}
		}
	}
}
