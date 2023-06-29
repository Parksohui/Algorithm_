import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _3584_ { // 가장 가까운 공통 조상
	static int root[], result;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			root = new int[n + 1];
			visited = new boolean[n + 1];
			result = 0;

			for (int j = 0; j < n - 1; j++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				root[b] = a;
			}
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			dfs(a);
			dfs(b);
			System.out.println(result);
		}
	}

	private static void dfs(int idx) {
		if (visited[idx]) {
			result = idx;
			return;
		}
		if (visited[root[idx]]) {
			result = root[idx];
			return;
		}
		visited[idx] = true;
		if (root[idx] != 0) {
			dfs(root[idx]);
		}
	}
}
