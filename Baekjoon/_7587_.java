import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;

public class _7587_ { // Anagrams

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = 0;
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			ArrayList<String> word = new ArrayList<>();
			ArrayList<Integer> cnt = new ArrayList<>();
			ArrayList<String> sort = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();

				char[] charArr = str.toCharArray();
				Arrays.sort(charArr);
				String sortStr = new String(charArr);

				if (!sort.contains(sortStr)) {
					word.add(str);
					cnt.add(0);
					sort.add(sortStr);
				} else {
					int idx = sort.indexOf(sortStr);
					cnt.set(idx, cnt.get(idx) + 1);
				}
			}
			int max = 0, idx = 0;
			for (int i = 0; i < cnt.size(); i++) {
				if (max < cnt.get(i)) {
					max = cnt.get(i);
					idx = i;
				}
			}
			bw.write(word.get(idx) + " " + max + "\n");
		}
		bw.flush();
	}
}
