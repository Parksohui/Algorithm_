import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _8979_ { // 올림픽
	static class Country implements Comparable<Country> {
		private int num;
		private int gold;
		private int silver;
		private int bronze;

		public Country(int num, int gold, int silver, int bronze) {
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Country country) {
			if (country.gold == this.gold) {
				if (country.silver == this.silver) {
					return country.bronze - this.bronze;
				}
				return country.silver - this.silver;
			}
			return country.gold - this.gold;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Country> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			Country country = new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			queue.add(country);
		}

		int result = 1;
		int idx = 1;
		Country country = queue.poll();

		if (country.num == k) {
			System.out.println(1);
		} else {
			while (!queue.isEmpty()) {
				Country temp = queue.poll();
				idx += 1;
				if (!(country.gold == temp.gold && country.silver == temp.silver && country.bronze == temp.bronze)) {
					result = idx;
				}
				if (temp.num == k) {
					System.out.println(result);
					break;
				}
				country = temp;
			}
		}
	}
}
