import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _15323_ { // ZigZag
	static class Word implements Comparable<Word> {
		private String w;
		private int count;

		public Word(String w, int count) {
			this.w = w;
			this.count = count;
		}

		@Override
		public int compareTo(Word o) {
			if (this.count == o.count) {
				return this.w.compareTo(o.w);
			}
			return this.count - o.count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		HashMap<Character, PriorityQueue<Word>> map = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			map.put((char) ('a' + i), new PriorityQueue<>());
		}

		for (int i = 0; i < k; i++) {
			String str = bf.readLine();
			map.get(str.charAt(0)).add(new Word(str, 0));
		}

		for (int i = 0; i < n; i++) {

			char x = bf.readLine().charAt(0);

			Word word = map.get(x).poll();
			bw.write(word.w + "\n");
			word.count += 1;
			map.get(x).add(word);
		}
		bw.flush();
	}
}
