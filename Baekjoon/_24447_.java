import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _24447_ { // 알고리즘 수업 - 너비 우선 탐색 4
	static ArrayList<ArrayList<Integer>> arr;
	static long t[], d[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken())-1;
		
		arr=new ArrayList<>();
		t=new long[n];
		d=new long[n];
		
		for(int i=0; i<n; i++) {
			arr.add(new ArrayList<>());
			d[i]=-1;
		}
		
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		for(int i=0; i<n; i++) {
			Collections.sort(arr.get(i));
		}
		
		d[r]=0;
		t[r]=1;
		bfs(r);
		
		long result=0;
		for(int i=0; i<n; i++) {
			result+=d[i]*t[i];
		}
		System.out.println(result);
	}

	private static void bfs(int r) {
		Queue<Integer>queue=new LinkedList<>();
		queue.add(r);
		long t_num=t[r];
		
		while(!queue.isEmpty()) {
			int num=queue.poll();
			for(int i=0; i<arr.get(num).size(); i++) {
				int temp=arr.get(num).get(i);
				if(d[temp]==-1){
					d[temp]=d[num]+1;
					t[temp]=++t_num;
					queue.add(temp);
				}
			}
		}
	}
}
