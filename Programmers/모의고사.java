import java.util.*;

class Solution {
	public int[] solution(int[] answers) {
		int[] answer = {};

		int a[] = { 1, 2, 3, 4, 5 };
		int b[] = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int c[] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int aScore = 0, bScore = 0, cScore = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == a[i % a.length]) {
				aScore += 1;
			}
			if (answers[i] == b[i % b.length]) {
				bScore += 1;
			}
			if (answers[i] == c[i % c.length]) {
				cScore += 1;
			}
		}

		int max = Math.max(Math.max(aScore, bScore), cScore);

		ArrayList<Integer> list = new ArrayList<>();
		if (aScore == max) {
			list.add(1);
		}
		if (bScore == max) {
			list.add(2);
		}
		if (cScore == max) {
			list.add(3);
		}

		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}