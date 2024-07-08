import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1980_ { // 햄버거 사랑

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		if (n > m) {
			int temp = n;
			n = m;
			m = temp;
		}
		int max = 0, time = t, idx=0;
		while (t / n >= idx) {
			int temp = (t - (n * idx)) / m;
			if (t - (n * idx) - (m * temp) < time) {
				max = temp + idx;
				time = t - (n * idx) - (m * temp);
			} else if (t - (n * idx) - (m * temp) == time) {
				max = Math.max(max, temp + idx);
			}
			idx += 1;
		}
		System.out.println(max + " " + time);
	}
}
