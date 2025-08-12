import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _4865_ { // Shortest Prefixes

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";

		ArrayList<String> list = new ArrayList<>();

		while ((str = bf.readLine()) != null) {
			list.add(str);
		}

		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 1; j <= list.get(i).length(); j++) {
				String temp = list.get(i).substring(0, j);
				boolean flag = false;

				for (int k = 0; k < list.size(); k++) {
					if (i == k) {
						continue;
					}
					if (list.get(k).startsWith(temp)) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					result.add(temp);
					break;
				}
			}
			if (result.size() < (i + 1)) {
				result.add(list.get(i));
			}
		}

		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + " " + result.get(i) + "\n");
		}
		bw.flush();
	}
}
