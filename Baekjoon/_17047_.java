import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17047_ { // Titlovi

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";

		ArrayList<ArrayList<String>> list = new ArrayList<>();

		while (true) {
			ArrayList<String> temp = new ArrayList<>();

			temp.add(bf.readLine());

			st = new StringTokenizer(bf.readLine());

			String start = st.nextToken();
			st.nextToken();
			String end = st.nextToken();

			temp.add(start);
			temp.add(end);

			while (!(str = bf.readLine()).isEmpty()) {
				if (str.equals("#")) {
					break;
				}
				temp.add(str);
			}
			list.add(temp);
			if (str.equals("#")) {
				break;
			}
		}
		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> temp = list.get(i);

			bw.write(temp.get(0) + "\n");

			for (int j = 1; j < 3; j++) {
				int ttt = Integer.parseInt(temp.get(j).split(",")[1]);
				int h = Integer.parseInt((temp.get(j).split(",")[0]).split(":")[0]);
				int m = Integer.parseInt((temp.get(j).split(",")[0]).split(":")[1]);
				int s = Integer.parseInt((temp.get(j).split(",")[0]).split(":")[2]);
				int cnt = 0;

				if (t < 0) {
					ttt += t;
					if (ttt < 0) {
						cnt = Math.abs(ttt) / 1000 + 1;
						ttt += 1000 * cnt;
						s -= cnt;

						if (s < 0) {
							cnt = Math.abs(s) / 60 + 1;
							s += 60 * cnt;
							m -= cnt;

							if (m < 0) {
								cnt = Math.abs(m) / 60 + 1;
								m += 60 * cnt;
								h -= cnt;
							}
						}
					}
				} else {
					ttt += t;
					if (ttt >= 1000) {
						cnt = ttt / 1000;
						ttt -= 1000 * cnt;
						s += cnt;

						if (s >= 60) {
							cnt = s / 60;
							s -= 60 * cnt;
							m += cnt;

							if (m >= 60) {
								cnt = m / 60;
								m -= 60 * cnt;
								h += cnt;
							}
						}
					}

				}
				bw.write(String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s)
						+ "," + String.format("%03d", ttt));
				if (j == 1) {
					bw.write(" --> ");
				} else {
					bw.write("\n");
				}
			}
			for (int j = 3; j < temp.size(); j++) {
				bw.write(temp.get(j) + "\n");
			}
			if (i < list.size() - 1) {
				bw.write("\n");
			}
		}
		bw.write("#");
		bw.flush();
	}
}
