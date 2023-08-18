import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2617_ { // 구슬 찾기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> parents = new ArrayList<>();
		ArrayList<ArrayList<Integer>> child = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			parents.add(new ArrayList<>());
			child.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			parents.get(b).add(a);
			child.get(a).add(b);
		}

		boolean visited[] = new boolean[n + 1];

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			init(visited);
			visited[i] = true;

			int left = dfs(i, parents, visited, 0);
			if (left > n / 2) {
				answer += 1;
				continue;
			}
			int right = dfs(i, child, visited, 0);
			if (right > n / 2) {
				answer += 1;
				continue;
			}
		}
		System.out.println(answer);
	}

	private static int dfs(int x, ArrayList<ArrayList<Integer>> parents, boolean[] visited, int count) {
		for (int i = 0; i < parents.get(x).size(); i++) {
			if (!visited[parents.get(x).get(i)]) {
				visited[parents.get(x).get(i)] = true;
				count += dfs(parents.get(x).get(i), parents, visited, 1);
			}
		}
		return count;
	}

	private static void init(boolean[] visited) {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}
}
