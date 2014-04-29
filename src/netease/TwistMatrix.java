package netease;

/**
 * 矩阵式螺旋输出<BR>
 * 1 8 7<BR>
 * 2 9 6<BR>
 * 3 4 5<BR>
 * 保证矩阵的m,n相同
 * 
 * @company 网易
 * @author xiehai
 * @date 2014-2-20 下午04:36:01
 */
public class TwistMatrix {
	private int[][] matrix;// 矩形数据
	private int n;// 正方形矩形边长
	public TwistMatrix(int n) {
		matrix = new int[n][n];
		this.n = n;
	}

	private void twist() {
		int current = 1;
		int circle = n % 2 == 0 ? n / 2 : n / 2 + 1;
		for (int i = 0; i < circle; ++i) {// 逆时针开始赋值,没条矩阵的边一个循环
			int j;
			int k;
			int l;
			int m;
			// 左右两边取端点,上下两边不取
			for (j = i; j < n - i; ++j) {// 左边
				matrix[j][i] = current++;
				// 边长为奇数时,在第matrix[n/2+1][n/2+1]元素结束
				if (n % 2 == 1 && j == circle - 1 && i == circle - 1) {
					return;
				}
			}
			j -= 1;
			for (k = i + 1; k < n - i - 1; ++k) {// 下边
				matrix[j][k] = current++;
			}
			l = k;
			System.out.println(k);
			for (; l >= i; --l) {// 右边
				matrix[l][k] = current++;
				// 边长为偶数时,在第matrix[n/2][n/2+1]元素结束
				if (n % 2 == 0 && l == circle - 1 && k == circle) {
					return;
				}
			}
			m = k - 1;
			l = i;
			for (; m > i; m--) {// 上边
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
