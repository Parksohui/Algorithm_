import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;

public class _3518_ { // 공백왕 빈-칸

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";

		ArrayList<ArrayList<String>> list = new ArrayList<>();
		ArrayList<Integer> len = new ArrayList<>();

		while ((str = bf.readLine()) != null) {
			st = new StringTokenizer(str);

			ArrayList<String> word = new ArrayList<>();
			int idx = 0;

			while (st.hasMoreTokens()) {
				word.add(st.nextToken());
				if (len.size() <= idx) {
					len.add(word.get(idx).length());
				} else {
					len.set(idx, Math.max(len.get(idx), word.get(idx).length()));
				}
				idx++;
			}
			list.add(word);
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				bw.write(list.get(i).get(j));

				if (j == list.get(i).size() - 1) {
					break;
				}
				for (int k = 0; k < (len.get(j) - list.get(i).get(j).length()) + 1; k++) {
					bw.write(" ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
