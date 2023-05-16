import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2002_ { // 추월

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		
		HashMap<String, Boolean> map=new HashMap<>();
		Queue<String>queue=new LinkedList<>();
		for(int i=0; i<n; i++) {
			String temp=bf.readLine();
			queue.add(temp);
			map.put(temp, false);
		}
		
		int result=0;
		for(int i=0; i<n; i++) {
			String num=bf.readLine();
			while(map.get(queue.peek())) {
				queue.poll();
			}
			if(queue.peek().equals(num)) {
				queue.poll();
			}else {
				result+=1;
			}
			map.put(num, true);
		}
		System.out.println(result);
	}
}
