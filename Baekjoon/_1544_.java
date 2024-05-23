import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _1544_ { // 사이클 단어

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();

			boolean flag = false;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).length() != str.length()) {
					continue;
				} else {
					Queue<Integer> queue = new LinkedList<>();
					for (int x = 0; x < list.get(j).length(); x++) {
						if (list.get(j).charAt(x) == str.charAt(0)) {
							queue.add(x);
						}
					}
					while (!queue.isEmpty()) {
						int start = queue.poll();
						boolean check = false;
						for (int x = start; x < list.get(j).length(); x++) {
							if (str.charAt(x - start) != list.get(j).charAt(x)) {
								check = true;
								break;
							}
						}
						if (!check) {
							check = false;
							for (int x = 0; x < start; x++) {
								if (str.charAt(str.length() - start + x) != list.get(j).charAt(x)) {
									check = true;
									break;
								}
							}
							if (!check) {
								flag = true;
								break;
							}
						}
					}
				}
				if (flag) {
					break;
				}
			}
			if (!flag) {
				list.add(str);
			}
		}
		System.out.println(list.size());
	}
}
