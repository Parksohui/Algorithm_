import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14546_ { // Prison Break
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static char arr[][];
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int P = Integer.parseInt(bf.readLine());

		for (int t = 0; t < P; t++) {
			st = new StringTokenizer(bf.readLine());

			int L = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = W-Integer.parseInt(st.nextToken()) ;
			int C = Integer.parseInt(st.nextToken())-1;
			int D = W-Integer.parseInt(st.nextToken()) ;

			arr = new char[W][L];
			visited = new boolean[W][L];
			for (int i = 0; i < W; i++) {
				String str = bf.readLine();
				for (int j = 0; j < L; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			bw.write(bfs(B, A, D, C) + "\n");
		}
		bw.flush();
	}

	private static String bfs(int a, int b, int c, int d) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { a, b });
		visited[a][b] = true;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && arr[x][y] == arr[a][b]
						&& !visited[x][y]) {
					if (x == c && y == d) {
						return "YES";
					}
					visited[x][y] = true;
					queue.add(new int[] { x, y });
				}
			}
		}
		return "NO";
	}
}
