import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _5671_ { // 호텔 방 번호

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str="";
		Set<Integer> set = new HashSet<>();
		boolean flag = false;

		while ((str = bf.readLine()) != null) {
			st = new StringTokenizer(str);

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int result = 0;

			for (int i = a; i <= b; i++) {
				String num = Integer.toString(i);
				flag = false;
				for (int j = 0; j < num.length(); j++) {
					if (set.contains(num.charAt(j) - '0')) {
						flag = true;
						break;
					} else {
						set.add(num.charAt(j) - '0');
					}
				}
				set.clear();
				if (!flag) {
					result += 1;
				}
			}
			System.out.println(result);
		}
	}
}
