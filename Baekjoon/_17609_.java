import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _17609_ { // 회문
	static String str;
	static boolean remove, check, result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			str = bf.readLine();

			int start = 0, end = str.length() - 1;
			remove = false;
			check = false;
			result = false;

			check(start, end);

			if (check) {
				bw.write("2\n");
			} else if (remove) {
				bw.write("1\n");
			} else if (result) {
				bw.write("0\n");
			}
		}
		bw.flush();
	}

	private static void check(int start, int end) {
		while (start != end) {
			if (result) {
				break;
			}
			if (str.charAt(start) == str.charAt(end)) {
				if (start + 1 > end - 1 || start + 1 == end - 1) {
					result = true;
					break;
				}
				start++;
				end--;
			} else if (!remove) {
				if (str.charAt(start + 1) == str.charAt(end) && str.charAt(start) == str.charAt(end - 1)) {
					remove = true;
					if (start + 1 == end) {
						break;
					}
					check(start + 1, end);
					if (check) {
						check = false;
					}
					check(start, end - 1);
				}
				if (str.charAt(start) == str.charAt(end - 1)) {
					remove = true;
					start++;
					end -= 2;
				} else if (str.charAt(start + 1) == str.charAt(end)) {
					remove = true;
					start += 2;
					end--;
				} else {
					check = true;
					break;
				}
			} else {
				check = true;
			}
			if (result) {
				break;
			}
			if (check) {
				break;
			}
		}
	}
}
