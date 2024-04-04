import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _21919_ { // 소수 최소 공배수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		boolean arr[] = new boolean[1000001];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i < 500001; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < 1000001; j += i) {
					arr[j] = true;
				}
			}
		}

		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!arr[num]) {
				set.add(num);
			}
		}

		if (set.size() == 0)
			System.out.println(-1);
		else {
			long result = 1;
			for (int num : set) {
				result *= num;
			}
			System.out.println(result);
		}
	}
}
