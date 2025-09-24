import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _31023_ { // Hit Song

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		for (int i = 0; i < n; i++) {
			int p = Integer.parseInt(bf.readLine());

			ArrayList<String> list = new ArrayList<>();
			for (int j = 0; j < p; j++) {
				list.add(bf.readLine().toLowerCase());
			}

			int l = Integer.parseInt(bf.readLine());

			int word = 0, cnt = 0;
			for (int j = 0; j < l; j++) {
				st = new StringTokenizer(bf.readLine());

				while (st.hasMoreTokens()) {
					String str = st.nextToken().toLowerCase();
					String arr[] = str.split("[^a-zA-Z]+");

					for (int k = 0; k < arr.length; k++) {
						if (arr[k].isEmpty()) {
							continue;
						}
						word += 1;
						if (list.contains(arr[k])) {
							cnt += 1;
						}
					}
				}
			}
			if ((double) cnt / word >= 0.75) {
				bw.write("It's a hit!\n");
			} else {
				bw.write("Delete immediately!\n");
			}
		}
		bw.flush();
	}
}
