import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17265_ { // 나의 인생에는 수학과 함께
	static char arr[][];
	static int dx[] = { 0, 1 };
	static int dy[] = { 1, 0 };

	static int max_arr[][], min_arr[][], n;
	static boolean max_visited[][], min_visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());

		arr = new char[n][n];
		max_arr = new int[n][n];
		min_arr = new int[n][n];
		max_visited=new boolean[n][n];
		min_visited=new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = st.nextToken().charAt(0);
			}
		}

		bfs(0, 0, arr[0][0] + "");
		System.out.println(max_arr[n - 1][n - 1] + " " + min_arr[n - 1][n - 1]);
	}

	private static void bfs(int i, int j, String str) {
		Queue<String[]> queue = new LinkedList<>();
		queue.add(new String[] { Integer.toString(i), Integer.toString(j), str+" " });
		max_visited[i][j]=true;
		min_visited[i][j]=true;
		
		while (!queue.isEmpty()) {
			String temp[] = queue.poll();
			for (int k = 0; k < 2; k++) {
				int x = Integer.parseInt(temp[0]) + dx[k];
				int y = Integer.parseInt(temp[1]) + dy[k];
				if (x >= 0 && x < n && y >= 0 && y < n) {
					if (!Character.isDigit(arr[x][y])) {
						queue.add(new String[] { Integer.toString(x), Integer.toString(y), temp[2] +arr[x][y] });
					} else {

						String[] num_arr=temp[2].split(" ");

						int a = Integer.parseInt(num_arr[0]);
						char op = num_arr[1].charAt(0);

						int b = arr[x][y] - '0';
						int result = -1;
						if (op == '+') {
							result = a + b;
						} else if (op == '-') {
							result = a - b;
						} else if (op == '*') {
							result = a * b;
						}
						if (!max_visited[x][y] || max_arr[x][y] < result) {
							max_visited[x][y]=true;
							max_arr[x][y] = result;
						}
						if (!min_visited[x][y] || min_arr[x][y] > result) {
							min_visited[x][y]=true;
							min_arr[x][y] = result;
						}
						
						if(max_arr[x][y]==min_arr[x][y]) {
							queue.add(new String[] { Integer.toString(x), Integer.toString(y), max_arr[x][y] + " " });
						}else {
							queue.add(new String[] { Integer.toString(x), Integer.toString(y), max_arr[x][y] + " " });
							queue.add(new String[] { Integer.toString(x), Integer.toString(y), min_arr[x][y] + " " });
						}
					}
				}
			}
		}
	}
}
