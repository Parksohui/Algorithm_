import java.util.*;

class Solution {
	public int[] solution(String[] operations) {
		int[] answer = { 0, 0 };

		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < operations.length; i++) {
			String str[] = operations[i].split(" ");
			int num = Integer.parseInt(str[1]);

			if (str[0].charAt(0) == 'I') {
				if (map.containsKey(num)) {
					map.put(num, map.get(num) + 1);
				} else {
					map.put(num, 1);
				}
			} else {
				if (map.size() == 0) {
					continue;
				}
				if (num == 1) {
					if (map.lastEntry().getValue() == 1) {
						map.remove(map.lastKey());
					} else {
						map.put(map.lastKey(), map.get(map.lastKey()) - 1);
					}
				} else {
					if (map.firstEntry().getValue() == 1) {
						map.remove(map.firstKey());
					} else {
						map.put(map.firstKey(), map.get(map.firstKey()) - 1);
					}
				}
			}
		}

		if (!map.isEmpty()) {
			answer[0] = map.lastKey();
			answer[1] = map.firstKey();
		}
		return answer;
	}
}