import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class _4675_ { // Word Amalgamation

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = 2;
		HashMap<String, ArrayList<String>> map = new HashMap<>();

		while (num > 0) {
			String str = bf.readLine();

			if (str.equals("XXXXXX")) {
				num -= 1;
			} else {
				char[] arr = str.toCharArray();
				Arrays.sort(arr);
				String result = new String(arr);

				if (num == 2) {
					if (map.containsKey(result)) {
						map.get(result).add(str);
					} else {
						ArrayList<String> temp = new ArrayList<>();
						temp.add(str);
						map.put(result, temp);
					}
				} else {
					if (map.containsKey(result)) {
						ArrayList<String> temp = map.get(result);
						Collections.sort(temp);

						for (String x : temp) {
							bw.write(x + "\n");
						}
					} else {
						bw.write("NOT A VALID WORD\n");
					}
					bw.write("******\n");
				}
			}
		}
		bw.flush();
	}
}
