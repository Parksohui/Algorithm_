import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _20376_ { // Counting Monuments

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = "";
		HashSet<String> set = new HashSet<>();
		while ((str = bf.readLine()) != null) {
			st = new StringTokenizer(str);

			String result = "";
			st.nextToken();
			while (st.hasMoreTokens()) {
				result += st.nextToken() + " ";
			}
			set.add(result);
		}
		System.out.println(set.size());
	}
}
