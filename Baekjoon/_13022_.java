import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13022_ { // 늑대와 올바른 단어

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();

		int w = 0, o = 0, l = 0, f = 0;
		if (str.length() < 4) {
			System.out.println("0");
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			if (i == 0) {
				if (str.charAt(i) != 'w') {
					System.out.println("0");
					return;
				}
				w += 1;
				if (!(str.charAt(i + 1) == 'w' || str.charAt(i + 1) == 'o')) {
					System.out.println("0");
					return;
				}
			} else if (i == str.length() - 1) {
				if (str.charAt(i) != 'f' || o != l) {
					System.out.println("0");
					return;
				}
				f += 1;
				if (l != f) {
					System.out.println("0");
					return;
				}

			} else {
				if (str.charAt(i) == 'w') {
					if (str.charAt(i - 1) == 'f') {
						w = 0;
						o = 0;
						l = 0;
						f = 0;
					}
					w += 1;
					if (!(str.charAt(i + 1) == 'w' || str.charAt(i + 1) == 'o') || l != f) {
						System.out.println("0");
						return;
					}
				} else if (str.charAt(i) == 'o') {
					o += 1;
					if (!(str.charAt(i + 1) == 'o' || str.charAt(i + 1) == 'l')) {
						System.out.println("0");
						return;
					}
				} else if (str.charAt(i) == 'l') {
					l += 1;
					if (!(str.charAt(i + 1) == 'l' || str.charAt(i + 1) == 'f') || w != o) {
						System.out.println("0");
						return;
					}
				} else if (str.charAt(i) == 'f') {
					f += 1;
					if (!(str.charAt(i + 1) == 'f' || str.charAt(i + 1) == 'w') || o != l) {
						System.out.println("0");
						return;
					}
				}
			}
		}
		System.out.println("1");
	}
}
