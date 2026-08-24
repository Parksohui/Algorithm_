import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			int num = 100 - progresses[i];

			int day = num / speeds[i];

			if (num % speeds[i] != 0) {
				day += 1;
			}

			if (i > 0 && list.get(list.size() - 1) > day) {
				day = list.get(list.size() - 1);
			}
			list.add(day);
		}

		ArrayList<Integer> result = new ArrayList<>();
		int temp = list.get(0);
		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			if (temp == list.get(i)) {
				cnt += 1;
			} else {
				result.add(cnt);
				temp = list.get(i);
				cnt = 1;
			}
		}
		if (cnt > 0) {
			result.add(cnt);
		}

		answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}
}