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
// ������ - �̷� Ż�� 
public class Main {
	
	// N,M (��,��) 
	static int n,m;
	// �̷� ���� ( ����ĭ -> 0 , ��������ĭ -> 1) 
	static int[][] mazeInfo;
	// �̵� ������ ���� �˻� ���� (�� -> �� -> �� -> ��) 
	static int[] X = {0,1,0,-1};
	static int[] Y = {1,0,-1,0};
	
	// �ִܰŸ��� �̷� Ż���ϱ� 
	public static int bfs(int startX,int startY) {
		
		Queue<Nodes> q = new LinkedList<>();
		q.offer(new Nodes(startX,startY)); // ť�� ���� ��ǥ �ֱ� 
		
		while(!q.isEmpty()) {
			Nodes node = q.poll(); // ť���� �����͸� ����
			startX = node.getX();
			startY = node.getY();
			// �ش� ��ġ���� �ִܰŸ��� ���� ���� �˻� (4���� ������ �ִܰŸ��� ���� ����)  
			for(int i=0;i<4;i++) {
				int x1 = startX + X[i];
				int y1 = startY + Y[i];
				// �̷��� ũ�⿡�� ������� �˻� 
				if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
				// ����ĭ�� ��� 
				if(mazeInfo[x1][y1] == 0) continue;
				// ó�� �湮�ϴ� ĭ�ϰ�� �ִ� �Ÿ� ����ϰ� for���� ��������
				if(mazeInfo[x1][y1] == 1) {
					mazeInfo[x1][y1] = mazeInfo[startX][startY] + 1;
					q.offer(new Nodes(x1,y1)); // ť�� �̵��� ��ǥ �ֱ�  
					break; // ù��° ������ġ�� �ٽ� �湮�� ���ɼ��� �ֱ⶧���� break �������� ����������
				}
			}
		}
		
		for(int i=0;i<n;i++) { 
			for(int j=0;j<m;j++) {
				System.out.print(mazeInfo[i][j]);
			}
			System.out.println();
		}
		
		// �ⱸ������ �ִ� �Ÿ� ��ȯ 
		return mazeInfo[n-1][m-1];
	}
	
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			// readLine()�� ��� Enter�� �ԷµǱ� ������ ���ڿ��� �Է¹��� 
			String[] nums = br.readLine().split(" "); // �Է¹��� ���ڵ��� ��������� �����ؼ� ���ڿ� �迭�� �־��� 
			n = Integer.parseInt(nums[0]);
	        m = Integer.parseInt(nums[1]);
			mazeInfo = new int[n][m];
			
			// �̷� ���� �Է� 
			for(int i=0;i<n;i++) {
				String[] temp = br.readLine().split(""); // ������� �پ �Է��� 
				for(int j=0;j<m;j++) {
					mazeInfo[i][j] = Integer.parseInt(temp[j]);
				}
			}

			// �ִܰŸ��� �̷�Ż���ϴ� �޼��� ȣ��
			System.out.println(bfs(0,0));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}