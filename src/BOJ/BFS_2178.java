package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// �̷�Ž�� 
public class BFS_2178 {

	// ��,�� 
	static int N;
	static int M;
	// �̷� �� ���� 
	static int[][] mazeInfo; 
	// �̵� ���� ����(��,��,��,��) 
	// �̵� ���� ������ (�� -> ��) �Ǵ� (�� -> ��) ���� �����ϰ� �Ǹ� ù��° ��ġ�� �ٽ� �湮�ϰ� �ǹǷ� �� �Ǵ� �� ���� �����ؾߵ�
	static int X[] = {1,0,0,-1};
	static int Y[] = {0,1,-1,0};
	
	// (N,M) ��ġ�� �������� ��쿡�� ť�� �����Ͱ� ����ְԵ�
	public static int bfs(int x,int y) {
		
		// ť�� ���� ��ġ�� �־��� 
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y)); // Node Ÿ�Ը� ���� ���� 
		
		// �ⱸ���� �̵��ϸ鼭 ���������κ��� �Ÿ����� ��� ���س��� 
		while(!q.isEmpty()) {
			
			// <X�� Y ��ǥ�� ���ϴ� ���1 ( ���ڰ��� �ƽ�Ű �ڵ�ǥ�� �̿��� ���� -> ��ǥ�� Ŀ������ �������°� ����)>   
			// <�߰� ����> 
			// ���ڿ�.charAt(0) -> ���ڿ����� �ε��� 0��°�� �ش��ϴ� ���� ���� 
			// (���� '12'�� �����ö� v.charAt(0)���� �ε��� 0��°�� �ִ� ���� �ϳ��� 1���������� ������ �߻�)
			// x = v.charAt(0) - '0'; // �޼��忡 �Ķ���ͷ� �ִ� ���� x�� ���� 
			// y = v.charAt(1) - '0'; // �޼��忡 �Ķ���ͷ� �ִ� ���� y�� ���� 
			
			// X�� Y ��ǥ�� ���ϴ� �ٸ� ��� 2 (����� Ŭ������ ������� X�� Y���� ���� �޾Ƽ� ���� ȣ���Ҽ� �ִ� �޼��带 ����) 
			Node node = q.poll(); // ť���� �����͸� ����
			x = node.getX();
			y = node.getY();
			
			// �ִܰŸ��� ���� ���� ���� 
			int x1=0,y1=0;
			for(int i=0;i<4;i++) {
				x1 = x + X[i];
				y1 = y + Y[i];
				// �̷� ������ ������� �˻� 
				if(x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) continue;
				// �̵��Ҽ� ���� ĭ(0) ��� 
				if(mazeInfo[x1][y1] == 0) continue;
				// �̵������� ��ǥ(1)�� �����̵� ��ǥ�� �ִܰŸ� ��(3)�� ������ -> 4 
				if(mazeInfo[x1][y1] == 1){
					mazeInfo[x1][y1] = mazeInfo[x][y] + 1;
					q.offer(new Node(x1,y1));
				}			
			}
		}
		
		// ������ ��ǥ ĭ�� �Ÿ��� ��ȯ 
		return mazeInfo[N-1][M-1];
	}
	 
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			// N = br.read();
			// M = br.read();
			String[] num = br.readLine().split(" ");
			// N = num[0].charAt(0); -> 4 ��� ���ڰ� ������ �ƽ�Ű �ڵ�ǥ�� ���ؼ� 52��� ���� ��ȯ�̵Ǽ� N�� ����� 
			N = Integer.parseInt(num[0]); // �̷������� ���� '4' ��ü�� 4 ��� ���������� ��ȯ�� �ؾߵ� 
			M = Integer.parseInt(num[1]);
			mazeInfo = new int[N][M];
			
			// �̷� ���� �Է� 
			for(int i=0;i<N;i++) {
				String[] num1 = br.readLine().split("");
				for(int j=0;j<M;j++) {
					mazeInfo[i][j] = Integer.parseInt(num1[j]);
				}
			}
			
			// �ִܰŸ� �̷�Ż�� (�ʱ� ��ǥ(0,0)���� �ⱸ���� �̵��� �ִܰŸ� ���ϱ�)
			System.out.println(bfs(0,0));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

// X�� Y��ǥ�� ���� �����ü� �ִ� Ŭ������ ���� 
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

