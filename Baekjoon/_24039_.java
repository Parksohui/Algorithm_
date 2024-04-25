import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24039_ { // 2021은 무엇이 특별할까?

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		boolean arr[] = new boolean[10001];
		for (int i = 2; i < 5001; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < 10001; j += i) {
					arr[j] = true;
				}
			}
		}

		int a = 2;
		int b = -1;
		for (int i = 3; i < 10001; i++) {
			if (!arr[i]) {
				b = i;
				if (a * b > n) {
					System.out.println(a * b);
					break;
				}
				a = i;
			}
		}
	}
}
