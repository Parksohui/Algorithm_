import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _23246_ { // Sport Climbing Combined

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			int num = Integer.parseInt(st.nextToken());

			int sum = 0;
			int score = 1;

			for (int j = 0; j < 3; j++) {
				int x = Integer.parseInt(st.nextToken());

				sum += x;
				score *= x;
			}
			list.add(new int[] { num, sum, score });
		}

		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2]) {
					if (o1[1] == o2[1]) {
						return o1[0] - o2[0];
					}
					return o1[1] - o2[1];
				}
				return o1[2] - o2[2];
			}
		});

		for (int i = 0; i < 3; i++) {
			bw.write(list.get(i)[0] + " ");
		}
		bw.flush();
	}
}
