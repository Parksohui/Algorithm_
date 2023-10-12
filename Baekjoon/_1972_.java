import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class _1972_ { // 놀라운 문자열

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";
		Set<String> set = new HashSet<>();
		boolean flag = false;

		while (!(str = bf.readLine()).equals("*")) {
			flag = false;
			for (int i = 1; i < str.length(); i++) {
				for (int j = 0; j < str.length(); j++) {
					if (j + i < str.length()) {
						String s = str.charAt(j) + "" + str.charAt(j + i);
						if (set.contains(s)) {
							flag = true;
							break;
						} else {
							set.add(s);
						}
					}
				}
				set.clear();
				if (flag)
					break;
			}
			if (flag)
				bw.write(str + " is NOT surprising.\n");
			else
				bw.write(str + " is surprising.\n");
		}
		bw.flush();
	}
}
