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

public class _26043_ { // 식당 메뉴

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		ArrayList<Integer> c = new ArrayList<>();

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				queue.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			} else {
				int num = Integer.parseInt(st.nextToken());

				int info[] = queue.poll();
				if (info[1] == num) {
					a.add(info[0]);
				} else {
					b.add(info[0]);
				}
			}
		}

		while (!queue.isEmpty()) {
			c.add(queue.poll()[0]);
		}

		if (a.size() == 0) {
			bw.write("None\n");
		} else {
			Collections.sort(a);
			for (int i = 0; i < a.size(); i++) {
				bw.write(a.get(i) + " ");
			}
			bw.write("\n");
		}

		if (b.size() == 0) {
			bw.write("None\n");
		} else {
			Collections.sort(b);
			for (int i = 0; i < b.size(); i++) {
				bw.write(b.get(i) + " ");
			}
			bw.write("\n");
		}

		if (c.size() == 0) {
			bw.write("None\n");
		} else {
			Collections.sort(c);
			for (int i = 0; i < c.size(); i++) {
				bw.write(c.get(i) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
