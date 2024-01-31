import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _8892_ { // 팰린드롬
	static String arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		boolean check;

		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(bf.readLine());
			check = false;

			arr = new String[k];
			for (int j = 0; j < k; j++) {
				arr[j] = bf.readLine();
			}

			for (int j = 0; j < k; j++) {
				for (int l = 0; l < k; l++) {
					if (j == l) {
						continue;
					}
					if (!palindrome(arr[j] + arr[l])) {
						check = true;
						bw.write(arr[j] + arr[l] + "\n");
						break;
					}
				}
				if(check) {
					break;
				}
			}
			if (!check) {
				bw.write(0 + "\n");
			}
		}
		bw.flush();
	}

	private static boolean palindrome(String str) {
		boolean flag = false;
		for (int i = 0; i < str.length() / 2; i++) {

			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
