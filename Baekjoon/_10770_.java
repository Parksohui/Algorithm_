import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10770_ { // Rövarspråket

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();

		String result = "";
		char arr[] = { 'a', 'e', 'i', 'o', 'u' };

		for (int i = 0; i < str.length(); i++) {
			boolean flag = false;
			char x = str.charAt(i);

			result += x;

			for (int j = 0; j < 5; j++) {
				if (x == arr[j]) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				int a = 0, b = 0;

				char temp = x;
				while (Character.isAlphabetic(temp)) {
					temp = (char) (temp - 1);
					a += 1;
					for (int j = 0; j < 5; j++) {
						if (temp == arr[j]) {
							flag = true;
							break;
						}
					}
					if (flag) {
						break;
					}
				}

				if (!flag) {
					a = Integer.MAX_VALUE;
				}

				flag = false;
				temp = x;
				while (Character.isAlphabetic(temp)) {
					temp = (char) (temp + 1);
					b += 1;
					for (int j = 0; j < 5; j++) {
						if (temp == arr[j]) {
							flag = true;
							break;
						}
					}
					if (flag) {
						break;
					}
				}

				if (!flag) {
					b = Integer.MAX_VALUE;
				}

				if (a <= b) {
					result += (char) (x - a);
				} else {
					result += (char) (x + b);
				}

				temp = x;
				if (temp == 'z') {
					result += 'z';
				} else {
					while (Character.isAlphabetic(temp)) {
						temp = (char) (temp + 1);
						flag = false;
						for (int j = 0; j < 5; j++) {
							if (temp == arr[j]) {
								flag = true;
								break;
							}
						}
						if (!flag) {
							result += temp;
							break;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
