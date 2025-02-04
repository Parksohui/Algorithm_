import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _6513_ { // Deli Deli

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int L = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(bf.readLine());
			map.put(st.nextToken(), st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			String str = bf.readLine();

			if (map.containsKey(str)) {
				bw.write(map.get(str) + "\n");
			} else if (!(str.charAt(str.length() - 2) == 'a' || str.charAt(str.length() - 2) == 'e'
					|| str.charAt(str.length() - 2) == 'i' || str.charAt(str.length() - 2) == 'o'
					|| str.charAt(str.length() - 2) == 'u') && (str.charAt(str.length() - 1) == 'y')) {
				bw.write(str.substring(0, str.length() - 1) + "ies\n");
			} else if (str.charAt(str.length() - 1) == 'o' || str.charAt(str.length() - 1) == 's'
					|| str.charAt(str.length() - 1) == 'x' || str.substring(str.length() - 2).equals("ch")
					|| str.substring(str.length() - 2).equals("sh")) {
				bw.write(str + "es\n");
			} else {
				bw.write(str + "s\n");
			}
		}
		bw.flush();
	}
}
