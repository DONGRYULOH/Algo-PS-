package BOJ;

import java.util.Scanner;

public class BOJ_8393 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // n�� ����(1<=n<=10,000) 
		
		if(1<=n && n<= 10000) {
			int sum = 0; // 1���� n������ ��
			
			for(int i=1;i<=n;i++) {
				sum += i;
			}
					
			System.out.println(sum);
		}
		
	}

}
