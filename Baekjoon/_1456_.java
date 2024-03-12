import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1456_ { // 거의 소수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		boolean arr[] = new boolean[(int) Math.sqrt(B) + 1];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i < ((int) Math.sqrt(B) + 1) / 2 + 1; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < (int) Math.sqrt(B) + 1; j += i) {
					arr[j] = true;
				}
			}
		}

		int result = 0;
		for (int i = 1; i <= (int) Math.sqrt(B); i++) {
			if (!arr[i]) {
				long num = Long.valueOf(i);
				while ((num*=Long.valueOf(i)) <= B) {
					if(num >=A) {
						result += 1;
					}
					if(num > B/Long.valueOf(i)) {
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
