import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2891_ { // 카약과 강풍

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		boolean damage[] = new boolean[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < s; i++) {
			damage[Integer.parseInt(st.nextToken())] = true;
		}

		boolean[] check = new boolean[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < r; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (damage[num]) {
				damage[num] = false;
			} else {
				check[num] = true;
			}
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (damage[i]) {
				if (check[i - 1]) {
					check[i - 1] = false;
					damage[i] = false;
				} else if (i<n && check[i + 1]) {
					check[i + 1] = false;
					damage[i] = false;
				} else {
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}

}
