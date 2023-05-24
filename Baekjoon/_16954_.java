import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _16954_ { // 움직이는 미로 탈출
	static boolean arr[][], visited[][], result;
	static int dx[] = { 0, -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 0, 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		arr = new boolean[8][8];
		visited = new boolean[8][8];
		result = false;

		for (int i = 0; i < 8; i++) {
			String str = bf.readLine();
			for (int j = 0; j < 8; j++) {
				if (str.charAt(j) == '#') {
					arr[i][j] = true; // 벽
				}
			}
		}
		search(7, 0, 0);

		if (result)
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static void search(int start_x, int start_y, int depth) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { start_x, start_y, depth });

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 9; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x >= 0 && x < 8 && y >= 0 && y < 8  ) {
					if(x-temp[2]>=0 && arr[x-temp[2]][y]) continue;
					
					if(i!=0 && visited[x][y]) continue;
					if (x - (temp[2]+1) >= 0) {
						if (!arr[x - (temp[2]+1)][y]) {
							if (x == 0 && y == 7) {
								result = true;
								break;
							}
							visited[x][y] = true;
							queue.add(new int[] { x, y, temp[2] + 1 });
							
						}
					} else {
						if (x == 0 && y == 7) {
							result = true;
							break;
						}
						visited[x][y] = true;
						queue.add(new int[] { x, y, temp[2] + 1 });
					}
				}
			}
			if (result)
				break;
		}
	}
}
