import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5006_ { // Horror List
	static ArrayList<ArrayList<Integer>> list;
	static int visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());

		Queue<Integer> queue = new LinkedList<>();
		visited = new int[n];

		for (int i = 0; i < n; i++) {
			visited[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < h; i++) {
			int num = Integer.parseInt(st.nextToken());
			queue.add(num);
			visited[num] = 0;
		}

		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}

		bfs(queue);

		int value = 0, result = 0;

		for (int i = 0; i < n; i++) {
			if (value < visited[i]) {
				value = visited[i];
				result = i;
			}
		}
		System.out.println(result);
	}

	private static void bfs(Queue<Integer> queue) {
		while (!queue.isEmpty()) {
			int num = queue.poll();
			for (int i = 0; i < list.get(num).size(); i++) {
				if (visited[list.get(num).get(i)] == Integer.MAX_VALUE) {
					visited[list.get(num).get(i)] = visited[num] + 1;
					queue.add(list.get(num).get(i));
				}
			}
		}
	}
}
