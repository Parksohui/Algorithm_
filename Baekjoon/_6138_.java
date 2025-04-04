import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _6138_ { // Exploration

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int T = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		Integer arr[] = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Math.abs(o1) - Math.abs(o2);
			}
		});

		int result = 0, before = 0;;
		for (int i = 0; i < N; i++) {
			if (T - Math.abs((arr[i] - before)) >= 0) {
				T -= Math.abs((arr[i] - before));
				before = arr[i];
				result+=1;
			}else {
				break;
			}
		}
		System.out.println(result);
	}
}
