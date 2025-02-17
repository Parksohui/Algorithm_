import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13567_ { // 로봇

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int M = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };

		int x = M, y = 0, dir = 1;
		boolean flag = false;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			String cmd = st.nextToken();
			int d = Integer.parseInt(st.nextToken());

			if (cmd.equals("TURN")) {
				if (d == 0) {
					dir -= 1;
					if (dir < 0) {
						dir = 3;
					}
				} else {
					dir += 1;
					if (dir > 3) {
						dir = 0;
					}
				}
			} else {
				if (x + (dx[dir] * d) >= 0 && x + (dx[dir] * d) <= M && y + (dy[dir] * d) >= 0
						&& y + (dy[dir] * d) <= M) {
					x += dx[dir] * d;
					y += dy[dir] * d;
				} else {
					flag = true;
					break;
				}
			}
		}

		if (flag) {
			System.out.println(-1);
		} else {
			x = M - x;
			System.out.println(y + " " + x);
		}
	}
}
