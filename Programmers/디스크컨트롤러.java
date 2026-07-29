import java.util.*;

class Solution {
	public int solution(int[][] jobs) {
		int answer = 0;

		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2]) {
					if (o1[1] == o2[1]) {
						return o1[0] - o2[0];
					}
					return o1[1] - o2[1];
				}
				return o1[2] - o2[2];
			}
		});

		int idx = 0, time = 0;

		while (idx < jobs.length) {
			while (idx < jobs.length && time >= jobs[idx][0]) {
				queue.add(new int[] { idx, jobs[idx][0], jobs[idx][1] });
				idx += 1;
			}
			if (queue.isEmpty()) {
				time = jobs[idx][0];
				while (idx < jobs.length && time >= jobs[idx][0]) {
					queue.add(new int[] { idx, jobs[idx][0], jobs[idx][1] });
					idx += 1;
				}
			}
			int job[] = queue.poll();
			if (time < job[1]) {
				time = job[1] + job[2];
			} else {
				time += job[2];
			}
			answer += time - job[1];
		}

		while (!queue.isEmpty()) {
			int job[] = queue.poll();

			if (time < job[1]) {
				time = job[1] + job[2];
			} else {
				time += job[2];
			}
			answer += time - job[1];
		}

		answer /= jobs.length;

		return answer;
	}
}