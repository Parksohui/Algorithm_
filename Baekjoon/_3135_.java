import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _3135_ { // 라디오

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(bf.readLine());
		
		int min= Math.abs(b-a);
		int value=a;
		int result=0;
		
		for(int i=0; i<n; i++) {
			int num=Integer.parseInt(bf.readLine());
			if(min > Math.abs(b-num)) {
				min=Math.abs(b-num);
				value=num;
			}
		}
		
		if(value!=a) {
			result+=1;
		}
		result+= min;
		System.out.println(result);
	}
}
