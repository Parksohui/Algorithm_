import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _5568_ { // 카드 놓기
	static String arr[], result[];
	static boolean visited[];
	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());

		arr = new String[n];
		result = new String[k];
		visited = new boolean[n];
		set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			arr[i] = bf.readLine();
		}

		search(0, k);

		System.out.println(set.size());
	}

	private static void search(int idx, int k) {
		if (idx == k) {
			String str = "";
			for (int i = 0; i < k; i++) {
				str += result[i];
			}
			set.add(Integer.parseInt(str));

			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[idx] = arr[i];
				search(idx + 1, k);
				visited[i] = false;
			}
		}
	}
}
