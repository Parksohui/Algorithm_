import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _12764_ { // 싸지방에 간 준하

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			queue.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		PriorityQueue<int[]> computer = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		ArrayList<Integer> result = new ArrayList<>();
		result.add(0);

		boolean check[] = new boolean[n + 1];

		result.add(1);
		check[1] = true;
		computer.add(new int[] { queue.poll()[1], 1 });
		boolean flag = false;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			int idx = Integer.MAX_VALUE;
			while (!computer.isEmpty() && computer.peek()[0] < temp[0]) {
				flag = true;
				check[computer.poll()[1]] = false;
			}
			if (flag) {
				for (int i = 1; i < n + 1; i++) {
					if (!check[i]) {
						idx = i;
						break;
					}
				}
				flag = false;
			}

			if (idx != Integer.MAX_VALUE) {
				result.set(idx, result.get(idx) + 1);
				check[idx] = true;
				computer.add(new int[] { temp[1], idx });
			} else {
				for (int i = 1; i < n + 1; i++) {
					if (!check[i]) {
						idx = i;
						check[idx] = true;
						break;
					}
				}
				if (result.size() > idx) {
					result.set(idx, result.get(idx) + 1);
				} else {
					result.add(1);
				}
				computer.add(new int[] { temp[1], idx });
			}
		}
		
		bw.write(result.size() - 1 + "\n");
		for (int i = 1; i < result.size(); i++) {
			bw.write(result.get(i) + " ");
		}
		bw.flush();
	}
}
