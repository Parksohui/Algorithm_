import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class _4446_ { // ROT13

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";
		Character v[] = { 'a', 'i', 'y', 'e', 'o', 'u' };
		Character c[] = { 'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm',
				'f' };

		while ((str = bf.readLine()) != null) {
			String result = "";
			for (int i = 0; i < str.length(); i++) {
				if (!Character.isAlphabetic(str.charAt(i))) {
					result += str.charAt(i);
				} else {
					char x = Character.toLowerCase(str.charAt(i));
					int idx = -1;

					for (int j = 0; j < v.length; j++) {
						if (v[j] == x) {
							idx = j + 3;
							if (idx >= v.length) {
								idx -= v.length;
							}
							x = v[idx];
							break;
						}
					}
					if (idx == -1) {
						for (int j = 0; j < c.length; j++) {
							if (c[j] == x) {
								idx = j + 10;
								if (idx >= c.length) {
									idx -= c.length;
								}
								x = c[idx];
								break;
							}
						}
					}

					if (Character.isUpperCase(str.charAt(i))) {
						result += Character.toUpperCase(x);
					} else {
						result += x;
					}
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
	}
}
