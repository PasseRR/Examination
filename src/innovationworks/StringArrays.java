package innovationworks;

import java.util.HashMap;
import java.util.Map;

/**
 * һ���ַ����飬������ַ�������a-z��A-Z��0-9��<br>
 * ����Ҫ��������������Ҫ������Сд�ַ�������ǰ�棬<br>
 * ���д�д�ַ������м䣬�������ַ�����󣬶��Ҹ������ڲ��ֱ�����<br>
 * ��abcABC123
 * @company ���¹���
 * @author xiehai
 * @date 2014-2-10 ����02:21:28 
 */
public class StringArrays {
    /**�ַ��ֵ�*/
    private static Map<Character, Integer> charMap = new HashMap<Character, Integer>();
    
    public StringArrays(){
	this.init();
    }
    
    /** 
     * ������ĿҪ���ʼ���ֵ�,����abcABC012����
     */
    private void init(){
	int i = 1;
	for(char c = 'a'; c <= 'z'; ++c){
	    charMap.put(c, i++);
	}
	for(char c = 'A'; c <= 'Z'; ++c){
	    charMap.put(c, i++);
	}
	for(char c = '0'; c <= '9'; ++c){
	    charMap.put(c, i++);
	}
    }
    
    /**
     * ˳������(ѡ������) 
     * @param str
     * @return
     */
    public String OrderSort(String str){
	char []data = str.toCharArray();
	for(int i = 0; i < data.length; ++i){
	    int k = i;
	    for(int j = i; j < data.length; ++j){
		if(charMap.get(data[k]) > charMap.get(data[j])){
		    k = j;
		}
	    }
	    char temp = data[i];
	    data[i] = data[k];
	    data[k] = temp;
	}

	return new String(data);
    }
    
    /** 
     * ӦΪ�����������,ʹ�ò�������
     * @param str
     * @return
     */
    public String InsertSort(String str){
	char []data = str.toCharArray();
	for(int i = 1; i < data.length; ++i){
	    int j = i-1;
	    char temp = data[i];
	    while(j >= 0
		    && charMap.get(temp) < charMap.get(data[j])){
		data[j+1] = data[j];
		j--;
	    }
	    data[j+1] = temp;
	}
	
	return new String(data);
    }
    
    public static void main(String[] args) {
	StringArrays sa = new StringArrays();
	String str = "18759089WERTWBVCMNBVCFkjhgf760623SHUTOAsuitASFtuYTASStotoDa1234adfdafd";
	System.out.println(sa.OrderSort(str));
	System.out.println(sa.InsertSort(str));
    }
}
