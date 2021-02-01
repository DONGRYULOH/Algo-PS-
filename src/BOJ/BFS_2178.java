package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 미로탐색 
public class BFS_2178 {

	// 행,열 
	static int N;
	static int M;
	// 미로 맵 정보 
	static int[][] mazeInfo; 
	// 이동 방향 순서(하,우,좌,상) 
	// 이동 방향 순서가 (좌 -> 상) 또는 (상 -> 좌) 부터 시작하게 되면 첫번째 위치를 다시 방문하게 되므로 하 또는 우 부터 시작해야됨
	static int X[] = {1,0,0,-1};
	static int Y[] = {0,1,-1,0};
	
	// (N,M) 위치에 도착했을 경우에만 큐에 데이터가 비어있게됨
	public static int bfs(int x,int y) {
		
		// 큐에 시작 위치를 넣어줌 
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y)); // Node 타입만 들어갈수 있음 
		
		// 출구까지 이동하면서 시작점으로부터 거리값을 계속 구해나감 
		while(!q.isEmpty()) {
			
			// <X와 Y 좌표를 구하는 방법1 ( 문자값을 아스키 코드표를 이용한 연산 -> 좌표가 커질수록 가져오는게 힘듬)>   
			// <추가 사항> 
			// 문자열.charAt(0) -> 문자열에서 인덱스 0번째에 해당하는 문자 리턴 
			// (문자 '12'를 가져올때 v.charAt(0)에서 인덱스 0번째에 있는 문자 하나인 1만가져오는 문제가 발생)
			// x = v.charAt(0) - '0'; // 메서드에 파라미터로 있는 변수 x에 저장 
			// y = v.charAt(1) - '0'; // 메서드에 파라미터로 있는 변수 y에 저장 
			
			// X와 Y 좌표를 구하는 다른 방법 2 (노드라는 클래스를 만든다음 X와 Y값을 따로 받아서 각각 호출할수 있는 메서드를 만듬) 
			Node node = q.poll(); // 큐에서 데이터를 꺼냄
			x = node.getX();
			y = node.getY();
			
			// 최단거리로 가는 방향 조사 
			int x1=0,y1=0;
			for(int i=0;i<4;i++) {
				x1 = x + X[i];
				y1 = y + Y[i];
				// 미로 공간을 벗어나는지 검사 
				if(x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) continue;
				// 이동할수 없는 칸(0) 경우 
				if(mazeInfo[x1][y1] == 0) continue;
				// 이동가능한 좌표(1)에 전의이동 좌표의 최단거리 값(3)을 더해줌 -> 4 
				if(mazeInfo[x1][y1] == 1){
					mazeInfo[x1][y1] = mazeInfo[x][y] + 1;
					q.offer(new Node(x1,y1));
				}			
			}
		}
		
		// 마지막 좌표 칸의 거리값 반환 
		return mazeInfo[N-1][M-1];
	}
	 
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			// N = br.read();
			// M = br.read();
			String[] num = br.readLine().split(" ");
			// N = num[0].charAt(0); -> 4 라는 문자가 있으면 아스키 코드표에 의해서 52라는 수로 변환이되서 N에 저장됨 
			N = Integer.parseInt(num[0]); // 이런식으로 문자 '4' 자체를 4 라는 정수형으로 변환을 해야됨 
			M = Integer.parseInt(num[1]);
			mazeInfo = new int[N][M];
			
			// 미로 정보 입력 
			for(int i=0;i<N;i++) {
				String[] num1 = br.readLine().split("");
				for(int j=0;j<M;j++) {
					mazeInfo[i][j] = Integer.parseInt(num1[j]);
				}
			}
			
			// 최단거리 미로탈출 (초기 좌표(0,0)에서 출구까지 이동한 최단거리 구하기)
			System.out.println(bfs(0,0));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

// X와 Y좌표를 각각 가져올수 있는 클래스를 만듬 
class Node{

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}

