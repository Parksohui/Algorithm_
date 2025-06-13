import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _16524_ { // Database of Clients

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String email = bf.readLine();

			String[] at = email.split("@");
			at[0] = at[0].replace(".", "");

			if (at[0].contains("+")) {
				String[] plus = at[0].split("\\+");
				set.add(plus[0] + "@" + at[1]);
			} else {
				set.add(at[0] + "@" + at[1]);
			}
		}
		System.out.println(set.size());
	}
}
