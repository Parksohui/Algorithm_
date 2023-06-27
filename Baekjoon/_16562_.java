import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16562_ { // 친구비
	static int f[], money;
	static ArrayList<HashSet<Integer>> arr;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		f = new int[n + 1];
		arr = new ArrayList<>();
		visited = new boolean[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i < n + 1; i++) {
			f[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n + 1; i++) {
			arr.add(new HashSet<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr.get(v).add(w);
			arr.get(w).add(v);
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				money = f[i];
				bfs(i);
				answer += money;
			}
		}

		if (k < answer) {
			System.out.println("Oh no");
		} else {
			System.out.println(answer);
		}

	}

	private static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(idx);

		while (!queue.isEmpty()) {
			int num = queue.poll();
			for (int next : arr.get(num)) {
				if (!visited[next]) {
					visited[next] = true;
					if (money > f[next]) {
						money = f[next];
					}
					queue.add(next);
				}
			}
		}
	}
}
