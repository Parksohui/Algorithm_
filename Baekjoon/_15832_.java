import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;

public class _15832_ { // Aku Negaraku

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";

		while (!(str = bf.readLine()).equals("0 0")) {
			st = new StringTokenizer(str);

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			ArrayList<Integer> list = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				list.add(i);
			}

			int idx = 0;
			while (list.size() > 1) {
				idx = (idx + m - 1) % list.size();

				list.remove(idx);
			}
			bw.write(list.get(0) + "\n");
		}
		bw.flush();
	}
}
