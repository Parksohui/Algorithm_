import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17616_ { // 등수 찾기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

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

		boolean visited[] = new boolean[n+1];
		visited[x] = true;
		
		int start = dfs(x, parents, 0, visited);
		int end = dfs(x, child, 0, visited);

		bw.write((start + 1) + " " + (n - end));
		bw.flush();
	}

	private static int dfs(int x, ArrayList<ArrayList<Integer>> arr, int count, boolean[] visited) {
		for (int i = 0; i < arr.get(x).size(); i++) {
			if (!visited[arr.get(x).get(i)]) {
				visited[arr.get(x).get(i)] = true;
				count+=dfs(arr.get(x).get(i), arr, 1, visited);
			}
		}
		return count;
	}
}
