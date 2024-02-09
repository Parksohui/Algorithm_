import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10451_ { // 순열 사이클
	static int arr[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());
			arr = new int[n + 1];
			visited = new boolean[n + 1];

			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (!visited[j]) {
					cnt += 1;
					visited[j] = true;
					dfs(j);
				}
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
	}

	private static void dfs(int j) {
		if (!visited[arr[j]]) {
			visited[arr[j]] = true;
			dfs(arr[j]);
		}
	}
}
