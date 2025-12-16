import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _6235_ { // Argus

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		while (!(str = bf.readLine()).equals("#")) {
			st = new StringTokenizer(str);

			st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			queue.add(new int[] { num, p, p });
		}

		int k = Integer.parseInt(bf.readLine());

		for (int i = 0; i < k; i++) {
			int temp[] = queue.poll();
			bw.write(temp[0] + "\n");

			queue.add(new int[] { temp[0], temp[1] + temp[2], temp[2] });
		}
		bw.flush();
	}
}
