import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _3077_ { // 임진왜란

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(st.nextToken(), i);
		}

		int b = n * (n - 1) / 2;
		int a = 0;

		String arr[] = new String[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = st.nextToken();
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (map.get(arr[i]) < map.get(arr[j]))
					a += 1;
			}
		}

		System.out.println(a + "/" + b);
	}
}
