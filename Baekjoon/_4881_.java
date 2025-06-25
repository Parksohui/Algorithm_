import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _4881_ { // 자리수의 제곱

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		String a = "", b = "";

		while (!(a = st.nextToken()).equals("0") && !(b = st.nextToken()).equals("0")) {
			bw.write(a + " " + b + " ");

			if (a.equals(b)) {
				bw.write("2\n");
				st = new StringTokenizer(bf.readLine());
				continue;
			}

			ArrayList<String> listA = new ArrayList<>();
			listA.add(a);

			while (true) {
				int sum = 0;
				for (int i = 0; i < a.length(); i++) {
					sum += (a.charAt(i) - '0') * (a.charAt(i) - '0');
				}
				a = Integer.toString(sum);
				if (listA.contains(a)) {
					break;
				}
				listA.add(a);
			}

			int result = 1;
			ArrayList<int[]> list = new ArrayList<>();

			Set<String> set = new HashSet<>();
			set.add(b);

			if (listA.contains(b)) {
				list.add(new int[] { Integer.parseInt(b), result });
			}
			while (true) {
				int sum = 0;
				for (int i = 0; i < b.length(); i++) {
					sum += (b.charAt(i) - '0') * (b.charAt(i) - '0');
				}
				b = Integer.toString(sum);
				result += 1;

				if (set.contains(b)) {
					break;
				}

				if (listA.contains(b)) {
					list.add(new int[] { Integer.parseInt(b), result });
				}

				set.add(b);
			}
			if (list.size() == 0) {
				bw.write("0\n");
			} else {
				result = Integer.MAX_VALUE;
				for (int j = 0; j < list.size(); j++) {
					int temp = list.get(j)[1];
					for (int i = 0; i < listA.size(); i++) {
						temp += 1;
						if (listA.get(i).equals(Integer.toString(list.get(j)[0]))) {
							break;
						}
					}
					result = Math.min(result, temp);
				}
				bw.write(result + "\n");
			}
			st = new StringTokenizer(bf.readLine());
		}
		bw.flush();
	}
}
