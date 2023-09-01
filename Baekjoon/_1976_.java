import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976_ { // 여행 가자
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());

		arr = new int[n + 1];
		for(int i=0; i<n+1; i++) {
			arr[i]=i;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					int a = find(i + 1);
					int b = find(j + 1);

					if (a > b)
						arr[a] = b;
					else
						arr[b] = a;
				}
			}
		}

		st = new StringTokenizer(bf.readLine());
		int result = find(Integer.parseInt(st.nextToken()));
		boolean flag = false;

		for (int i = 1; i < m; i++) {
			int num = find(Integer.parseInt(st.nextToken()));
			if (result != num) {
				flag = true;
				break;
			}
		}

		if (!flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static int find(int i) {
		if (arr[i] == i)
			return i;
		return arr[i] = find(arr[i]);
	}

}
