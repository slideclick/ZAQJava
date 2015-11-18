public class CalculateWord {
		public static void main(String[] args) {
			String data = "ab+12cd*123fdfg%^&()as23BG";
			int count = 0; 								//单词总数
			int llen = 0; 								//最长单词长度
			int slen = Integer.MAX_VALUE; 					//最短单词长度
			int tlen = 0; 								//单词总的长度
			int wlen = 0; 								//当前单词长度
			boolean inword = false; 		// 若为true，表示当前状态在单词内，否则在单词外
			char ch;
			for (int i = 0; i < data.length(); i++) {
				ch = data.charAt(i);
				if (!inword) {							//判断当前是否在单词内
					if (Character.isLetter(ch)) {				//判断当前单词是否是单词
						inword = true;
						count++;
						wlen = 1;
					}
				} else {
					if (Character.isLetter(ch)) {				
						wlen++; 						//当前单词长度为1
					} else {
						inword = false;
						tlen += wlen;			 		//计算新的单词的总长度
						if (llen < wlen)
							llen = wlen;	 			//新的最长的单词长度
						if (slen > wlen)
							slen = wlen;	 			//新的最短的单词长度
					}
				}
			}
			// *********若是在单词内结束的，要将最后一个单词计算在内***********
			if (inword) { 
				tlen += wlen;
				if (llen < wlen)
					llen = wlen;
				if (slen > wlen)
					slen = wlen;
			}
			System.out.println("原串：" + data);
			System.out.println("单词总数：" + count);
			System.out.println("最长长度：" + llen);
			System.out.println("最短长度：" + slen);
			System.out.println("单词总长：" + tlen);
			System.out.println("平均长度：" + (float) tlen / count);
		}
	}

