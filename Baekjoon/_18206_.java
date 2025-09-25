import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _18206_ { // Soft Passwords

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String s = bf.readLine();
		String p = bf.readLine();

		String reverse = "";
		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i))) {
				if (Character.isUpperCase(s.charAt(i))) {
					reverse += Character.toLowerCase(s.charAt(i));
				} else {
					reverse += Character.toUpperCase(s.charAt(i));
				}
			} else {
				reverse += s.charAt(i);
			}
		}

		boolean flag = false;
		if (s.equals(p) || (Character.isDigit(s.charAt(0)) && p.equals(s.substring(1)))
				|| (Character.isDigit(s.charAt(s.length() - 1)) && p.equals(s.substring(0, s.length() - 1)))
				|| reverse.equals(p)) {
			flag = true;
		}

		if (flag) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
