import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1347 { // 미로 만들기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());
		String str = bf.readLine();

		boolean arr[][] = new boolean[103][103];
		int x = 51, y = 51, minX = 51, minY = 51, maxX = 51, maxY = 51, dir = 2;
		arr[x][y]=true;
		int dx[] = { -1, 0, 1, 0 }; // 상우하좌
		int dy[] = { 0, 1, 0, -1 };

		for (int i = 0; i < n; i++) {
			char c = str.charAt(i);

			if (c == 'R') {
				dir += 1;
				if (dir == 4) {
					dir = 0;
				}
			} else if (c == 'L') {
				dir -= 1;
				if (dir == -1) {
					dir = 3;
				}
			}
			if (c == 'F') {
				x += dx[dir];
				y += dy[dir];
				arr[x][y] = true;

				minX = Math.min(x, minX);
				minY = Math.min(y, minY);
				maxX = Math.max(x, maxX);
				maxY = Math.max(y, maxY);
			}
		}

		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if (arr[i][j]) {
					bw.write(".");
				} else {
					bw.write("#");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
