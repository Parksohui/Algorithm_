import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _18679_ { // Banana

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			String x = st.nextToken();
			st.nextToken();
			String y = st.nextToken();

			map.put(x, y);
		}

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(bf.readLine());

			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < k; j++) {
				bw.write(map.get(st.nextToken()) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
