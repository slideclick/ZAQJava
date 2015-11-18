package org.iostream;
	import java.io.File;
	import java.util.Date;
	public class FileDelete {
		public static void main(String args[])throws Exception{
			File folder1=new File("e:\\folder1");
			if(!folder1.exists())folder1.mkdir();     
			File folder2=new File(folder1,"folder2");
			if(!folder2.exists())folder2.mkdirs(); 
			File folder4=new File(folder1,"folder3\\folder4");
			if(!folder4.exists())folder4.mkdirs(); 
			File file=new File(folder2,"test.txt");
			if(!file.exists())file.createNewFile();
			listDir(folder1);
			deleteDir(folder1); 
		}
		/** 察看目录信息 */
		public static void listDir(File dir){
			File[] lists=dir.listFiles();
			// 打印当前目录下包含的所有子目录和文件的名字 
			String info="目录:"+dir.getName()+"(";
			for(int i=0;i<lists.length;i++)
				info+=lists[i].getName()+" ";info+=")";
			System.out.println(info); 
			//********打印当前目录下包含的所有子目录和文件的详细信息*****
			for(int i=0;i<lists.length;i++){
				File f=lists[i];
				if(f.isFile())
					System.out.println("文件:"+f.getName()
                  	 +" canRead:"+f.canRead()
                   	+" lastModified:"+new Date(f.lastModified()));
				else  // 如果为目录，就递归调用listDir()方法
					listDir(f);  
			}
		}
		/** 删除目录或文件，如果参数file代表目录，会删除当前目录以及目录下的所有内容****/
		public static void deleteDir(File file){
			// 如果file代表文件，就删除该文件
			if(file.isFile()){
				file.delete();
				return;
			}
			// 如果file代表目录，先删除目录下的所有子目录和文件
			File[] lists=file.listFiles();
			for(int i=0;i<lists.length;i++)
				deleteDir(lists[i]);  // 递归删除当前目录下的所有子目录和文件
			// 最后删除当前目录    
			file.delete();
		}
	}
