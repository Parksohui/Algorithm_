import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _6160_ { // Election Time
	static class Info {
		private int idx;
		private int A;
		private int B;

		public Info(int idx, int A, int B) {
			this.idx = idx;
			this.A = A;
			this.B = B;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Info[] voteA = new Info[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			voteA[i] = new Info((i + 1), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(voteA, new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				return o2.A - o1.A;
			}
		});

		Info[] voteB = new Info[K];
		for (int i = 0; i < K; i++) {
			voteB[i] = voteA[i];
		}

		Arrays.sort(voteB, new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				return o2.B - o1.B;
			}
		});
		System.out.println(voteB[0].idx);
	}
}
