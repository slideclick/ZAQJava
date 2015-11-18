public class StatisticWords {
		public static void main(String[] args) {
			String s = "I am a student I am studying hard";
			byte[] c =s.getBytes();						// 把字符串转换为字节数组
			int word=0;							// 判断是否是单词的标识
			int num=0;								// 统计单词的个数
			int i = c.length;
			for (int j=0;j<i;j++){
				if(c[j]==32){						// 是空格
					word =0;
				}else if(word==0){
					word =1;						// 开始出现单词
					num++;					
				}
			}
			System.out.println("单词的总数是："+num);
		}
	}

