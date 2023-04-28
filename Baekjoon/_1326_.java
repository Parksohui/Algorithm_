import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1326_ { // 폴짝폴짝
	static int arr[], b, n;
	static boolean visited[];
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(bf.readLine());
		
		arr=new int[n];
		visited=new boolean[n];
		result=0;
		st=new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(bf.readLine());
		int a=Integer.parseInt(st.nextToken())-1;
		b=Integer.parseInt(st.nextToken())-1;
		
		bfs(a);
		if(result==0) {
			if(a==b) System.out.println(result);
			else System.out.println(-1);
		}
		else System.out.println(result);
		
	}

	private static void bfs(int a) {
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int[] {a, 0});
		visited[a]=true;
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			int num=1;
			while(true) {
				int check=0;
				if(temp[0]+(arr[temp[0]]*num)<n ) {
					if(!visited[temp[0]+(arr[temp[0]]*num)]) {
						if(temp[0]+(arr[temp[0]]*num)==b) {
							result=temp[1]+1;
							break;
						}
						visited[temp[0]+(arr[temp[0]]*num)]=true;
						queue.add(new int[] {temp[0]+(arr[temp[0]]*num), temp[1]+1});
					}
					
					check+=1;
				}
				if(temp[0]-(arr[temp[0]]*num)>=0) {
					if(!visited[temp[0]-(arr[temp[0]]*num)]) {
						if(temp[0]-(arr[temp[0]]*num)==b) {
							result=temp[1]+1;
							break;
						}
						visited[temp[0]-(arr[temp[0]]*num)]=true;
						queue.add(new int[] {temp[0]-(arr[temp[0]]*num), temp[1]+1});
					}
					check+=1;
				}
				if(check==0) break;
				else num+=1;
			}
			if(result>0) break;
		}
	}
}
