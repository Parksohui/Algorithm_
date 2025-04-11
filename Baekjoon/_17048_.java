import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _17048_ { // Jarvis

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		int arr[][] = new int[2][N];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[0][i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[1][i] = Integer.parseInt(st.nextToken());
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (map.containsKey(arr[1][i] - arr[0][i])) {
				map.replace(arr[1][i] - arr[0][i], map.get(arr[1][i] - arr[0][i]) + 1);
			} else {
				map.put(arr[1][i] - arr[0][i], 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2) - map.get(o1);
			}
		});

		System.out.println(map.get(list.get(0)));
	}
}
