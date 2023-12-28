import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3182_ { // 한동이는 공부가 하기 싫어!
	static int arr[], d[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		arr = new int[n + 1];
		d = new int[n + 1];
		

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		for (int i = 1; i <= n; i++) {
			boolean visited[] = new boolean[n + 1];
			visited[i] = true;
			d[i]= dfs(i, visited);
		}

		int idx = Integer.MIN_VALUE;
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (idx < d[i]) {
				idx = d[i];
				answer = i;
			}
		}
		System.out.println(answer);
	}

	private static int dfs(int i, boolean visited[]) {
		if (!visited[arr[i]]) {
			visited[arr[i]] = true;
			return dfs(arr[i], visited) + 1;
		}
		return 1;
	}
}
