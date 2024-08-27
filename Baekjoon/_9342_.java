import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

public class _9342_ { // 염색체

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			String str = bf.readLine();

			if (Pattern.matches("^[A-F]?A+F+C+[A-F]?", str)) {
				bw.write("Infected!\n");
			} else {
				bw.write("Good\n");
			}
		}
		bw.flush();
	}
}
