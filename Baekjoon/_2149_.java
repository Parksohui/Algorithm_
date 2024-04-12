import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _2149_ { // 암호 해독

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String key = bf.readLine();
		String str = bf.readLine();

		char arr[][] = new char[(str.length() / key.length()) + 1][key.length()];
		char keyArr[] = new char[key.length()];
		char ori[] = new char[key.length()];

		for (int i = 0; i < key.length(); i++) {
			ori[i] = key.charAt(i);
			keyArr[i] = key.charAt(i);
		}

		int idx = 0;
		for (int j = 0; j < key.length(); j++) {
			for (int i = 1; i <= (str.length() / key.length()); i++) {
				arr[i][j] = str.charAt(idx++);
			}
		}

		Arrays.sort(keyArr);
		for (int i = 0; i < key.length(); i++) {
			arr[0][i] = keyArr[i];
		}

		boolean visited[] = new boolean[key.length()];

		for(int j=1; j<arr.length; j++) {
			for (int k = 0; k < key.length(); k++) {
				for (int i = 0; i < key.length(); i++) {
					if (!visited[i] && ori[k] == arr[0][i]) {
						visited[i] = true;
						bw.write(arr[j][i]);
						break;
					}
				}
			}
			for(int k=0; k<key.length(); k++) {
				visited[k]=false;
			}
		}
		bw.flush();
	}
}
