import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _270606_ { // Vertical Histogram

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int arr[] = new int[26];

		for (int i = 0; i < 4; i++) {
			String str = bf.readLine();

			for (int j = 0; j < str.length(); j++) {
				if (Character.isAlphabetic(str.charAt(j))) {
					arr[str.charAt(j) - 'A'] += 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < 26; i++) {
			max = Math.max(max, arr[i]);
		}

		int position[] = new int[max];
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < 26; j++) {
				if (arr[j] >= max) {
					position[i] = j;
				}
			}
			max -= 1;
		}

		max = position.length;
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j <= position[i]; j++) {
				if (arr[j] >= max) {
					bw.write("*");
					if(j != position[i]) {
						bw.write(" ");
					}
				} else {
					bw.write("  ");
				}
			}
			max-=1;
			bw.write("\n");
		}
		for (int i = 0; i < 26; i++) {
			bw.write((char) ('A' + i));
			if(i!=25) {
				bw.write(" ");
			}
		}
		bw.flush();
	}
}
