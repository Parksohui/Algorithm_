import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _19640_ { // 화장실의 규칙

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					if (o1[1] == o2[1]) {
						return o1[2] - o2[2];
					}
					return o2[1] - o1[1];
				}
				return o2[0] - o1[0];
			}
		});

		int idx = 0;
		int check = 0;

		ArrayList<int[]> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int d = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (i == k)
				check = 1;
			else
				check = 0;

			arr.add(new int[] { d, h, idx, i, check });
			idx += 1;
			if (idx == m)
				idx = 0;
		}

		int result = 0;

		for (int i = 0; i < m; i++) {
			if (i >= n)
				break;
			queue.add(arr.get(i));
		}

		while (true) {
			int temp[] = queue.poll();
			if (temp[4] == 1)
				break;
			result += 1;
			if (temp[3] + m < n) {
				queue.add(arr.get(temp[3] + m));
			}
		}

		System.out.println(result);
	}
}
