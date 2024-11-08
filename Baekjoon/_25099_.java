import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class _25099_ { // Anagram

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		HashSet<String> anagram = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();

			char[] temp = str.toCharArray();
			Arrays.sort(temp);
			String result = new String(temp);

			if (!anagram.contains(result)) {
				anagram.add(result);
				bw.write(str + "\n");
			}
		}
		bw.flush();
	}
}
