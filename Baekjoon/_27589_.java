import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _27589_ { // Streets Ahead

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(bf.readLine(), i + 1);
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(bf.readLine());

			String start = st.nextToken();
			String end = st.nextToken();

			bw.write((Math.abs(map.get(start) - map.get(end)) - 1) + "\n");
		}
		bw.flush();
	}
}
