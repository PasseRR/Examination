package netease;

/**
 * ����ʽ�������<BR>
 * 1 8 7<BR>
 * 2 9 6<BR>
 * 3 4 5<BR>
 * ��֤�����m,n��ͬ
 * 
 * @company ����
 * @author xiehai
 * @date 2014-2-20 ����04:36:01
 */
public class TwistMatrix {
	private int[][] matrix;// ��������
	private int n;// �����ξ��α߳�
	public TwistMatrix(int n) {
		matrix = new int[n][n];
		this.n = n;
	}

	private void twist() {
		int current = 1;
		int circle = n % 2 == 0 ? n / 2 : n / 2 + 1;
		for (int i = 0; i < circle; ++i) {// ��ʱ�뿪ʼ��ֵ,û������ı�һ��ѭ��
			int j;
			int k;
			int l;
			int m;
			// ��������ȡ�˵�,�������߲�ȡ
			for (j = i; j < n - i; ++j) {// ���
				matrix[j][i] = current++;
				// �߳�Ϊ����ʱ,�ڵ�matrix[n/2+1][n/2+1]Ԫ�ؽ���
				if (n % 2 == 1 && j == circle - 1 && i == circle - 1) {
					return;
				}
			}
			j -= 1;
			for (k = i + 1; k < n - i - 1; ++k) {// �±�
				matrix[j][k] = current++;
			}
			l = k;
			System.out.println(k);
			for (; l >= i; --l) {// �ұ�
				matrix[l][k] = current++;
				// �߳�Ϊż��ʱ,�ڵ�matrix[n/2][n/2+1]Ԫ�ؽ���
				if (n % 2 == 0 && l == circle - 1 && k == circle) {
					return;
				}
			}
			m = k - 1;
			l = i;
			for (; m > i; m--) {// �ϱ�
				matrix[l][m] = current++;
			}
		}
	}

	public void display() {
		twist();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new TwistMatrix(10).display();
	}
}
