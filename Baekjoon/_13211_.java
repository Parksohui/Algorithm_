import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _13211_ { // Passport Checking

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		Set<String> set = new HashSet<>();
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
