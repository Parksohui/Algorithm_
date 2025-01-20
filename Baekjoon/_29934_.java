import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.io.IOException;

public class _29934_ { // Important Messages

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(bf.readLine());
		}

		int m = Integer.parseInt(bf.readLine());

		int result = 0;
		for (int i = 0; i < m; i++) {
			if (set.contains(bf.readLine())) {
				result += 1;
			}
		}
		System.out.println(result);
	}
}
