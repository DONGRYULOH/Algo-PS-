package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 	����) 
 	���� N���� �̷���� ����A�� ����X�� �־����µ� A���� X���� �������� ����ϱ� 
 	
 	�Է�����) - (1�̻� 10,000 ���� ������ �Է��Ѵٴ� ����) 
 	ù�� - N,X 
 	��°�� - ���� A�� �̷�� ����N�� 
 */
public class BOJ_10871 {

	public static void main(String[] args) {
		
		// ���1)
		/*
			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] a = new int[n]; 
			
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			
			// x���� �������� ��� 
			for(int i=0;i<n;i++) {
				if(x > a[i]) System.out.print(a[i]+" ");
		}
		*/
		
		// ���2) 
		/*
		 	�Է¹��� ������ ���� ������ �ϳ��� �Է¹ް� ó���ϴ� �ͺ��� �������� �Է¹��� ����
		 	���ۿ� �׾Ƴ��� �Ѳ����� ó���ϴ°� �ӵ��鿡�� ������ 
		 	Scanner Vs BufferedReader �ӵ����� ���� 
		 	: https://sjs2215.tistory.com/93
		 */
		
		// enter�� ���� �ν�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// IO ����� ���� ���� IOException�� �߻��� �� �ֱ� ������ ����ó���� ���������� ����ߵ� 
		try {
			/*
				read() �޼��带 ����� ��� '1'�̶�� ���ڸ� �о���϶� int�� ���� 1�� �о���°� �ƴ� 
				ASCII ���� ǥ�� ���ؼ� ���� '1'�� �ش��ϴ� ���� 49���� �о�´�. 
				int n = br.read() - 48;
				int x = br.read() - 48;
			*/
			
			// <Enter ������ �Էµ� �����͸� �޴� ���>  
			//int n1 = Integer.parseInt(br.readLine());
			//int x1 = Integer.parseInt(br.readLine());
			
			// <space(����)������ ������ �ϴ� ���>  
			
			// 1.StringTokenizer ����ؼ� �����ϴ� ��� 
			
			// �������� ù��° �Ķ����(���ڿ�) , �ι�° �ĸ�����(������-Delimiter)
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			// nextToken() �޼����� ���ϰ��� String �̹Ƿ� ����ȯ�� ���� 
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			// ���� A�� �̷�� ����N�� 
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			int[] a = new int[n];
			
			for(int i=0;i<n;i++) {
				a[i] = Integer.parseInt(st1.nextToken());
			}
			
			// x���� �������� ��� 
			for(int i=0;i<n;i++) {
				if(x > a[i]) System.out.print(a[i]+" ");
			}
			
			// 2.split() �޼��带 �̿��� ���й�� 
			// split() �޼���� �����ڸ� �������� �迭�� �����Ŵ (return ���� String �迭 ����) 
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
