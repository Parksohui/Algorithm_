import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class _3758_ { // KCPC

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(bf.readLine());

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int id = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());

			ArrayList<int[]> score = new ArrayList<>();
			ArrayList<int[]> info = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				score.add(new int[k + 1]);
				info.add(new int[] { j, 0, 0, 0 }); // 팀 번호, 최종 점수, 제출 횟수, 마지막 제출 시간
			}

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(bf.readLine());

				int team = Integer.parseInt(st.nextToken()) - 1;
				int num = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				if (score.get(team)[num] == 0 || score.get(team)[num] < s) {
					info.get(team)[1] = info.get(team)[1] - score.get(team)[num] + s;
					score.get(team)[num] = s;
				}
				info.get(team)[2] += 1;
				info.get(team)[3] = j;
			}

			Collections.sort(info, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						if (o1[2] == o2[2]) {
							return o1[3] - o2[3];
						}
						return o1[2] - o2[2];
					}
					return o2[1] - o1[1];
				}
			});

			for (int j = 0; j < n; j++) {
				if (info.get(j)[0] == id) {
					bw.write(j + 1 + "\n");
					break;
				}
			}
		}
		bw.flush();
	}
}
