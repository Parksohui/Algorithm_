import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _11969_ { // Breed Counting

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int cow[][] = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			int id = Integer.parseInt(bf.readLine()) - 1;

			for (int j = 0; j < 3; j++) {
				cow[i][j] = cow[i - 1][j];
			}

			cow[i][id] += 1;
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(bf.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 3; j++) {
				bw.write(cow[b][j] - cow[a - 1][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
