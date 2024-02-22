import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _2232_ { // 지뢰

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		boolean visited[] = new boolean[n];

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o2[0] - o1[0];
			}
		});

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(bf.readLine());
			arr[i] = num;
			queue.add(new int[] { num, i });
		}

		ArrayList<Integer> result = new ArrayList<>();
		int cnt = 0;

		while (!queue.isEmpty()) {
			int info[] = queue.poll();

			if (!visited[info[1]]) {
				result.add(info[1] + 1);
				visited[info[1]] = true;
				cnt += 1;

				int temp = info[1];
				while (temp - 1 >= 0 && !visited[temp - 1] && arr[temp - 1] < arr[temp]) {
					visited[temp - 1] = true;
					cnt += 1;
					temp -= 1;
				}

				temp = info[1];
				while (temp + 1 < n && !visited[temp + 1] && arr[temp + 1] < arr[temp]) {
					visited[temp + 1] = true;
					cnt += 1;
					temp += 1;
				}
			}
			if (cnt == n) {
				break;
			}
		}
		Collections.sort(result);

		for (int i = 0; i < result.size(); i++) {
			bw.write(result.get(i) + "\n");
		}
		bw.flush();
	}
}
