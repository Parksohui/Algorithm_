import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class _11645_ { // I’ve Been Everywhere, Man

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			for (int j = 0; j < n; j++) {
				set.add(bf.readLine());
			}
			bw.write(set.size() + "\n");
			set.clear();
		}
		bw.flush();
	}
}
