import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _6212_ { // Dream Counting

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i <= 9; i++) {
			map.put(i, 0);
		}

		for (int i = M; i <= N; i++) {
			String str = Integer.toString(i);

			for (int j = 0; j < str.length(); j++) {
				map.replace(str.charAt(j) - '0', map.get(str.charAt(j) - '0') + 1);
			}
		}

		for (int i = 0; i <= 9; i++) {
			bw.write(map.get(i) + " ");
		}
		bw.flush();
	}
}
