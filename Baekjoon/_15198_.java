import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _15198_ { // NKD

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = Integer.parseInt(bf.readLine());
		int n = Integer.parseInt(bf.readLine());

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();

			if (list.contains(str)) {
				list.remove(str);
				list.add(str);
			} else {
				if (list.size() >= k) {
					list.remove(0);
				}
				list.add(str);
			}
		}

		int min = Math.min(list.size() - 1, k - 1);
		for (int i = min; i >= 0; i--) {
			bw.write(list.get(i) + "\n");
		}
		bw.flush();
	}
}
