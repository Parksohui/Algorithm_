import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class _15081_ { // Is Everybody Appy?

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				String str = st.nextToken();

				if (!set.contains(str)) {
					set.add(str);
					bw.write(str + " ");
					break;
				}
			}
		}
		bw.flush();
	}
}
