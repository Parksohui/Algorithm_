import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _5092_ { // Air Old Zeeland

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = 0;
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			HashMap<String, int[]> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());

				map.put(st.nextToken(),
						new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}

			int c = Integer.parseInt(bf.readLine());
			int cnt = 0;

			for (int i = 0; i < c; i++) {
				st = new StringTokenizer(bf.readLine());

				int number = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());

				int value = 0;
				boolean flag = false;
				for (int j = 0; j < p; j++) {
					String product = bf.readLine();

					if (m >= map.get(product)[1]) {
						value += map.get(product)[0];
					} else {
						flag = true;
					}
				}
				bw.write(number + " " + value);
				if (flag) {
					cnt += 1;
					bw.write(" *");
				}
				bw.write("\n");
			}
			bw.write("Number of discontented customers is: " + cnt + "\n");
		}
		bw.flush();
	}
}
