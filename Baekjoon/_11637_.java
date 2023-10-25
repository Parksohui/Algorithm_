import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _11637_ { // 인기 투표

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}

		});

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());
			int sum = 0;
			for (int k = 0; k < n; k++) {
				int x = Integer.parseInt(bf.readLine());
				sum += x;
				queue.add(new int[] { k + 1, x });
			}
			int temp[] = queue.poll();
			if (temp[1] == queue.peek()[1]) {
				bw.write("no winner \n");
			} else {
				if (temp[1] > sum / 2)
					bw.write("majority winner " + temp[0] + "\n");
				else
					bw.write("minority winner " + temp[0] + "\n");
			}
			queue.clear();
		}
		bw.flush();
	}
}
