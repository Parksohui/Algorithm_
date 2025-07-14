import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _14210_ { // Kartomat

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char arr[][] = { { '*', '*', '*', 'A', 'B', 'C', 'D', 'E' }, { 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M' },
				{ 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U' }, { 'V', 'W', 'X', 'Y', 'Z', '*', '*', '*' } };

		int N = Integer.parseInt(bf.readLine());

		String letters[] = new String[N];
		for (int i = 0; i < N; i++) {
			letters[i] = bf.readLine();
		}

		String letter = bf.readLine();

		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (letters[i].startsWith(letter)) {
				list.add(letters[i].charAt(letter.length()));
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				if (list.contains(arr[i][j])) {
					bw.write(arr[i][j]);
				} else {
					bw.write("*");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
