import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class _11507_ { // 카드셋트

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = bf.readLine();

		int idx = 0;
		Set<String> set = new HashSet<>();
		int p = 13, k = 13, h = 13, t = 13;
		boolean flag = false;

		while (idx < str.length()) {
			String temp = str.substring(idx, idx + 3);
			if (set.contains(temp)) {
				flag = true;
				break;
			} else {
				set.add(temp);
				if (temp.charAt(0) == 'P')
					p -= 1;
				else if (temp.charAt(0) == 'K')
					k -= 1;
				else if (temp.charAt(0) == 'H')
					h -= 1;
				else if (temp.charAt(0) == 'T')
					t -= 1;
			}
			idx += 3;
		}
		if(flag) {
			System.out.println("GRESKA");
		}else {
			bw.write(p + " " + k + " " + h + " " + t);
			bw.flush();
		}
	}
}
