import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _6986_ { // 절사평균

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		BigDecimal arr[] = new BigDecimal[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new BigDecimal(bf.readLine());
		}

		Arrays.sort(arr);

		// 절사 평균
		BigDecimal sum = BigDecimal.ZERO;
		for (int i = k; i < n - k; i++) {
			sum=sum.add(arr[i]);
		}
		BigDecimal result=sum.divide(new BigDecimal(n - (2 * k)), 2, BigDecimal.ROUND_HALF_UP);
		bw.write(result+"\n");
		
		// 보정 평균
		for (int i = 0; i < k; i++) {
			sum=sum.add(arr[k]);
			sum=sum.add(arr[n-k-1]);
		}
		result= sum.divide(new BigDecimal(n),2, BigDecimal.ROUND_HALF_UP);
		bw.write(result+"");

		bw.flush();
	}
}
