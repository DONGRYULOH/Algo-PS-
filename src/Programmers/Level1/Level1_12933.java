package Programmers.Level1;

// ���� �������� ��ġ�ϱ� 
public class Level1_12933 {

	public static long solution(long n) {
		// longŸ��(����)�� ���ڿ��� ��ȯ (�迭�� ũ�⸦ �����ϱ� ���Ѱ�)
		String r = n + ""; // long Ÿ�Կ� ""(���ڿ�) �����ָ� ���ڿ��� ��ȯ�� ����
		
		int[] array = new int[r.length()];
		int count = 0;
		while(n != 0) {
			// ������(�� �ڸ��� - ��,��,���� �ڸ�) 
			int nmg = (int)n%10;
			// ��(�������� ���ϱ� ���� ����� ������) 
			n = n/10;
			array[count++] = nmg; // �������� 	
		}
		
		// ���������� �̿��� �������� ����
		int temp = 0;
		for(int i=1;i<array.length;i++) {
			for(int j=i;j>0;j--) {
				if(array[j] > array[j-1]) {
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}else {
					break; 
				}
			}
		}
		
		// �����ڸ� ���ڿ��� ���� ������ 
		String result = "";
		for(long v : array) {
			result += v;
		}
		
		
		return Long.parseLong(result);
	}
	
	public static void main(String[] args) {
		System.out.println(solution(118372));
	}

}
