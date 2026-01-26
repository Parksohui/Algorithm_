import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _6221_ { // The Bale Tower
	static class Pair {
		int w, b;

		public Pair(int w, int b) {
			this.w = w;
			this.b = b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		ArrayList<Pair> list = new ArrayList<>();
		int dp[] = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			dp[i] = 1;
		}

		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.w == o2.w) {
					return o1.b - o2.b;
				}
				return o1.w - o2.w;
			}
		});

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (list.get(j).w < list.get(i).w && list.get(j).b < list.get(i).b) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);
	}
}
