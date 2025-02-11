import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _4368_ { // Babelfish

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		HashMap<String, String> map = new HashMap<>();

		String str = "";
		while (!(str = bf.readLine()).equals("")) {
			st = new StringTokenizer(str);

			String english = st.nextToken();
			String foreign = st.nextToken();

			map.put(foreign, english);
		}

		while ((str = bf.readLine()) != null) {
			if (map.containsKey(str)) {
				bw.write(map.get(str) + "\n");
			} else {
				bw.write("eh\n");
			}
		}
		bw.flush();
	}
}
