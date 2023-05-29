import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14719_ { // 빗물

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int arr[] = new int[w];
		int result = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int num = 0, idx = 0;
		while (idx < w - 1) {
			int start = arr[num];
			int end = arr[num + 1];
			for (int i = num + 1; i < w; i++) {
				if (end <= arr[i]) {
					end = arr[i];
					idx = i;
				}
				if (start < arr[i]) {
					end = arr[i];
					idx = i;
					break;
				}
			}
			int min_val = start;
			if (start > end)
				min_val = end;

			for (int i = num; i < idx; i++) {
				if (min_val - arr[i] > 0) {
					result += min_val - arr[i];
				}
			}
			num = idx;
		}
		System.out.println(result);
	}
}
