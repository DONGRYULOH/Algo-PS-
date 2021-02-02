package Programmers.Level1;

// 정수 내림차순 배치하기 
public class Level1_12933 {

	public static long solution(long n) {
		// long타입(정수)을 문자열로 변환 (배열의 크기를 생성하기 위한것)
		String r = n + ""; // long 타입에 ""(빈문자열) 더해주면 문자열로 변환이 가능
		
		int[] array = new int[r.length()];
		int count = 0;
		while(n != 0) {
			// 나머지(각 자릿수 - 십,일,백의 자리) 
			int nmg = (int)n%10;
			// 몫(나머지를 구하기 위한 계산을 진행함) 
			n = n/10;
			array[count++] = nmg; // 후위증가 	
		}
		
		// 삽입정렬을 이용한 내림차순 정렬
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
		
		// 각숫자를 문자열로 연결 시켜줌 
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
