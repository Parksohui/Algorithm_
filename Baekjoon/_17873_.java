import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17873_ { // Regional Team Names

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();

		String arr[] = str.split("-");

		if (arr.length < 2) {
			System.out.println("NO");
		} else {
			int num = 0;
			for (int i = 1; i < arr.length; i++) {
				num += arr[i].length();
			}
			if (arr[0].length() > 1 && arr[0].length() <= 8 && num >= 1 && num <= 24) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
