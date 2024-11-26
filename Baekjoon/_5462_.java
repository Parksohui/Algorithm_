import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _5462_ { // POI
	static class Person implements Comparable<Person> {
		private int score;
		private int problem;
		private int id;

		public Person(int score, int problem, int id) {
			this.score = score;
			this.problem = problem;
			this.id = id;
		}

		@Override
		public int compareTo(Person o) {
			if (this.score == o.score) {
				if (this.problem == o.problem) {
					return this.id - o.id;
				}
				return o.problem - this.problem;
			}
			return o.score - this.score;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N][T];
		int score[] = new int[T];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < T; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					score[j] += 1;
				}
			}
		}

		PriorityQueue<Person> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = 0, s = 0;
			for (int j = 0; j < T; j++) {
				if (arr[i][j] == 1) {
					num += 1;
					s += score[j];
				}
			}
			queue.add(new Person(s, num, i + 1));
		}

		int rank = 0;
		Person person = null;
		while (!queue.isEmpty()) {
			person = queue.poll();
			if (person.id == P) {
				rank += 1;
				break;
			}
			rank += 1;
		}
		System.out.println((person.score) + " " + rank);
	}
}
