import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5938_ { // Daisy Chains in the Field

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean visited[] = new boolean[n + 1];

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());

			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			list.get(c1).add(c2);
			list.get(c2).add(c1);
		}

		bfs(visited, list);

		boolean flag = false;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				flag = true;
				bw.write(i + "\n");
			}
		}
		if (!flag) {
			bw.write("0");
		}

		bw.flush();
	}

	private static void bfs(boolean[] visited, ArrayList<ArrayList<Integer>> list) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			int info = queue.poll();

			for (int i = 0; i < list.get(info).size(); i++) {
				if (!visited[list.get(info).get(i)]) {
					visited[list.get(info).get(i)] = true;
					queue.add(list.get(info).get(i));
				}
			}
		}
	}
}
