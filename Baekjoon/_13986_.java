import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _13986_ { // Gravity

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] arr = new char[n][m];

		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'o') {
					stack.add(new int[] { i, j });
				}
			}
		}

		while (!stack.isEmpty()) {
			int position[] = stack.pop();
			int result = position[0];

			for (int i = position[0] + 1; i < n; i++) {
				if (arr[i][position[1]] == '.') {
					result = i;
				} else {
					break;
				}
			}
			arr[position[0]][position[1]] = '.';
			arr[result][position[1]] = 'o';
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
