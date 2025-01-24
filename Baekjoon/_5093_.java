import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;

public class _5093_ { // Letter Replacement

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";
		while (!(str = bf.readLine()).equals("#")) {
			HashSet<Character> set = new HashSet<>();
			HashMap<Character, Character> map = new HashMap<>();

			String result = "";
			int idx = 1;
			for (int i = 0; i < str.length(); i++) {
				if (!set.contains(Character.toLowerCase(str.charAt(i)))) {
					set.add(Character.toLowerCase(str.charAt(i)));
					result += str.charAt(i);
				} else {
					if (map.containsKey(Character.toLowerCase(str.charAt(i)))) {
						result += map.get(Character.toLowerCase(str.charAt(i)));
					} else {
						if (idx == 1) {
							map.put(Character.toLowerCase(str.charAt(i)), '*');
						} else if (idx == 2) {
							map.put(Character.toLowerCase(str.charAt(i)), '?');
						} else if (idx == 3) {
							map.put(Character.toLowerCase(str.charAt(i)), '/');
						} else if (idx == 4) {
							map.put(Character.toLowerCase(str.charAt(i)), '+');
						} else if (idx == 5) {
							map.put(Character.toLowerCase(str.charAt(i)), '!');
						}
						result += map.get(Character.toLowerCase(str.charAt(i)));
						idx += 1;
					}
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
	}
}
