import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _6973_ { // Dynamic Dictionary Coding

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		String str = "";
		HashMap<String, Integer> map = new HashMap<>();
		int idx = 1;
		boolean flag=false;

		while (n > 0) {
			str = bf.readLine();

			if (str == null || str.equals("")) {
				n -= 1;
				map.clear();
				idx = 1;
				if (n == 0) {
					break;
				} else {
					bw.write("\n");
				}
			} else if(flag){
				bw.write("\n");
			}

			st = new StringTokenizer(str);
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				if (map.containsKey(word)) {
					bw.write(map.get(word) + " ");
				} else {
					bw.write(word + " ");
					map.put(word, idx++);
				}
			}
			flag=true;
		}
		bw.flush();
	}
}
