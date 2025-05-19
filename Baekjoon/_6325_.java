import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _6325_ { // Definite Values

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = 0;
		int cnt = 1;

		while ((t = Integer.parseInt(bf.readLine())) != 0) {
			HashSet<String> set = new HashSet<>();
			set.add("a");

			for (int i = 0; i < t; i++) {
				st = new StringTokenizer(bf.readLine());

				String a = st.nextToken();
				st.nextToken();
				String b = st.nextToken();

				if (set.contains(b)) {
					set.add(a);
				} else {
					set.remove(a);
				}
			}

			ArrayList<String> list = new ArrayList<>(set);
			Collections.sort(list);

			bw.write("Program #" + (cnt++) + "\n");
			if (list.size() == 0) {
				bw.write("none\n");
			} else {
				for (int i = 0; i < list.size(); i++) {
					bw.write(list.get(i) + " ");
				}
				bw.write("\n");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
