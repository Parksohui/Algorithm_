import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _16692_ { // Greedy Scheduler

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});

		int idx = 1;
		int result[] = new int[c];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < c; i++) {
			if (idx <= n) {
				queue.add(new int[] { Integer.parseInt(st.nextToken()), idx++, i });
			} else {
				int info[] = queue.poll();
				result[info[2]] = info[1];
				queue.add(new int[] { info[0] + Integer.parseInt(st.nextToken()), info[1], i });
			}
		}

		while (!queue.isEmpty()) {
			int info[] = queue.poll();
			result[info[2]] = info[1];
		}

		for (int i = 0; i < c; i++) {
			bw.write(result[i] + " ");
		}
		bw.flush();
	}
}
