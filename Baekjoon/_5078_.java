import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _5078_ { // Shirts

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<String> list = new ArrayList<>();
		int n = 0;

		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			for (int i = 0; i < n; i++) {
				list.add(bf.readLine());
			}

			n = Integer.parseInt(bf.readLine());
			for (int i = 0; i < n; i++) {
				list.add(bf.readLine());
			}

			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.charAt(0) == o2.charAt(0)) {
						return o1.charAt(1) - o2.charAt(1);
					}
					return o2.charAt(0) - o1.charAt(0);
				}
			});

			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i) + " ");
			}
			list.clear();
			bw.write("\n");
		}
		bw.flush();
	}
}
