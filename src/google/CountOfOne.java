package google;

/**
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * @company 谷歌
 * @author xiehai
 * @date 2014-2-27 下午04:12:52 
 */
public class CountOfOne {
    public int getCountOfOne(int num){
	int count = 0;
	for(int i = 1; i <= num; ++i){
	    int j = i;
	    while(j > 0){//统计一个数字每位是否是1
		count += (j%10 == 1) ? 1 : 0;//最低位是否是1
		j /= 10;
	    }
	}
	
	return count;
    }
    
    public static void main(String[] args) {
	CountOfOne coo = new CountOfOne();
	System.out.println(coo.getCountOfOne(50));
    }
}
