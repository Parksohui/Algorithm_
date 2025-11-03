import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _21149_ { // Unread Messages

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int s = Integer.parseInt(bf.readLine());

			if (map.containsKey(s)) {
				sum -= (i - map.get(s) - 1);
			} else {
				sum -= i;
			}
			map.put(s, i);

			sum += (n - 1);

			bw.write(sum + "\n");
		}
		bw.flush();
	}
}
