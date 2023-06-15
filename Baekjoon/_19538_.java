import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _19538_ { // 루머
	static ArrayList<ArrayList<Integer>> arr;
	static int visited[];
	static int result[];
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n=Integer.parseInt(bf.readLine()); 
		result=new int[n]; 
		arr=new ArrayList<>(); 
		visited=new int[n]; 
		for(int i=0; i<n; i++) {
			arr.add(new ArrayList<>());
			result[i]=-1;
		}
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(bf.readLine());
			while(st.hasMoreTokens()) {
				int num=Integer.parseInt(st.nextToken())-1;
				if(num!=-1) {
					arr.get(i).add(num);
				}
			}
		}
		
		int person=Integer.parseInt(bf.readLine());
		st=new StringTokenizer(bf.readLine());
		
		Queue<int[]>queue=new LinkedList<>();
		for(int i=0; i<person; i++) {
			int a=Integer.parseInt(st.nextToken())-1;
			queue.add(new int[] {a, 0});
		}
		
		bfs(queue);
		
		for(int i=0; i<n; i++) {
			bw.write(result[i]+" ");
		}
		bw.flush();
		
	}
	private static void bfs(Queue<int[]> queue) {
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			if(result[temp[0]]>-1) continue;
			result[temp[0]]=temp[1];
			for(int i=0; i<arr.get(temp[0]).size(); i++) {
				int num=arr.get(temp[0]).get(i);
				visited[num]+=1;
				if(result[num]==-1 && visited[num] >= (double)arr.get(num).size()/2 ) {
					queue.add(new int[] {num, temp[1]+1});
				}
			}
			
		}
	}
}
