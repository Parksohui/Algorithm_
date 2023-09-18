import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2828_ { // 사과 담기 게임

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int start = 1;
		int end = start + m - 1;

		int j = Integer.parseInt(bf.readLine());

		int result = 0;

		for (int i = 0; i < j; i++) {
			int k = Integer.parseInt(bf.readLine());
			if (start <= k && end >= k) {
				continue;
			} else {
				if (Math.abs(k - start) > Math.abs(k - end)) {
					result += Math.abs(k - end);
					start += Math.abs(k - end);
					end += Math.abs(k - end);
				} else if(Math.abs(k - start) < Math.abs(k - end)) {
					result += Math.abs(k - start);
					end -= Math.abs(k - start);
					start -= Math.abs(k - start);
				}else {
					if(k < start) {
						result += Math.abs(k - start);
						end -= Math.abs(k - start);
						start -= Math.abs(k - start);
					}else {
						result += Math.abs(k - end);
						start += Math.abs(k - end);
						end += Math.abs(k - end);
					}
				}
			}
		}
		System.out.println(result);
	}
}
