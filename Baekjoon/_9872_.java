import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _9872_ { // Record Keeping

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		ArrayList<Integer> cnt = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());

			ArrayList<String> temp = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				temp.add(st.nextToken());
			}
			Collections.sort(temp);

			if (list.size() == 0) {
				list.add(temp);
				cnt.add(1);
				continue;
			}

			boolean flag = false;
			for (int j = 0; j < list.size(); j++) {
				flag = false;
				for (int k = 0; k < 3; k++) {
					if (!list.get(j).get(k).equals(temp.get(k))) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					cnt.set(j, cnt.get(j) + 1);
					break;
				}
			}
			if (flag) {
				list.add(temp);
				cnt.add(1);
			}
		}
		Collections.sort(cnt, Collections.reverseOrder());
		System.out.println(cnt.get(0));
	}
}
