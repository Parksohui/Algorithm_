import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10157_ { // 자리배정

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(bf.readLine());

		if (c * r < k) {
			bw.write("0");
		} else {
			boolean arr[][] = new boolean[r][c];

			int x = r - 1, y = 0;
			int num = 1;
			arr[x][y] = true;

			int dx[] = { -1, 0, 1, 0 };
			int dy[] = { 0, 1, 0, -1 };
			int idx = 0;
			while (true) {
				if (num == k) {
					bw.write((y+1)+ " " + (r-x));
					break;
				}
				
				if (x + dx[idx] < 0 || x + dx[idx] >= r || y + dy[idx] < 0 || y + dy[idx] >= c
						|| arr[x + dx[idx]][y + dy[idx]]) {
					idx += 1;
					if (idx == 4) {
						idx = 0;
					}
				}
				x += dx[idx];
				y += dy[idx];
				arr[x][y] = true;
				num += 1;
			}
		}
		bw.flush();
	}
}
