import java.io.*;
import java.util.*;

public class _1015_ { // 수열 정렬

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < n; i++) {
			queue.add(new int[] { Integer.parseInt(st.nextToken()), i });
		}

		int[] result = new int[n];
		int idx = 0;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			result[temp[1]] = idx++;
		}

		for (int i = 0; i < n; i++) {
			bw.write(result[i] + " ");
		}

		bw.flush();
	}
}
