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
		/** �쿴Ŀ¼��Ϣ */
		public static void listDir(File dir){
			File[] lists=dir.listFiles();
			// ��ӡ��ǰĿ¼�°�����������Ŀ¼���ļ������� 
			String info="Ŀ¼:"+dir.getName()+"(";
			for(int i=0;i<lists.length;i++)
				info+=lists[i].getName()+" ";info+=")";
			System.out.println(info); 
			//********��ӡ��ǰĿ¼�°�����������Ŀ¼���ļ�����ϸ��Ϣ*****
			for(int i=0;i<lists.length;i++){
				File f=lists[i];
				if(f.isFile())
					System.out.println("�ļ�:"+f.getName()
                  	 +" canRead:"+f.canRead()
                   	+" lastModified:"+new Date(f.lastModified()));
				else  // ���ΪĿ¼���͵ݹ����listDir()����
					listDir(f);  
			}
		}
		/** ɾ��Ŀ¼���ļ����������file����Ŀ¼����ɾ����ǰĿ¼�Լ�Ŀ¼�µ���������****/
		public static void deleteDir(File file){
			// ���file�����ļ�����ɾ�����ļ�
			if(file.isFile()){
				file.delete();
				return;
			}
			// ���file����Ŀ¼����ɾ��Ŀ¼�µ�������Ŀ¼���ļ�
			File[] lists=file.listFiles();
			for(int i=0;i<lists.length;i++)
				deleteDir(lists[i]);  // �ݹ�ɾ����ǰĿ¼�µ�������Ŀ¼���ļ�
			// ���ɾ����ǰĿ¼    
			file.delete();
		}
	}
