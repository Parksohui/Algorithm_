import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _19621_ { // 회의실 배정 2
	static class Info {
		private int start;
		private int end;
		private int num;

		public Info(int start, int end, int num) {
			this.start = start;
			this.end = end;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		ArrayList<Info> list = new ArrayList<>();
		int dp[] = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			list.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list, new Comparator<Info>() {

			@Override
			public int compare(Info o1, Info o2) {
				return o1.end - o2.end;
			}
		});

		for (int i = 0; i < n; i++) {
			dp[i] = list.get(i).num;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (list.get(i).start >= list.get(j).end) {
					dp[i] = Math.max(dp[i], dp[j] + list.get(i).num);
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
