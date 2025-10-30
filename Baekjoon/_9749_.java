import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class _9749_ { // Another Word Sorting
	static class Info implements Comparable<Info> {
		private String word;
		private int score;

		public Info(String word, int score) {
			this.word = word;
			this.score = score;
		}

		@Override
		public int compareTo(Info o) {
			if (o.score == this.score) {
				return this.word.compareTo(o.word);
			}
			return o.score - this.score;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";

		ArrayList<Info> list = new ArrayList<>();
		while ((str = bf.readLine()) != null) {
			int num = str.charAt(0) - 96;

			boolean flag = false;
			for (int i = 1; i < str.length(); i++) {
				num += str.charAt(i) - 96;
				if (!flag && str.charAt(i - 1) == str.charAt(i)) {
					flag = true;
					num += (2 * (str.charAt(i) - 96));
				} else {
					flag = false;
				}
			}
			list.add(new Info(str, num));
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i).word + "\n");
		}
		bw.flush();
	}
}
