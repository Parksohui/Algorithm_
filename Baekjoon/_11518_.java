import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _11518_ { // Morse

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		HashMap<Character, String> map = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			st = new StringTokenizer(bf.readLine());

			map.put(st.nextToken().charAt(0), st.nextToken());
		}

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, String> word = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			String code = "";

			for (int j = 0; j < str.length(); j++) {
				code += map.get(str.charAt(j));
			}
			word.put(code, str);
		}

		ArrayList<String> list = new ArrayList<>();
		String result = "";
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			result = "";
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();

				if (word.containsKey(str)) {
					list.add(word.get(str));
				} else if (result.equals("")) {
					result = str;
				}
			}
			if (!result.equals("")) {
				bw.write(result + " not in dictionary.");
			} else {
				for (int i = 0; i < list.size(); i++) {
					bw.write(list.get(i) + " ");
				}
			}
			bw.write("\n");
			list.clear();
		}
		bw.flush();
	}
}
