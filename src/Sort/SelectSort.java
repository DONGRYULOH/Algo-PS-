package Sort;

// ���� ���� 
/*
 	���� ���� ���� �����ؼ� ������ ������ ������ �ݺ� (�������� ����) 
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] array = {0, 3, 9, 5, 7};
		int count = 0; // �����ϱ� ���� �����͸� ���� Ƚ�� 
		
		// �������� �������� ���� 
		int min_index = 0;
		for(int i=0;i<array.length-1;i++) {
			min_index = i;
			for(int j=i+1;j<array.length;j++) {
				count++;
				if(array[min_index] > array[j]) {
					min_index = j;
				}
			}
			// min_index �� ���ĵ��� ���� �������� ��ġ�� �ٲ���(������ ��� ���)
			int temp = array[i];
			array[i] = array[min_index];
			array[min_index] = temp;
		}

		// ���ĵ� ������ ��� (������ for�� ���)
		for(int data : array) {
			System.out.print(data+" ");
		}
		System.out.println("������ �� Ƚ��:"+count); // 10�� ���� 
	}

}
