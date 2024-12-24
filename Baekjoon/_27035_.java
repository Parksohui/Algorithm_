import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _27035_ { // Bovine Ballroom Dancing

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		int boy[] = new int[n];
		int girl[] = new int[n];

		for (int i = 0; i < n; i++) {
			boy[i] = Integer.parseInt(bf.readLine());
		}

		for (int i = 0; i < n; i++) {
			girl[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(boy);
		Arrays.sort(girl);

		int result = 0;
		for (int i = 0; i < n; i++) {
			result += Math.abs(boy[i] - girl[i]);
		}
		System.out.println(result);
	}
}
