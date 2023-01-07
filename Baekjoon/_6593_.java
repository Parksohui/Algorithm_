import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6593_ { // 상범 빌딩
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<int[]> queue;
	static char[][][] map;
	static int visited[][][], L, R, C, result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		queue = new LinkedList<>();

		while (true) {
			st = new StringTokenizer(bf.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0)
				break;
			result = 0;
			map = new char[L][R][C];
			visited = new int[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					st = new StringTokenizer(bf.readLine());
					String line = st.nextToken();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = line.charAt(k);
						if (map[i][j][k] == 'S')
							queue.add(new int[] { i, j, k });
					}
				}
				new StringTokenizer(bf.readLine());
			}
			search();
			queue.clear();
			if(result>0) System.out.println("Escaped in "+result+" minute(s).");
			else System.out.println("Trapped!");
		}
	}

	private static void search() {
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			if (temp[0] - 1 >= 0) {
				if (map[temp[0] - 1][temp[1]][temp[2]] == 'E') {
					result = visited[temp[0]][temp[1]][temp[2]] + 1;
					break;
				} else if (map[temp[0] - 1][temp[1]][temp[2]] == '.' && visited[temp[0] - 1][temp[1]][temp[2]] == 0) {
					visited[temp[0] - 1][temp[1]][temp[2]] = visited[temp[0]][temp[1]][temp[2]] + 1;
					queue.add(new int[] { temp[0] - 1, temp[1], temp[2] });
				}
			}
			if (temp[0] + 1 < L) {
				if(map[temp[0]+1][temp[1]][temp[2]]=='E') {
					result = visited[temp[0]][temp[1]][temp[2]] + 1;
					break;
				}
				if (map[temp[0] + 1][temp[1]][temp[2]] == '.' && visited[temp[0] + 1][temp[1]][temp[2]] == 0) {
					visited[temp[0] + 1][temp[1]][temp[2]] = visited[temp[0]][temp[1]][temp[2]] + 1;
					queue.add(new int[] { temp[0] + 1, temp[1], temp[2] });
				}
			}
			for (int i = 0; i < 4; i++) {
				int x = temp[1] + dx[i];
				int y = temp[2] + dy[i];
				if (x >= 0 && x < R && y >= 0 && y < C) {
					if(map[temp[0]][x][y]=='E') {
						result = visited[temp[0]][temp[1]][temp[2]] + 1;
						break;
					}
					if (map[temp[0]][x][y] == '.' && visited[temp[0]][x][y] == 0) {
						visited[temp[0]][x][y] = visited[temp[0]][temp[1]][temp[2]] + 1;
						queue.add(new int[] { temp[0], x, y });
					}
				}
			}
			if(result>0)break;
		}
	}
}
