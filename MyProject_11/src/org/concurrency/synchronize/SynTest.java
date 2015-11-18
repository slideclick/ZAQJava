package org.concurrency.synchronize;
class Share{	
		private int a;						// 共享变量
  	public Share(){
  		a = 0;
  	}
  	public Share(int  i){
  		a = i;
  	} 
 	//临界区1，对共享变量加1 
  	public void add(){
  		synchronized(this){
				a = a +1;
				System.out.println("Add："+a);
  		}
	}
  	//临界区2，对共享变量减1  
		public void dec(){
			synchronized(this){
				if(a>0){
					a = a - 1;  
					System.out.println("Dec："+a);
				}
			}
		}
}
//对共享变量做加1操作的线程
class AddThread extends Thread{
		private Share s1;
   		public AddThread(Share s3){
   			s1 = s3;
   		}
   		public void run(){
   			for(int i=0;i<=100;i++){
   				s1.add();
        		yield();
			}
		}
}
//对共享变量做减1操作的线程
class DecThread extends Thread{
		private Share s2;
   	public DecThread(Share s4){
   		s2 = s4;
   	}
   	public void run(){
   		for(int i=0;i<=100;i++){
   			s2.dec();
        		yield();
			}
		}
}
public class SynTest{
		public static void main(String[] args){
			Share share = new Share();
  		new AddThread(share).start();
  		new DecThread(share).start();
  		new DecThread(share).start();
		}	
}

