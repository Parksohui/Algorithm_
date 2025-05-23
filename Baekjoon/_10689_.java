import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _10689_ { // Hamza

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(bf.readLine());

			st = new StringTokenizer(bf.readLine());
			HashSet<Integer> set = new HashSet<>();
			int result = 0;
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());

				if (!set.contains(num)) {
					set.add(num);
					result = j + 1;
				}
			}
			bw.write("Case " + (i + 1) + ": " + result + "\n");
		}
		bw.flush();
	}
}
