import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13549_ { // 숨바꼭질 3

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int result=0;
		
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int[] {n, 0});
		HashSet<Integer> set=new HashSet<>();
		set.add(n);
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			if(temp[0]*2<=100000 && !set.contains(temp[0]*2)) {
				if(temp[0]*2 == k) {
					result=temp[1];
					break;
				}
				set.add(temp[0]*2);
				queue.add(new int[] {temp[0]*2, temp[1]});
			}
			if(temp[0]-1>=0 && !set.contains(temp[0]-1)) {
				if(temp[0]-1 == k) {
					result=temp[1]+1;
					break;
				}
				set.add(temp[0]-1);
				queue.add(new int[] {temp[0]-1, temp[1]+1});
			}
			if(temp[0]+1<=100000 && !set.contains(temp[0]+1)) {
				if(temp[0]+1 == k) {
					result=temp[1]+1;
					break;
				}
				set.add(temp[0]+1);
				queue.add(new int[] {temp[0]+1, temp[1]+1});
			}
		}
		System.out.println(result);
	}
}
