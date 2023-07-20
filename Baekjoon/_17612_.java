import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _17612_ { // 쇼핑몰

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o2[1] - o1[1];
				return o1[0] - o2[0];
			}
		});

		int idx = 0;
		int r = 1;
		long result = 0;

		boolean arr[] = new boolean[k];
		int i = 0;
		boolean flag = false;

		while (i < n) {
			st = new StringTokenizer(bf.readLine());
			i += 1;
			int id = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			if (queue.size() < k) {
				queue.add(new int[] { w, idx, id });
				arr[idx] = true;
				idx += 1;
			} else {
				int temp[] = queue.poll();
				result += new Long(temp[2]) * new Long(r);
				r += 1;
				arr[temp[1]] = false;
				flag = false;
				while (queue.size() > 0 && queue.peek()[0] == temp[0]) {
					temp = queue.poll();
					result += new Long(temp[2]) * new Long(r);
					r += 1;
					arr[temp[1]] = false;
				}
				for (int j = 0; j < k; j++) {
					if (!arr[j]) {
						if (flag) {
							st = new StringTokenizer(bf.readLine());
							i += 1;
							id = Integer.parseInt(st.nextToken());
							w = Integer.parseInt(st.nextToken());
						}
						queue.add(new int[] { w + temp[0], j, id });
						arr[j] = true;
						flag = true;
						if (i == n)
							break;
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			result += new Long(temp[2]) * new Long(r);
			r += 1;
		}
		System.out.println(result);
	}
}
