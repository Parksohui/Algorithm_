import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4179_ { // 불!
	static boolean flag ;
	static char map[][];
	static Queue<int[]> queue, position;
	static int dx[] = { -1, 1, 0, 0 }; // 상하좌우
	static int dy[] = { 0, 0, -1, 1 };
	static int r, c, result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		queue = new LinkedList<>();

		position = new LinkedList<>();
		flag = false;
		for (int i = 0; i < r; i++) { // input
			String s = bf.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'J') {
					position.add(new int[] { i, j, 0 });
				} else if (map[i][j] == 'F') {
					queue.add(new int[] { i, j, 0 });
				}
			}
		}
		result = 0;

		while (true) {
			if (position.size() == 0)
				break;
			result += 1;
			search();
			if (flag)
				break;
		}

		if (flag)
			System.out.println(result);
		else
			System.out.println("IMPOSSIBLE");
	}

	private static void search() {
		while (!queue.isEmpty()) { // fire move
			if(queue.peek()[2]==result-1) {
				int[] temp = queue.poll();
				for (int i = 0; i < 4; i++) {
					int x = temp[0] + dx[i];
					int y = temp[1] + dy[i];
					if (x >= 0 && x < r && y >= 0 && y < c) {
						if (map[x][y] == '.' || map[x][y] == 'J') {
							map[x][y] = 'F';
							queue.add(new int[] { x, y, temp[2] + 1 });
						}
					}
				}
			}else break;
		}
		while (!position.isEmpty() ) { // move
			if(position.peek()[2]==result-1) {
				int[] temp = position.poll();
				for (int i = 0; i < 4; i++) {
					int x = temp[0] + dx[i];
					int y = temp[1] + dy[i];
					if (x >= 0 && x < r && y >= 0 && y < c && map[x][y] == '.') {
						position.add(new int[] { x, y, temp[2] + 1 });
						map[x][y]='J';
					} else if (x < 0 || x >= r || y < 0 || y >= c) { // 미로 탈출
						flag = true;
						position.clear();
						break;
					}
				}
				if(flag) break;
			}else break;
		}
	}
}
