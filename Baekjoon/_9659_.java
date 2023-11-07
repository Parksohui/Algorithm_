import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9659_ { // 돌 게임 5

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(bf.readLine());

		if (n % 2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}
