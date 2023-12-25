import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _10282_ { // 해킹

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		ArrayList<ArrayList<int[]>> list = new ArrayList<>();

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(bf.readLine());

			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			for (int j = 0; j <= n; j++) {
				list.add(new ArrayList<>());
			}

			for (int j = 0; j < d; j++) {
				st = new StringTokenizer(bf.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				list.get(b).add(new int[] { a, s });
			}

			int dist[] = new int[n + 1];
			for (int j = 1; j <= n; j++) {
				dist[j] = Integer.MAX_VALUE;
			}
			dist[c] = 0;

			PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return o1[0] - o2[0];
					}
					return o1[1] - o2[1];
				}
			});
			queue.add(new int[] { c, 0 });

			while (!queue.isEmpty()) {
				int temp[] = queue.poll();
				for (int j = 0; j < list.get(temp[0]).size(); j++) {
					int num[] = list.get(temp[0]).get(j);
					if (dist[num[0]] > temp[1] + num[1]) {
						queue.add(new int[] { num[0], temp[1] + num[1] });
						dist[num[0]] = temp[1] + num[1];
					}
				}
			}

			int cnt = 0;
			int time = 0;
			for (int j = 1; j <= n; j++) {
				if (dist[j] != Integer.MAX_VALUE) {
					cnt += 1;
					if (time < dist[j]) {
						time = dist[j];
					}
				}
			}
			bw.write(cnt+" "+time+"\n");
			list.clear();
		}
		bw.flush();
	}
}
