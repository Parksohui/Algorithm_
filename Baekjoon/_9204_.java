import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9204_ { // 체스
	static int dx[] = { -1, -1, 1, 1 };
	static int dy[] = { -1, 1, -1, 1 };

	static class Bishop {
		private int x;
		private char y;
		private int cnt;
		private ArrayList<Bishop> list;

		public Bishop(int x, char y, int cnt, ArrayList<Bishop> list) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.list = list;
		}

		public Bishop(int x, char y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());
			char y1 = st.nextToken().charAt(0);
			int x1 = Integer.parseInt(st.nextToken());
			char y2 = st.nextToken().charAt(0);
			int x2 = Integer.parseInt(st.nextToken());

			if(x1==x2 && y1==y2) {
				bw.write("0 "+y1+" "+x1+"\n");
			}else {
				ArrayList<Bishop> temp = bfs(x1, y1, x2, y2);
				if (temp == null) {
					bw.write("Impossible\n");
				}else {
					bw.write((temp.size()+1) + " "+y1+" "+x1+" ");
					for (Bishop bishop : temp) {
						bw.write(bishop.y + " " + bishop.x + " ");
					}
					bw.write(y2+" "+x2+"\n");
				}
			}
		}
		bw.flush();
	}

	private static ArrayList<Bishop> bfs(int x1, char y1, int x2, char y2) {
		boolean visited[][] = new boolean[8][8];
		Queue<Bishop> queue = new LinkedList<>();

		visited[8 - x1][y1 - 'A'] = true;
		queue.add(new Bishop(x1, y1, 0, new ArrayList<>()));

		int resultX = 8 - x2;
		int resultY = y2 - 'A';

		while (!queue.isEmpty()) {
			Bishop bishop = queue.poll();
			for (int i = 0; i < 4; i++) {
				int y = bishop.y - 'A';
				int x = 8 - bishop.x;
				while (x >= 0 && x < 8 && y >= 0 && y < 8) {
					x += dx[i];
					y += dy[i];
					if (x >= 0 && x < 8 && y >= 0 && y < 8 && !visited[x][y]) {
						visited[x][y] = true;
						ArrayList<Bishop> temp=new ArrayList<>();
						for(Bishop b: bishop.list) {
							temp.add(b);
						}
						if (resultX == x && resultY == y) {
							return temp;
						}
						if (bishop.cnt + 1 == 4) {
							return null;
						}
						temp.add(new Bishop(Math.abs(8 - x), (char) (y+'A')));
						queue.add(new Bishop(Math.abs(8 - x), (char) (y+'A'), bishop.cnt + 1, temp));
					}
				}
			}
		}
		return null;
	}
}
