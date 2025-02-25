import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _14534_ { // String Permutation
	static char result[];
	static boolean visited[];
	static ArrayList<String> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			bw.write("Case # " + (i + 1) + ":\n");
			String str = bf.readLine();

			char[] arr = str.toCharArray();
			visited = new boolean[arr.length];
			result = new char[arr.length];
			answer = new ArrayList<>();
			permutation(arr, 0);

			for (String x : answer) {
				bw.write(x + "\n");
			}
		}
		bw.flush();
	}

	private static void permutation(char[] arr, int index) {
		if (index == arr.length) {
			answer.add(new String(result));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[index] = arr[i];
				permutation(arr, index + 1);
				visited[i] = false;
			}
		}
	}
}
