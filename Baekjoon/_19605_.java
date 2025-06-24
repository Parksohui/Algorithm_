import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _19605_ { // Cyclic Shifts

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String T = bf.readLine();
		String S = bf.readLine();

		if (T.contains(S)) {
			System.out.println("yes");
		} else {
			boolean flag = false;
			for (int i = 0; i < S.length() - 1; i++) {
				S = S.substring(1, S.length()) + S.charAt(0);

				if (T.contains(S)) {
					flag = true;
					break;
				}
			}

			if (flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
