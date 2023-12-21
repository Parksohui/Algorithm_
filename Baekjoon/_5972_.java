import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _5972_ { // 택배 배송

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<int[]>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new int[] { b, c });
			list.get(b).add(new int[] { a, c });
		}

		int result[] = new int[n + 1];
		boolean visited[] = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			result[i] = Integer.MAX_VALUE;
		}

		visited[1] = true;
		result[0] = 0;

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		queue.add(new int[] { 1, 0 });

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < list.get(temp[0]).size(); i++) {
				int num[] = list.get(temp[0]).get(i);
				if (!visited[num[0]] || result[num[0]] > temp[1] + num[1]) {
					visited[num[0]] = true;
					result[num[0]] = temp[1] + num[1];
					queue.add(new int[] { num[0], temp[1] + num[1] });
				}
			}
		}
		System.out.println(result[n]);
	}
}
