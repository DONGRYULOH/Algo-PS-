package Sort;

// 삽입정렬
/*
 	두번째 인덱스부터 시작해서 마지막 인덱스까지 해당 인덱스를 왼쪽을 기준으로 
 	첫번째 인덱스까지 비교하면서 삽입이 될 장소를 찾음 
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] array = {0, 3, 9, 5, 7};
		int count = 0; // 정렬하기 위해 데이터를 비교한 횟수
		
		// 오름차순 
		for(int i=1;i<array.length;i++) {
			// 삽입이 될 인덱스가 5번째 인덱스라면 4번째 인덱스부터 차례대로 비교함 
			for(int j=i;j>0;j--) {
				count++;
				// 한 칸씩 왼쪽으로 이동 
				if(array[j] < array[j-1]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
				// 자신보다 작은 데이터를 만나면 그 위치에서 멈춤 
				else break;
			}
		}

		for(int data : array) {
			System.out.print(data+" ");
		}
		System.out.println("데이터 비교 횟수:"+count);
		
		// 내림차순 (데이터가 큰것부터 정렬) 
		for(int i=1;i<array.length;i++) {
			// 삽입이 될 인덱스가 5번째 인덱스라면 4번째 인덱스부터 차례대로 비교함 
			for(int j=i;j>0;j--) {
				// 한 칸씩 왼쪽으로 이동 
				if(array[j] > array[j-1]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
				// 자신보다 큰 데이터를 만나면 그 위치에서 멈춤 
				else break;
			}
		}

		for(int data : array) {
			System.out.print(data+" ");
		}
		
		
	}

}
