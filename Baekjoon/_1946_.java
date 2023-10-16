import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1946_ { // 신입 사원
	static class Person implements Comparable<Person> {
		private int a;
		private int b;

		public Person(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Person o) {
			return this.a - o.a;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		ArrayList<Person> arr = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(bf.readLine());
				arr.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			Collections.sort(arr);

			int result = 1;
			int idx = 0;
			for (int j = 1; j < n; j++) {
				if (arr.get(idx).b > arr.get(j).b) {
					result += 1;
					idx = j;
				}
			}
			bw.write(result + "\n");
			arr.clear();
		}
		bw.flush();
	}
}
