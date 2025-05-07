import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11999_ { // Milk Pails (Bronze)

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int q = M / X;

		int result = X * q--;

		int cnt = 1;
		while (cnt <= M / Y) {
			int temp = X * q--;
			if (temp + (Y * cnt) <= M) {
				temp += (Y * cnt++);
			}
			result = Math.max(result, temp);
		}
		System.out.println(result);
	}
}
