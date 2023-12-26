import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _28432_ { // 끝말잇기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		Set<String> set = new HashSet<>();
		char before = '0';
		char after = '0';
		boolean flag_before = false;
		boolean flag_after = false;

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			if (!str.equals("?")) {
				set.add(str);
				if (flag_before && !flag_after) {
					after = str.charAt(0);
					flag_after = true;
				}
			} else {
				flag_before = true;
			}
			if (!flag_before)
				before = str.charAt(str.length() - 1);

		}

		String result = "";

		int m = Integer.parseInt(bf.readLine());
		if (n == 1) {
			System.out.println(bf.readLine());
		} else {
			for (int i = 0; i < m; i++) {
				String str = bf.readLine();
				if ((str.charAt(0) == before || before == '0')
						&& (str.charAt(str.length() - 1) == after || after == '0') && !set.contains(str)) {
					result = str;
				}
			}
			System.out.println(result);
		}
	}
}
