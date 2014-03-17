package huawei;

/**
 * ͨ����������һ��Сд��ĸ(a~z)��ɵ��ַ�����<br>
 * ���дһ���ַ���ѹ�����򣬽��ַ�����������ϯ���ظ���ĸ����ѹ����<br>
 * �����ѹ������ַ�����ѹ������<br>
 * 1����ѹ�������ظ����ֵ��ַ��������ַ���"abcbc"�����������ظ��ַ���ѹ������ַ�������"abcbc"��<br>
 * 2��ѹ���ֶεĸ�ʽΪ"�ַ��ظ��Ĵ���+�ַ�"�����磺�ַ���"xxxyyyyyyz"ѹ����ͳ�Ϊ"3x6yz"��
 * @company ��Ϊ
 * @author xiehai
 * @date 2014-2-13 ����02:21:00 
 */
public class StringCompression {
    /** 
     * �ַ���ѹ������
     * @param str
     * @return ����ָ��ѹ����ʽ���ַ���
     */
    public String stringCompression(String str){
	char []data = str.toCharArray();
	int count = 1;
	if(1 == str.length()){
	    return str;
	}
	StringBuilder sb = new StringBuilder();
	for(int i = 1; i < data.length; ++i){//�ӵڶ����ַ���ʼ�Ƚ�
	    if(data[i] == data[i-1]){
		count ++;
	    }else{
		if(1 != count){//���������1,��ʡ��
		    sb.append(count);
		}
		sb.append(data[i-1]);
		count = 1;
	    }
	    
	    if(i == data.length-1){//�ж����һ���ַ��͵����ڶ����ַ��Ƿ���ͬ
		if(data[i] == data[i-1]){
		    sb.append(count);
		    sb.append(data[i-1]);//��ͬ,ֱ���ۼ�
		}else{
		    sb.append(data[i]);//����,������һ���ַ������ؽ��,ѭ�����������ô�
		}
	    }
	}
	
	return sb.toString();
    }
    
    public static void main(String[] args) {
	StringCompression sc = new StringCompression();
	String e = "a";
	String f = "aa";
	String a = "abcbc";
	String b = "abcbcc";
	String c = "xxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyz";
	System.out.println(sc.stringCompression(a));
	System.out.println(sc.stringCompression(b));
	System.out.println(sc.stringCompression(c));
	System.out.println(sc.stringCompression(e));
	System.out.println(sc.stringCompression(f));
    }
}
