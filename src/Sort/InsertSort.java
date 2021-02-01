package Sort;

// ��������
/*
 	�ι�° �ε������� �����ؼ� ������ �ε������� �ش� �ε����� ������ �������� 
 	ù��° �ε������� ���ϸ鼭 ������ �� ��Ҹ� ã�� 
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] array = {0, 3, 9, 5, 7};
		int count = 0; // �����ϱ� ���� �����͸� ���� Ƚ��
		
		// �������� 
		for(int i=1;i<array.length;i++) {
			// ������ �� �ε����� 5��° �ε������ 4��° �ε������� ���ʴ�� ���� 
			for(int j=i;j>0;j--) {
				count++;
				// �� ĭ�� �������� �̵� 
				if(array[j] < array[j-1]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
				// �ڽź��� ���� �����͸� ������ �� ��ġ���� ���� 
				else break;
			}
		}

		for(int data : array) {
			System.out.print(data+" ");
		}
		System.out.println("������ �� Ƚ��:"+count);
		
		// �������� (�����Ͱ� ū�ͺ��� ����) 
		for(int i=1;i<array.length;i++) {
			// ������ �� �ε����� 5��° �ε������ 4��° �ε������� ���ʴ�� ���� 
			for(int j=i;j>0;j--) {
				// �� ĭ�� �������� �̵� 
				if(array[j] > array[j-1]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
				// �ڽź��� ū �����͸� ������ �� ��ġ���� ���� 
				else break;
			}
		}

		for(int data : array) {
			System.out.print(data+" ");
		}
		
		
	}

}
