import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class _2671_ { // 잠수함식별

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();
		if (Pattern.matches("(100+1+|01)+", str)) {
			System.out.println("SUBMARINE");
		} else {
			System.out.println("NOISE");
		}
	}
}
