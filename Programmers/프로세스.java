import java.util.*;

class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 0;

		Queue<int[]> queue = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < priorities.length; i++) {
			queue.add(new int[] { i, priorities[i] });
			list.add(priorities[i]);
		}

		Collections.sort(list, Collections.reverseOrder());
		for (int i = 0; i < list.size(); i++) {
			while (list.get(i) != queue.peek()[1]) {
				queue.add(queue.poll());
			}
			int temp[] = queue.poll();
			if (temp[0] == location) {
				answer = i + 1;
			}
		}

		return answer;
	}
}