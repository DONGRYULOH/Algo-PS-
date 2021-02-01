package Sort;

// 퀵 정렬 
/*
 	전체길이 n에 대해서 피벗을 기준으로 계속해서 n을 절반으로 나누어서 파티션별 퀵정렬 수행을 반복 
 	피벗을 설정하는 방식이 여러가지인데 각 리스트(파티션)에서 첫번째 데이터를 피벗으로 정한후 정렬을 하는 
 	호어 분할 방식을 이용해서 퀵정렬을 수행하겠다. (중간 데이터를 피벗으로 설정해서 정렬하는 방식도 있음)
 	
 	1.리스트(각 파티션별)에서 첫번째 데이터를 피벗으로 정함  
 	2.왼쪽(L)에서부터 피벗보다 큰데이터를 선택 파티션의 맨 오른쪽(R)에서 부터 피벗보다 작은 데이터를 선택후 위치를 바꿔줌  
 	3.왼쪽에서 부터 이동한 L의 위치가 맨 오른쪽에서 부터 이동한 R의 위치보다 클경우에는 
 	   피벗보다 작은데이터를 선택하는 R의 위치에 있는 값과 피벗 값의 위치를 서로 변경한다.
 	4.피벗이 이동한 상태를 보면 피벗의 왼쪽에는 피벗보다 작은데이터가 존재하고 피벗의 오른쪽에는 피벗보다 큰데이터가 존재하는 것을 알수 있음 
 	5.이렇게 피벗을 기준으로 분할된 파티션들을 1~4번의 과정을 수행해준다.
 	6.퀵정렬이 끝나는 조건(각 파티션별의 데이터의 개수가 1개인 경우 분할이 불가능)을 만족하면 해당 파티션 내에서의 퀵정렬은 종료된다. 
 	  
 	용어)
 	피벗 : 큰 숫자와 작은 숫자를 교환할때, 교환하기 위한 기준을 뜻함 
 */
public class QuickSort {

	public static void quickSort(int[] array,int start,int end) {
		if(start >= end) return; // 데이터가 1개인 경우 종료 (start == end 이렇게 써도 되지 않나??)
		int pivot = start; // 해당 리스트에서 첫번째 원소가 피벗이 됨 
		int left = pivot + 1; // 피벗보다 큰데이터를 찾아갈 변수(피벗위치 +1 왼쪽에서 시작) 
		int right = end; // 피벗보다 작은데이터를 찾아갈 변수(맨 오른쪽에서 시작)
		
		// L값이 R값보다 클경우 반복문 탈출 
		while(left <= right) {
			// 피벗보다 큰데이터를 찾을 때까지 왼쪽에서부터 반복 
			// ( 왼쪽부터 이동한 데이터가 피벗보다 작은 데이터라면 큰 데이터가 나올때까지 다음 인덱스를 검사함)
			while(left <= end && array[left] <= array[pivot]) left++;
			// 피벗보다 작은 데이터를 찾을 때까지 반복 
			while(right > pivot && array[right] >= array[pivot]) right--;
			// 엇갈릴 경우 작은 데이터(right)와 피벗을 교체 
			if (left > right) {
                int temp = array[pivot];
                array[pivot] = array[right];
                array[right] = temp;
            }
            else { // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        quickSort(array, start, right - 1);
        quickSort(array, right + 1, end);
			
	}		
	
	public static void main(String[] args) {
		
		int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8}; 
		
		
	}

}
