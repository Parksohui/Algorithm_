import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _25101_ { // Robin Hood

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o2[0] - o1[0];
			}
		});

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			queue.add(new int[] { Integer.parseInt(st.nextToken()), i });
		}

		boolean flag = false;
		for (int i = 0; i < k; i++) {
			if (queue.peek()[0] <= 100) {
				flag = true;
				break;
			}
			int temp[] = queue.poll();
			temp[0] -= 100;
			queue.add(temp);
		}

		if (flag) {
			bw.write("impossible");
		} else {
			int result[] = new int[n];
			while (!queue.isEmpty()) {
				int temp[] = queue.poll();
				result[temp[1]] = temp[0];
			}
			for (int i = 0; i < n; i++) {
				bw.write(result[i] + " ");
			}
		}
		bw.flush();
	}
}
