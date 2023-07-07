import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _15900_ { // 나무 탈출
	static ArrayList<ArrayList<Integer>> arr;
	static int cnt;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		arr = new ArrayList<>();
		visited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr.get(a).add(b);
			arr.get(b).add(a);

		}

		cnt = 0;
		dfs(1, 0);

		if (cnt % 2 == 0)
			System.out.println("No");
		else
			System.out.println("Yes");
	}

	private static void dfs(int idx, int depth) {
		visited[idx] = true;
		int check=0;
		for (int i = 0; i < arr.get(idx).size(); i++) {
			if (visited[arr.get(idx).get(i)]) {
				check+=1;
				continue;
			}
			dfs(arr.get(idx).get(i), depth + 1);
		}
		if(check==arr.get(idx).size()) {
			cnt += depth;
			return;
		}
	}
}
