import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11609_ { // Class Time
	static class Name implements Comparable<Name> {
		private String first;
		private String last;

		public Name(String first, String last) {
			this.first = first;
			this.last = last;
		}

		@Override
		public int compareTo(Name o) {
			if (this.last.compareTo(o.last) == 0) {
				return this.first.compareTo(o.first);
			}
			return this.last.compareTo(o.last);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		Name[] arr = new Name[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = new Name(st.nextToken(), st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i].first + " " + arr[i].last);
		}
	}
}
