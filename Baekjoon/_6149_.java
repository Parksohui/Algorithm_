import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6149_ { // Card Stacking

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= k; i++) {
			queue.add(i);
		}

		ArrayList<Integer> list = new ArrayList<>();

		int idx = 1;
		while (!queue.isEmpty()) {
			int card = queue.poll();
			if (idx == n) {
				list.add(card);
			}
			if(queue.isEmpty()) {
				break;
			}
			for (int i = 0; i < p; i++) {
				queue.add(queue.poll());
			}
			idx += 1;
			if (idx > n) {
				idx = 1;
			}
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}
		bw.flush();
	}
}
