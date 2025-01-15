import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class _4775_ { // Spelling Be

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(bf.readLine());
		}

		int idx = 1;
		ArrayList<String> list = new ArrayList<>();
		
		n = Integer.parseInt(bf.readLine());
		
		while (n > 0) {
			String str = bf.readLine();
			if (str.equals("-1")) {
				n--;
				if (list.size() > 0) {
					bw.write("Email " + (idx++) + " is not spelled correctly.\n");
					for (int i = 0; i < list.size(); i++) {
						bw.write(list.get(i) + "\n");
					}
				} else {
					bw.write("Email " + (idx++) + " is spelled correctly.\n");
				}
				list.clear();
			} else if (!set.contains(str)) {
				list.add(str);
			}
		}
		bw.write("End of Output");
		bw.flush();
	}
}
