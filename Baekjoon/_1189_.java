import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1189_ { // 컴백홈
	static int result, k;
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visited = new boolean[r][c];
		result = 0;
		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				if(str.charAt(j)=='T') {
					visited[i][j]=true;
				}
			}
		}

		visited[r - 1][0] = true;
		dfs(r - 1, 0, 1);

		System.out.println(result);
	}

	private static void dfs(int x, int y, int d) {
		if (d + 1 > k)
			return;
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx >= 0 && mx < visited.length && my >= 0 && my < visited[0].length && !visited[mx][my]) {
				if (mx == 0 && my == visited[0].length - 1 && d + 1 == k) {
					result += 1;
					return;
				}
				visited[mx][my] = true;
				dfs(mx, my, d + 1);
				visited[mx][my] = false;
			}
		}
	}
}
