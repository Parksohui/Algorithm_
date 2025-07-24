import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _10442_ { // Rank Order

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str;
		int idx = 1;

		st = new StringTokenizer(bf.readLine());

		while (true) {
			if (!st.hasMoreTokens()) {
				str = bf.readLine();
				if (str == null) {
					break;
				}
				if (str.equals("")) {
					continue;
				}
				st = new StringTokenizer(str);
			}
			if (idx > 1) {
				bw.write("\n");
			}
			bw.write("Case " + (idx++) + ": ");

			int n = Integer.parseInt(st.nextToken());

			ArrayList<int[]> first = new ArrayList<>();
			int cnt = 0;

			while (first.size() < n) {
				if (!st.hasMoreTokens()) {
					str = bf.readLine();
					if (str.equals("")) {
						continue;
					}
					st = new StringTokenizer(str);
				}
				first.add(new int[] { Integer.parseInt(st.nextToken()), cnt++ });

			}

			Collections.sort(first, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[0] - o1[0];
				}
			});

			ArrayList<int[]> second = new ArrayList<>();
			cnt = 0;
			while (second.size() < n) {
				if (!st.hasMoreTokens()) {
					str = bf.readLine();
					if (str.equals("")) {
						continue;
					}
					st = new StringTokenizer(str);
				}
				second.add(new int[] { Integer.parseInt(st.nextToken()), cnt++ });
			}

			Collections.sort(second, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[0] - o1[0];
				}
			});

			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if (first.get(i)[1] != second.get(i)[1]) {
					flag = true;
					bw.write((i + 1) + "");
					break;
				}
			}
			if (!flag) {
				bw.write("agree");
			}
		}
		bw.flush();
	}
}
