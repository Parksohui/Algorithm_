import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11437_ { // LCA
	static int depth[], n, parent[];
	static ArrayList<ArrayList<Integer>> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());

		arr = new ArrayList<>();
		depth = new int[n + 1];
		parent = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(bf.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr.get(a).add(b);
			arr.get(b).add(a);
		}

		findDepth();

		int m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			bw.write(findParent(a, b) + "\n");
		}
		bw.flush();
	}

	private static int findParent(int a, int b) {
		int aParent = a;
		int bParent = b;

		while (aParent != bParent) {
			if (depth[aParent] > depth[bParent]) {
				aParent = parent[aParent];
			} else if (depth[aParent] < depth[bParent]) {
				bParent = parent[bParent];
			} else {
				aParent = parent[aParent];
				bParent = parent[bParent];
			}
		}
		return aParent;
	}

	private static void findDepth() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		boolean visited[] = new boolean[n + 1];
		visited[1] = true;

		while (!queue.isEmpty()) {
			int info = queue.poll();
			for (int i = 0; i < arr.get(info).size(); i++) {
				int num = arr.get(info).get(i);
				if (!visited[num]) {
					visited[num] = true;
					parent[num] = info;
					depth[num] = depth[info] + 1;
					queue.add(num);
				}
			}
		}
	}
}
