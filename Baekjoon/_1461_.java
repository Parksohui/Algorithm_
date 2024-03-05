import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1461_ { // 도서관

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num < 0) {
				minus.add(num);
			} else {
				plus.add(num);
			}
		}

		Collections.sort(plus);
		Collections.sort(minus);

		int result = 0;

		int idx = plus.size() - 1;
		while (idx >= 0) {
			result += plus.get(idx) * 2;
			idx -= m;
		}

		idx = 0;
		while (idx < minus.size()) {
			result += (-minus.get(idx)) * 2;
			idx += m;
		}

		if (plus.size() > 0 && minus.size() > 0) {
			if (-minus.get(0) > plus.get(plus.size() - 1)) {
				result += minus.get(0);
			} else {
				result -= plus.get(plus.size() - 1);
			}
		}else {
			if(plus.size()>0) {
				result -= plus.get(plus.size() - 1);
			}else {
				result += minus.get(0);
			}
		}
		
		System.out.println(result);
	}
}
