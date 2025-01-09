import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class _29881_ { // Account Names

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, String> firstLast = new HashMap<>();
		HashMap<String, String> firstAccount = new HashMap<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			firstLast.put(st.nextToken(), st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			firstAccount.put(st.nextToken(), st.nextToken());
		}

		for (String first : firstLast.keySet()) {
			bw.write(firstLast.get(first) + " " + firstAccount.get(first) + "\n");
		}
		bw.flush();
	}
}
