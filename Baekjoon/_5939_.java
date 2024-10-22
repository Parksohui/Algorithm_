import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _5939_ { // Race Results
	static class Time implements Comparable<Time> {
		private int h;
		private int m;
		private int s;

		public Time(int h, int m, int s) {
			this.h = h;
			this.m = m;
			this.s = s;
		}

		@Override
		public int compareTo(Time o) {
			if (this.h == o.h) {
				if (this.m == o.m) {
					return this.s - o.s;
				}
				return this.m - o.m;
			}
			return this.h - o.h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		ArrayList<Time> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			list.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list);

		for (int i = 0; i < N; i++) {
			bw.write(list.get(i).h + " " + list.get(i).m + " " + list.get(i).s + "\n");
		}
		bw.flush();
	}
}
