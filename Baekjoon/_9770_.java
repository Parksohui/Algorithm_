import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _9770_ { // GCD

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = "";
		int result = 0;

		ArrayList<Integer> list = new ArrayList<>();
		while ((str = bf.readLine()) != null) {
			st = new StringTokenizer(str);

			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				result = Math.max(result, gcd(list.get(i), list.get(j)));
			}
		}
		System.out.println(result);
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
