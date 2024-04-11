import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12927_ { // 배수 스위치

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();

		boolean[] arr = new boolean[str.length() + 1];
		for (int i = 1; i <= str.length(); i++) {
			if (str.charAt(i - 1) == 'Y') {
				arr[i] = true;
			}
		}

		int result = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i]) {
				result += 1;
				int idx = i;
				while (idx < arr.length) {
					arr[idx] = !arr[idx];
					idx += i;
				}
			}
		}
		System.out.println(result);
	}
}
