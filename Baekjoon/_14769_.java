import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class _14769_ { // Stacking Cups
	static class Info implements Comparable<Info> {
		private String color;
		private int radius;

		public Info(String color, int radius) {
			this.color = color;
			this.radius = radius;
		}

		@Override
		public int compareTo(Info o) {
			return this.radius - o.radius;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		Info[] arr = new Info[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			String a = st.nextToken();
			String b = st.nextToken();

			if (Character.isDigit(a.charAt(0))) {
				arr[i] = new Info(b, Integer.parseInt(a) / 2);
			} else {
				arr[i] = new Info(a, Integer.parseInt(b));
			}
		}

		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			bw.write(arr[i].color + "\n");
		}
		bw.flush();
	}
}
