import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _4649_ { // Tanning Salon

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";

		while (!(str = bf.readLine()).equals("0")) {
			st = new StringTokenizer(str);

			int bed = Integer.parseInt(st.nextToken());
			String customer = st.nextToken();

			HashSet<Character> set = new HashSet<>();

			int result = 0;
			for (int i = 0; i < customer.length(); i++) {
				if (set.contains(customer.charAt(i))) {
					set.remove(customer.charAt(i));
					continue;
				} 
				if (set.size() >= bed) {
					result += 1;
				}
				set.add(customer.charAt(i));
			}
			if (result == 0) {
				bw.write("All customers tanned successfully.\n");
			} else {
				bw.write(result + " customer(s) walked away.\n");
			}
		}
		bw.flush();
	}
}
