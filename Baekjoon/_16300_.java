import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _16300_ { // H to O

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		String molecule = st.nextToken();
		int k = Integer.parseInt(st.nextToken());

		HashMap<Character, Integer> map = new HashMap<>();

		findMolecule(molecule, map, k);

		molecule = bf.readLine();
		HashMap<Character, Integer> map2 = new HashMap<>();
		findMolecule(molecule, map2, 1);

		int result = Integer.MAX_VALUE;
		ArrayList<Character> list = new ArrayList<>(map2.keySet());

		for (int i = 0; i < list.size(); i++) {
			if (!map.containsKey(list.get(i))) {
				result = 0;
				break;
			} else {
				if (map.get(list.get(i)) / map2.get(list.get(i)) == 0) {
					result = 0;
					break;
				}
				result = Math.min(result, map.get(list.get(i)) / map2.get(list.get(i)));
			}
		}

		System.out.println(result);
	}

	private static void findMolecule(String molecule, HashMap<Character, Integer> map, int k) {
		char temp = ' ';
		String num = "";
		for (int i = 0; i < molecule.length(); i++) {
			if (Character.isAlphabetic(molecule.charAt(i))) {
				if (temp != ' ') {
					if (num.equals("")) {
						num = "1";
					}
					if (map.containsKey(temp)) {
						map.replace(temp, map.get(temp) + (Integer.parseInt(num) * k));
					} else {
						map.put(temp, Integer.parseInt(num) * k);
					}
				}
				temp = molecule.charAt(i);
				num = "";
			} else {
				num += molecule.charAt(i);
			}
		}
		if (num.equals("")) {
			num = "1";
		}
		if (map.containsKey(temp)) {
			map.replace(temp, map.get(temp) + (Integer.parseInt(num) * k));
		} else {
			map.put(temp, Integer.parseInt(num) * k);
		}
	}
}
