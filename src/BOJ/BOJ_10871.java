package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 	문제) 
 	정수 N개로 이루어진 수열A와 정수X가 주어지는데 A에서 X보다 작은수를 출력하기 
 	
 	입력조건) - (1이상 10,000 이하 정수를 입력한다는 조건) 
 	첫줄 - N,X 
 	둘째줄 - 수열 A를 이루는 정수N개 
 */
public class BOJ_10871 {

	public static void main(String[] args) {
		
		// 방법1)
		/*
			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] a = new int[n]; 
			
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			
			// x보다 작은수를 출력 
			for(int i=0;i<n;i++) {
				if(x > a[i]) System.out.print(a[i]+" ");
		}
		*/
		
		// 방법2) 
		/*
		 	입력받을 데이터 양이 많으면 하나씩 입력받고 처리하는 것보다 여러개를 입력받은 다음
		 	버퍼에 쌓아놓고 한꺼번에 처리하는게 속도면에서 더빠름 
		 	Scanner Vs BufferedReader 속도차이 참고 
		 	: https://sjs2215.tistory.com/93
		 */
		
		// enter만 경계로 인식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// IO 입출력 같은 경우는 IOException이 발생할 수 있기 때문에 예외처리를 강제적으로 해줘야됨 
		try {
			/*
				read() 메서드를 사용할 경우 '1'이라는 숫자를 읽어들일때 int형 숫자 1을 읽어오는게 아닌 
				ASCII 형식 표에 의해서 문자 '1'에 해당하는 숫자 49값을 읽어온다. 
				int n = br.read() - 48;
				int x = br.read() - 48;
			*/
			
			// <Enter 단위로 입력된 데이터를 받는 경우>  
			//int n1 = Integer.parseInt(br.readLine());
			//int x1 = Integer.parseInt(br.readLine());
			
			// <space(공백)단위로 구분을 하는 경우>  
			
			// 1.StringTokenizer 사용해서 구분하는 방법 
			
			// 생성자의 첫번째 파라미터(문자열) , 두번째 파리미터(구분자-Delimiter)
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			// nextToken() 메서드의 리턴값은 String 이므로 형변환을 해줌 
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			// 수열 A를 이루는 정수N개 
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			int[] a = new int[n];
			
			for(int i=0;i<n;i++) {
				a[i] = Integer.parseInt(st1.nextToken());
			}
			
			// x보다 작은수를 출력 
			for(int i=0;i<n;i++) {
				if(x > a[i]) System.out.print(a[i]+" ");
			}
			
			// 2.split() 메서드를 이용한 구분방법 
			// split() 메서드는 구분자를 기준으로 배열에 저장시킴 (return 값이 String 배열 형태) 
			/*
				String[] a = br.readLine().split(" ");		
				int n = Integer.parseInt(a[0]);
				int x = Integer.parseInt(a[1]);
			*/
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
