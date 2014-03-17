package alibaba;

/**
 * 查找一个n个元素的数组中最大和最小值
 * @company 阿里巴巴
 * @author xiehai
 * @date 2014-2-13 下午03:12:33 
 */
public class MaxAndMin {
    /**数组最大值*/
    private int max = Integer.MIN_VALUE;
    /**数组最小值*/
    private int min = Integer.MAX_VALUE;
    
    /** 
     * 比较2n次,获得最大最小值<br>
     * 因为如果是比max大就不会和min比较,所以不到2n次
     * @param arrays
     */
    public void getMaxAndMinMethod1(int []arrays){
	for(int i = 0; i < arrays.length; ++i){
	    int item = arrays[i];
	    if(max < item){
		max = item;
	    }else if(min > item){
		min = item;
	    }
	}
    }
    
    /** 
     * 先将数组两两分组,小的左边,大的右边<br>
     * 在遍历数组,奇数索引和max比较,偶数索引和min比较<br>
     * 缺点:会破坏原数组
     * @param arrays
     */
    public void getMaxAndMinMethod2(int []arrays){
	int len = arrays.length;
	boolean flg = 0 == len%2 ? false : true;//数组元素是否为为奇数个
	for(int i = 0; i < len; i += 2){//两两分组,此处比较n/2次
	    if(flg && i+2 > len){//如果元素是奇数个,则单最后一个元素,否则继续交换会数组越界
		break;
	    }
	    if(arrays[i] > arrays[i+1]){
		int temp = arrays[i];
		arrays[i] = arrays[i+1];
		arrays[i+1] = temp;
	    }
	}
	//左边和min比较,右边和max比较,此处比较n次
	//共比较(3/2)n次
	for(int i = 0; i < len; ++i){
	    int item = arrays[i];
	    if(flg && i == len-1){//如果元素是奇数个,且当前为最后一个元素,和min,max都比较
		if(item < min){
		    min = item;
		}else if(item > max){
		    max = item;
		}
	    }else if(0 == i%2){//左边的小值
		if(item < min){
		    min = item;
		}
	    }else{//右边的大值
		if(item > max){
		    max = item;
		}
	    }
	}
    }
    
    public static void main(String[] args) {
	int []arrays = {111, 111};
	MaxAndMin mam = new MaxAndMin();
	mam.getMaxAndMinMethod1(arrays);
	System.out.println(mam.max + " " + mam.min);
	mam.getMaxAndMinMethod2(arrays);
	System.out.println(mam.max + " " + mam.min);
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
