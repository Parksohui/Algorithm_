import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _9787_ { // Olympic Games Ranking
	static class Nation implements Comparable<Nation> {
		String country;
		int gold;
		int silver;
		int bronze;
		int sum;

		public Nation(String country, int gold, int silver, int bronze) {
			this.country = country;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.sum = gold + silver + bronze;
		}

		@Override
		public int compareTo(Nation o) {
			if (o.gold == this.gold) {
				if (o.silver == this.silver) {
					if (o.bronze == this.bronze) {
						return this.country.compareTo(o.country);
					}
					return o.bronze - this.bronze;
				}
				return o.silver - this.silver;
			}
			return o.gold - this.gold;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";
		ArrayList<Nation> list = new ArrayList<>();
		while ((str = bf.readLine()) != null && !str.equals("")) {
			st = new StringTokenizer(str);

			list.add(new Nation(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);

		int idx = 1;
		for (int i = 0; i < list.size(); i++) {
			if (i > 0 && !(list.get(i - 1).gold == list.get(i).gold && list.get(i - 1).silver == list.get(i).silver
					&& list.get(i - 1).bronze == list.get(i).bronze)) {
				idx = i + 1;
			}
			bw.write(idx + " " + list.get(i).country + " " + list.get(i).gold + " " + list.get(i).silver + " "
					+ list.get(i).bronze + " " + list.get(i).sum + "\n");
		}
		bw.flush();
	}
}