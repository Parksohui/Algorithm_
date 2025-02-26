import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _8975_ { // PJESMA

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		HashSet<String> title = new HashSet<>();
		for (int i = 0; i < N; i++) {
			title.add(bf.readLine());
		}

		int M = Integer.parseInt(bf.readLine());

		HashSet<String> lyrics = new HashSet<>();
		for (int i = 0; i < M; i++) {
			String word = bf.readLine();
			if (title.contains(word)) {
				lyrics.add(word);
			}

			if (N % 2 == 0) {
				if (lyrics.size() == N / 2) {
					System.out.println((i + 1));
					break;
				}
			} else {
				if (lyrics.size() == (N / 2) + 1) {
					System.out.println((i + 1));
					break;
				}
			}
		}
	}
}
