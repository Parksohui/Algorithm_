import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _21937_ { // 작업
	static ArrayList<ArrayList<Integer>> list;
	static boolean visited[];
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		visited = new boolean[n + 1];
		result = 0;

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(b).add(a);
		}

		int start = Integer.parseInt(bf.readLine());

		visited[start] = true;
		dfs(start);
		
		System.out.println(result);
	}

	private static void dfs(int start) {
		for (int i = 0; i < list.get(start).size(); i++) {
			if (!visited[list.get(start).get(i)]) {
				visited[list.get(start).get(i)] = true;
				result += 1;
				dfs(list.get(start).get(i));
			}
		}
	}
}
