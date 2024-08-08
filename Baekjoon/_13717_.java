import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _13717_ { // 포켓몬 GO
	static class Pokemon implements Comparable<Pokemon> {
		private String name;
		private int cnt;

		public Pokemon(String name, int cnt) {
			this.name = name;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pokemon o) {
			return o.cnt - this.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		ArrayList<Pokemon> list = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < n; i++) {
			String p = bf.readLine();

			st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int cnt = 0;
			while (k <= m) {
				m = m - k + 2;
				cnt += 1;
			}
			sum += cnt;
			list.add(new Pokemon(p, cnt));
		}
		Collections.sort(list);

		System.out.println(sum + "\n" + list.get(0).name);
	}
}
