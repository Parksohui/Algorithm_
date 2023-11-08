import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1713_ { // 후보 추천하기
	static class Draw {
		private int person;
		private int cnt;
		private int seq;

		private Draw(int person, int cnt, int seq) {
			this.person = person;
			this.cnt = cnt;
			this.seq = seq;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());

		ArrayList<Draw> list = new ArrayList<>();
		ArrayList<Integer> arr = new ArrayList<>();
		int idx = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (arr.contains(num)) {
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).person == num) {
						list.get(j).cnt += 1;
					}
				}
			} else {
				if (list.size() >= n) {
					Collections.sort(list, new Comparator<Draw>() {
						@Override
						public int compare(Draw o1, Draw o2) {
							if (o1.cnt == o2.cnt) {
								return o1.seq - o2.seq;
							}
							return o1.cnt - o2.cnt;
						}
					});
					Draw draw = list.remove(0);
					arr.remove(Integer.valueOf(draw.person));
				}
				arr.add(num);
				list.add(new Draw(num, 1, idx++));
			}
		}

		Collections.sort(arr);

		for (int i = 0; i < arr.size(); i++) {
			bw.write(arr.get(i) + " ");
		}
		bw.flush();
	}
}
