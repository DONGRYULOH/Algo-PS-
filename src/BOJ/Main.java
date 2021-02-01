package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Nodes{

    private int x;
    private int y;

    public Nodes(int x, int y) {
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
// 이코테 - 미로 탈출 
public class Main {
	
	// N,M (행,열) 
	static int n,m;
	// 미로 정보 ( 괴물칸 -> 0 , 괴물없는칸 -> 1) 
	static int[][] mazeInfo;
	// 이동 가능한 방향 검사 순서 (우 -> 하 -> 좌 -> 상) 
	static int[] X = {0,1,0,-1};
	static int[] Y = {1,0,-1,0};
	
	// 최단거리로 미로 탈출하기 
	public static int bfs(int startX,int startY) {
		
		Queue<Nodes> q = new LinkedList<>();
		q.offer(new Nodes(startX,startY)); // 큐에 시작 좌표 넣기 
		
		while(!q.isEmpty()) {
			Nodes node = q.poll(); // 큐에서 데이터를 꺼냄
			startX = node.getX();
			startY = node.getY();
			// 해당 위치에서 최단거리로 가는 방향 검사 (4가지 방향중 최단거리로 가는 방향)  
			for(int i=0;i<4;i++) {
				int x1 = startX + X[i];
				int y1 = startY + Y[i];
				// 미로의 크기에서 벗어나는지 검사 
				if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
				// 괴물칸인 경우 
				if(mazeInfo[x1][y1] == 0) continue;
				// 처음 방문하는 칸일경우 최단 거리 기록하고 for문을 빠져나감
				if(mazeInfo[x1][y1] == 1) {
					mazeInfo[x1][y1] = mazeInfo[startX][startY] + 1;
					q.offer(new Nodes(x1,y1)); // 큐에 이동한 좌표 넣기  
					break; // 첫번째 시작위치가 다시 방문될 가능성이 있기때문에 break 구문으로 빠져나가줌
				}
			}
		}
		
		for(int i=0;i<n;i++) { 
			for(int j=0;j<m;j++) {
				System.out.print(mazeInfo[i][j]);
			}
			System.out.println();
		}
		
		// 출구까지의 최단 거리 반환 
		return mazeInfo[n-1][m-1];
	}
	
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			// readLine()의 경우 Enter가 입력되기 전까지 문자열을 입력받음 
			String[] nums = br.readLine().split(" "); // 입력받은 문자들을 공백단위로 구분해서 문자열 배열에 넣어줌 
			n = Integer.parseInt(nums[0]);
	        m = Integer.parseInt(nums[1]);
			mazeInfo = new int[n][m];
			
			// 미로 정보 입력 
			for(int i=0;i<n;i++) {
				String[] temp = br.readLine().split(""); // 공백없이 붙어서 입력함 
				for(int j=0;j<m;j++) {
					mazeInfo[i][j] = Integer.parseInt(temp[j]);
				}
			}

			// 최단거리로 미로탈출하는 메서드 호출
			System.out.println(bfs(0,0));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}