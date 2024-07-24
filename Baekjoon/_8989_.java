import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _8989_ { // 시계
	static class Clock implements Comparable<Clock> {
		private String time;
		private double angle;

		public Clock(String time, double angle) {
			this.time = time;
			this.angle = angle;
		}

		@Override
		public int compareTo(Clock o) {
			if (this.angle == o.angle) {
				return this.time.compareTo(o.time);
			}
			return Double.compare(this.angle, o.angle);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());
			Clock answer[] = new Clock[5];

			for (int j = 0; j < 5; j++) {
				String time = st.nextToken();
				String arr[] = time.split(":");

				double h = Double.parseDouble(arr[0]);
				double m = Double.parseDouble(arr[1]);
				double result = Integer.MAX_VALUE;

				if (h > 12) {
					h -= 12;
				}
				h = h * 30 + 0.5 * m;
				m *= 6;
				result = Math.min((360 - m) + h, m + (360 - h));
				result = Math.min(result, Math.abs(m - h));
				answer[j] = new Clock(time, result);
			}
			Arrays.sort(answer);
			bw.write(answer[2].time + "\n");
		}
		bw.flush();
	}
}
