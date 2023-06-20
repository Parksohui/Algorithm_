import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _25195_ { // Yes or yes
	static ArrayList<ArrayList<Integer>> arr;
	static ArrayList<Integer> temp;
	static boolean visited[], flag;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList<>();
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			arr.get(u).add(v);
		}

		int s = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		temp = new ArrayList<>();
		for (int i = 0; i < s; i++) {
			temp.add(Integer.parseInt(st.nextToken()) - 1);
		}

		if (!temp.contains(0)) {
			visited[0] = true;
			flag = false;
			dfs(0);
		}

		if (flag)
			System.out.println("yes");
		else
			System.out.println("Yes");
	}

	private static void dfs(int i) {
		for (int k = 0; k < arr.get(i).size(); k++) {
			int num = arr.get(i).get(k);
			if (temp.contains(num)) {
				continue;
			}
			if (!visited[num]) {
				visited[num] = true;
				dfs(num);
			}
		}
		if (arr.get(i).size() == 0) {
			flag = true;
			return;
		}

	}

}
