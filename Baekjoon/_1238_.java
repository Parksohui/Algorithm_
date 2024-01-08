import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1238_ { // 파티

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<int[]>> list = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			list.get(start).add(new int[] { end, t });
		}

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			int arr[] = new int[n + 1];
			int result[] = new int[n + 1];

			for (int j = 1; j < n + 1; j++) {
				arr[j] = Integer.MAX_VALUE;
				result[j] = Integer.MAX_VALUE;
			}

			if (i == x) {
				continue;
			}

			arr[i] = 0;
			queue.add(new int[] { i, 0 });

			while (!queue.isEmpty()) {
				int num[] = queue.poll();
				for (int j = 0; j < list.get(num[0]).size(); j++) {
					if (arr[list.get(num[0]).get(j)[0]] > num[1] + list.get(num[0]).get(j)[1]) {
						arr[list.get(num[0]).get(j)[0]] = num[1] + list.get(num[0]).get(j)[1];
						queue.add(new int[] { list.get(num[0]).get(j)[0], num[1] + list.get(num[0]).get(j)[1] });
					}
				}
			}

			result[x] = arr[x];
			queue.add(new int[] { x, result[x] });
			while (!queue.isEmpty()) {
				int num[] = queue.poll();
				for (int j = 0; j < list.get(num[0]).size(); j++) {
					if (result[list.get(num[0]).get(j)[0]] > num[1] + list.get(num[0]).get(j)[1]) {
						result[list.get(num[0]).get(j)[0]] = num[1] + list.get(num[0]).get(j)[1];
						queue.add(new int[] { list.get(num[0]).get(j)[0], num[1] + list.get(num[0]).get(j)[1] });
					}
				}
			}

			if (answer < result[i]) {
				answer = result[i];
			}
		}
		System.out.println(answer);
	}
}
