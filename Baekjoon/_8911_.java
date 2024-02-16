import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _8911_ { // 거북이
	static class Position {
		private int x;
		private int y;
		private int dir;

		public Position(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir; // 0 : 상, 1: 우, 2: 하, 3: 좌
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i < t; i++) {
			String str = bf.readLine();

			Position position = new Position(0, 0, 0);
			int maxX = 0, maxY = 0, minX = 0, minY = 0;

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'F') {
					if (position.dir == 0) {
						position.x += 1;
					} else if (position.dir == 1) {
						position.y += 1;
					} else if (position.dir == 2) {
						position.x -= 1;
					} else {
						position.y -= 1;
					}
				} else if (str.charAt(j) == 'B') {
					if (position.dir == 0) {
						position.x -= 1;
					} else if (position.dir == 1) {
						position.y -= 1;
					} else if (position.dir == 2) {
						position.x += 1;
					} else {
						position.y += 1;
					}

				} else if (str.charAt(j) == 'L') {
					position.dir += 1;
					if (position.dir == 4) {
						position.dir = 0;
					}

				} else if (str.charAt(j) == 'R') {
					position.dir -= 1;
					if (position.dir == -1) {
						position.dir = 3;
					}
				}

				if (position.x > maxX) {
					maxX = position.x;
				}
				if (position.y > maxY) {
					maxY = position.y;
				}
				if (position.x < minX) {
					minX = position.x;
				}
				if (position.y < minY) {
					minY = position.y;
				}
			}
			bw.write((maxX + Math.abs(minX)) * (maxY + Math.abs(minY)) + "\n");
		}
		bw.flush();
	}
}
