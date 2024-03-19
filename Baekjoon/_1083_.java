import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1083_ { // 소트
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		ArrayList<int[]> list = new ArrayList<>();

		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
			list.add(new int[] { i, arr.get(i) });
		}

		int s = Integer.parseInt(bf.readLine());

		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				return o2[1] - o1[1];
			}
		});

		int idx = 0;

		while (s > 0) {
			for (int i = 0; i < list.size(); i++) {
				int info[] = list.get(i);
				if (info[1] > arr.get(idx) && info[0] - idx <= s) {
					s -= (info[0] - idx);
					arr.remove(info[0]);
					arr.add(idx, info[1]);
					break;
				}
			}
			list.clear();

			idx += 1;

			if (idx == n) {
				break;
			}

			for (int i = idx; i < n; i++) {
				list.add(new int[] { i, arr.get(i) });
			}

			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1])
						return o1[0] - o2[0];
					return o2[1] - o1[1];
				}
			});
		}

		for (int i = 0; i < n; i++) {
			bw.write(arr.get(i) + " ");
		}
		bw.flush();
	}
}
