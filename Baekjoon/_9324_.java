import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class _9324_ { // 진짜 메시지

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t; i++) {
			String str = bf.readLine();

			int idx = 0;
			boolean flag = false;
			while (idx < str.length()) {
				if (map.containsKey(str.charAt(idx))) {
					map.replace(str.charAt(idx), map.get(str.charAt(idx)) + 1);
					if (map.get(str.charAt(idx)) % 3 == 0) {
						if (idx + 1 >= str.length() || str.charAt(idx + 1) != str.charAt(idx)) {
							flag = true;
							break;
						}else {
							idx += 2;
						}
					} else {
						idx += 1;
					}
				} else {
					map.put(str.charAt(idx), 1);
					idx += 1;
				}
			}
			if (flag) {
				bw.write("FAKE\n");
			} else {
				bw.write("OK\n");
			}
			map.clear();
		}
		bw.flush();
	}
}
