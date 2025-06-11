import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class _4836_ { // 춤

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";

		while ((str = bf.readLine()) != null) {
			st = new StringTokenizer(str);

			ArrayList<String> list = new ArrayList<>();
			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}

			Set<Integer> set = new HashSet<>();
			ArrayList<Integer> num = new ArrayList<>();
			boolean twirl = false, hop = false, dip = false;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals("dip")) {
					dip = true;
					if ((i - 1 >= 0 && list.get(i - 1).equals("jiggle"))
							|| (i - 2 >= 0 && list.get(i - 2).equals("jiggle"))
							|| (i + 1 < list.size() && list.get(i + 1).equals("twirl"))) {
						continue;
					} else {
						set.add(1);
						num.add(i);
					}
				}
				if (list.get(i).equals("twirl")) {
					twirl = true;
				}
				if (list.get(i).equals("hop")) {
					hop = true;
				}
			}
			if (list.size() < 3 || !(list.get(list.size() - 3).equals("clap")
					&& list.get(list.size() - 2).equals("stomp") && list.get(list.size() - 1).equals("clap"))) {
				set.add(2);
			}
			if (twirl) {
				if (!hop) {
					set.add(3);
				}
			}
			if (list.get(0).equals("jiggle")) {
				set.add(4);
			}
			if (!dip) {
				set.add(5);
			}

			if (set.size() == 0) {
				bw.write("form ok: ");
				for (int i = 0; i < list.size(); i++) {
					bw.write(list.get(i) + " ");
				}
			} else {
				ArrayList<Integer> result = new ArrayList<>(set);
				Collections.sort(result);

				if (result.size() == 1) {
					bw.write("form error " + result.get(0) + ": ");
				} else {
					bw.write("form errors ");

					Collections.sort(result);
					for (int i = 0; i < result.size(); i++) {
						bw.write(result.get(i) + "");
						if (i < result.size() - 2) {
							bw.write(", ");
						} else if (i == result.size() - 2) {
							bw.write(" and ");
						}
					}
					bw.write(": ");
				}
				for (int i = 0; i < list.size(); i++) {
					if (num.contains(i)) {
						bw.write("DIP ");
					} else {
						bw.write(list.get(i) + " ");
					}
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
