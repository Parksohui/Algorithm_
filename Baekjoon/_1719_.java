import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1719_ { // 택배

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int dist[][] = new int[n + 1][n + 1];
		int answer[][] = new int[n + 1][n + 1];
		ArrayList<ArrayList<int[]>> list = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
			if (i == 0) {
				continue;
			}
			for (int j = 0; j < n + 1; j++) {
				if (j == 0) {
					continue;
				}
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list.get(start).add(new int[] { end, d });
			list.get(end).add(new int[] { start, d });
		}

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		for (int i = 1; i <= n; i++) {
			queue.add(new int[] { i, 0 });
			while (!queue.isEmpty()) {
				int info[] = queue.poll();
				if (info[1] > dist[i][info[0]]) {
					continue;
				}
				for (int j = 0; j < list.get(info[0]).size(); j++) {
					int temp[] = list.get(info[0]).get(j);
					if (temp[0] == i)
						continue;
					if (info[1] + temp[1] < dist[i][temp[0]]) {
						dist[i][temp[0]] = info[1] + temp[1];
						queue.add(new int[] { temp[0], info[1] + temp[1] });
						if (answer[i][info[0]] == 0)
							answer[i][temp[0]] = temp[0];
						else
							answer[i][temp[0]] = answer[i][info[0]];
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					bw.write("- ");
				else
					bw.write(answer[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
