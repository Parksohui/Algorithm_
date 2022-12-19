import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13460_ { // 구슬 탈출 2
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static Queue<int[]> R, B;
	static char map[][];
	static int result = -1, x1, x2, y1, y2;
	static boolean flag, choice;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new char[n][m];

		R = new LinkedList<>();
		B = new LinkedList<>();

		for (int i = 0; i < n; i++) { // input
			String s = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					R.add(new int[] { i, j, 0 });
				} else if (map[i][j] == 'B') {
					B.add(new int[] { i, j, 0 });
				}
			}
		}
		search();
		System.out.println(result);
	}

	private static void R_move(int temp, int dx, int dy) {
		while (true) {
			x1 += dx;
			y1 += dy;
			if (map[x1][y1] == '#' || (choice && x2 == x1+dx  && y2 == y1+dy  && map[x2][y2] != 'O')) {
				if(choice) {
					R.add(new int[] { x1 - dx, y1 - dy, temp });
					B.add(new int[] { x2 - dx, y2 - dy, temp });
				}
				break;
			} else if (map[x1][y1] == 'O') {
				result = temp;
				if(choice) flag=true;
				break;
			}
		}
	}

	private static void B_move(int temp, int dx, int dy) {
		while (true) {
			x2 += dx;
			y2 += dy;
			if (map[x2][y2] == '#' || (!choice && x1 == x2 + dx && y1 == y2 + dy && map[x1][y1] != 'O')) {
				if (!choice) {
					if (result != -1)
						break;
					R.add(new int[] { x1 - dx, y1 - dy, temp });
					B.add(new int[] { x2 - dx, y2 - dy, temp });
					break;
				}else if(map[x1][y1]=='O') {
					flag=true;
					break;
				}else {
					break;
				}
			} else if (map[x2][y2] == 'O') {
				if(choice) flag=true;
				result = -1;
				break;
			}
		}
	}

	private static void search() {

		while (!R.isEmpty()) {
			int r_temp[] = R.poll();
			int b_temp[] = B.poll();

			int temp = 0;
			flag = false; 

			for (int i = 0; i < 4; i++) {

				x1 = r_temp[0];
				y1 = r_temp[1];
				x2 = b_temp[0];
				y2 = b_temp[1];
				choice=false;
				
				temp = r_temp[2];
				temp += 1;
				if(temp>10) break;
				if (i == 0) { // up
					if (r_temp[1] == b_temp[1] && r_temp[0] > b_temp[0]) { // 파란 구슬이 더 위에 있다면
						choice=true;
						B_move(temp, dx[i], dy[i]);
						if(flag)continue;
						R_move(temp, dx[i], dy[i]);
					} else {
						R_move(temp, dx[i], dy[i]);
						B_move(temp, dx[i], dy[i]);
					}
				} else if (i == 1) { // down
					if (r_temp[1] == b_temp[1] && r_temp[0] < b_temp[0]) {
						choice=true;
						B_move(temp, dx[i], dy[i]);
						if(flag)continue;
						R_move(temp, dx[i], dy[i]);
					} else {
						R_move(temp, dx[i], dy[i]);
						B_move(temp, dx[i], dy[i]);
					}
				} else if (i == 2) { // left
					if (r_temp[0] == b_temp[0] && r_temp[1] > b_temp[1]) {
						choice=true;
						B_move(temp, dx[i], dy[i]);
						if(flag)continue;
						R_move(temp, dx[i], dy[i]);
					} else {
						R_move(temp, dx[i], dy[i]);
						B_move(temp, dx[i], dy[i]);
					}
				} else { // right
					if (r_temp[0] == b_temp[0] && r_temp[1] < b_temp[1]) {
						choice=true;
						B_move(temp, dx[i], dy[i]);
						if(flag)continue;
						R_move(temp, dx[i], dy[i]);
					} else {
						R_move(temp, dx[i], dy[i]);
						B_move(temp, dx[i], dy[i]);
					}
				}
				if(result!=-1)break;
			}
			if(result!=-1)break;
		}
	}
}
