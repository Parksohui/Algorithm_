import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _4676_ { // Haiku Review

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";
		int syllable[] = { 5, 7, 5 };
		char vowel[] = { 'a', 'e', 'i', 'o', 'u', 'y' };

		while (!(str = bf.readLine()).equals("e/o/i")) {
			String[] arr = str.split("/");
			boolean wrong = false;

			for (int i = 0; i < 3; i++) {
				int cnt = 0;
				boolean flag = false;

				for (int j = 0; j < arr[i].length(); j++) {
					boolean check = false;
					for (int k = 0; k < 6; k++) {
						if (arr[i].charAt(j) == vowel[k]) {
							check = true;
							break;
						}
					}
					if (!flag && check) {
						flag = true;
						cnt += 1;
					} else if (flag && !check) {
						flag = false;
					}
				}
				if (syllable[i] != cnt) {
					wrong = true;
					bw.write((i + 1) + "\n");
					break;
				}
			}
			if (!wrong) {
				bw.write("Y\n");
			}
		}
		bw.flush();
	}
}
