import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _6379_ { // Scramble Sort

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";

		while (!(str = bf.readLine()).equals(".")) {
			st = new StringTokenizer(str, ", ");

			ArrayList<Integer> index = new ArrayList<>();
			ArrayList<String> alphabet = new ArrayList<>();
			ArrayList<Long> number = new ArrayList<>();

			while (st.hasMoreTokens()) {

				String temp = st.nextToken();

				if (!st.hasMoreTokens()) {
					temp = temp.substring(0, temp.length() - 1);
				}

				if (Character.isDigit(temp.charAt(0)) || temp.charAt(0) == '-') {
					index.add(1);
					number.add(Long.parseLong(temp));
				} else {
					index.add(0);
					alphabet.add(temp);
				}
			}

			Collections.sort(alphabet, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.toLowerCase().compareTo(o2.toLowerCase());
				}
			});
			Collections.sort(number);

			int idx1 = 0, idx2 = 0;
			for (int i = 0; i < index.size(); i++) {
				if (index.get(i) == 0) {
					bw.write(alphabet.get(idx1++));
				} else {
					bw.write(number.get(idx2++)+"");
				}
				if (i < index.size() - 1) {
					bw.write(", ");
				} else {
					bw.write(".\n");
				}
			}
		}
		bw.flush();
	}
}
