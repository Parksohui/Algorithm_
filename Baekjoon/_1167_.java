import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1167_ { // 트리의 지름
	static int max, max_num;
	static boolean visited[];
	static ArrayList<ArrayList<Node>> list;

	static class Node {
		private int num;
		private int d;

		public Node(int num, int d) {
			this.num = num;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int v = Integer.parseInt(bf.readLine());

		list = new ArrayList<>();
		visited = new boolean[v + 1];

		for (int i = 0; i <= v; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < v; i++) {
			st = new StringTokenizer(bf.readLine());

			int a = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int b = Integer.parseInt(st.nextToken());
				if (b == -1)
					break;
				int d = Integer.parseInt(st.nextToken());
				list.get(a).add(new Node(b, d));
			}
		}

		int result = 0, result_num = 0;
		visited[1] = true;

		// 임의의 정점부터 가장 먼 정점 구하기
		for (int i = 0; i < list.get(1).size(); i++) {
			if (!visited[list.get(1).get(i).num]) {
				max = list.get(1).get(i).d;
				max_num = list.get(1).get(i).num;

				dfs(list.get(1).get(i).num, list.get(1).get(i).d);
				if (result < max) {
					result = max;
					result_num = max_num;
				}
			}
		}

		// 구해진 정점에서 가장 먼 정점 구하기
		max = 0;
		for (int i = 0; i <= v; i++) {
			visited[i]=false;
		}
		
		dfs(result_num, 0);

		System.out.println(max);
	}

	private static void dfs(int num, int d) {
		visited[num] = true;

		for (int i = 0; i < list.get(num).size(); i++) {
			if (!visited[list.get(num).get(i).num]) {
				if (max < d + list.get(num).get(i).d) {
					max = d + list.get(num).get(i).d;
					max_num = list.get(num).get(i).num;
				}
				dfs(list.get(num).get(i).num, d + list.get(num).get(i).d);
			}
		}
	}
}
