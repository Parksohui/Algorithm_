import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2660_ { // 회장뽑기
	static ArrayList<ArrayList<Integer>> list;
	static int score[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		int a = -1, b = -1;
		st = new StringTokenizer(bf.readLine());
		while (((a = Integer.parseInt(st.nextToken())) != -1) && ((b = Integer.parseInt(st.nextToken())) != -1)) {
			list.get(a).add(b);
			list.get(b).add(a);
			st = new StringTokenizer(bf.readLine());
		}

		score = new int[n + 1];
		int min = n;

		for (int i = 1; i < n + 1; i++) {
			boolean visited[] = new boolean[n + 1];
			visited[i] = true;
			bfs(i, visited);
			if (min > score[i]) {
				min = score[i];
			}
		}

		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (score[i] == min) {
				count += 1;
			}
		}
		bw.write(min + " " + count + "\n");
		for (int i = 1; i < n + 1; i++) {
			if (score[i] == min) {
				bw.write(i + " ");
			}
		}
		bw.flush();
	}

	private static void bfs(int num, boolean visited[]) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { num, 0 });

		while (!queue.isEmpty()) {
			int x[] = queue.poll();
			for (int i = 0; i < list.get(x[0]).size(); i++) {
				if (!visited[list.get(x[0]).get(i)]) {
					visited[list.get(x[0]).get(i)] = true;
					queue.add(new int[] { list.get(x[0]).get(i), x[1] + 1 });
					if (score[num] < x[1] + 1) {
						score[num] = x[1] + 1;
					}
				}
			}
		}
	}
}
