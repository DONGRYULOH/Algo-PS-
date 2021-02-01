package Sort;

// 선택 정렬 
/*
 	가장 작은 것을 선택해서 앞으로 보내는 과정을 반복 (오름차순 기준) 
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] array = {0, 3, 9, 5, 7};
		int count = 0; // 정렬하기 위해 데이터를 비교한 횟수 
		
		// 오름차순 선택정렬 수행 
		int min_index = 0;
		for(int i=0;i<array.length-1;i++) {
			min_index = i;
			for(int j=i+1;j<array.length;j++) {
				count++;
				if(array[min_index] > array[j]) {
					min_index = j;
				}
			}
			// min_index 와 정렬되지 않은 데이터의 위치를 바꿔줌(스와프 기법 사용)
			int temp = array[i];
			array[i] = array[min_index];
			array[min_index] = temp;
		}

		// 정렬된 데이터 출력 (개선된 for문 사용)
		for(int data : array) {
			System.out.print(data+" ");
		}
		System.out.println("데이터 비교 횟수:"+count); // 10번 수행 
	}

}
