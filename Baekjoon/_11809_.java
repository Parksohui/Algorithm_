import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11809_ { // YODA

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String a = bf.readLine();
		String b = bf.readLine();

		char arr[] = new char[a.length()];
		char arr2[] = new char[b.length()];

		for (int i = 0; i < a.length(); i++) {
			arr[i] = a.charAt(i);
		}

		for (int i = 0; i < b.length(); i++) {
			arr2[i] = b.charAt(i);
		}

		int min = Math.min(a.length(), b.length());

		for (int i = 0; i < min; i++) {
			if (arr[a.length() - 1 - i] < arr2[b.length() - 1 - i]) {
				arr[a.length() - 1 - i] = ' ';
			} else if (arr[a.length() - 1 - i] > arr2[b.length() - 1 - i]) {
				arr2[b.length() - 1 - i] = ' ';
			}
		}

		String result = new String(arr).replace(" ", "");
		if (result.equals("")) {
			System.out.println("YODA");
		} else {
			System.out.println(Integer.parseInt(result));
		}

		result = new String(arr2).replace(" ", "");
		if (result.equals("")) {
			System.out.println("YODA");
		} else {
			System.out.println(Integer.parseInt(result));
		}
	}
}
