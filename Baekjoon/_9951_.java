import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _9951_ { // Word Extraction

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";
		HashSet<String> set = new HashSet<>();

		while (!(str = bf.readLine()).equals("#")) {
			st = new StringTokenizer(str);

			while (st.hasMoreTokens()) {
				str = st.nextToken();
				String word = "";
				boolean flag = false;
				for (int i = 0; i < str.length(); i++) {
					if (Character.isAlphabetic(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
						if (Character.isAlphabetic(str.charAt(i))) {
							flag = true;
						}
						word += Character.toLowerCase(str.charAt(i));
					}
				}
				if (word.equals("") || !flag) {
					continue;
				}
				set.add(word);
			}

			ArrayList<String> list = new ArrayList<>(set);
			Collections.sort(list);
			set.clear();

			for (String x : list) {
				bw.write(x + "\n");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
