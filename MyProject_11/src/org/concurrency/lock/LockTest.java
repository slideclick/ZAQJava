package org.concurrency.lock;
import java.util.concurrent.locks.*;
class Share{
	private int a;						// �������
  	public Share(){
		a = 0;	
	}
  	public Share(int  i){
  		a = i;
  	} 
  	private Lock locker =new ReentrantLock();
  	//�ٽ���1���Թ��������1 
  	public void add(){
  		locker.lock();					// ����
		try{	
			a = a+1;					// �����ٽ���1
			System.out.println("Add��"+a);
  		}finally{
  			locker.unlock();				// ����
  		}
	}
  	// �ٽ���2���Թ��������1  
	public void dec(){  
		locker.lock();					// ����
		try{							// �����ٽ���2
			if(a>0){
				a = a-1;  
				System.out.println("Dec��"+a);
			}
		}finally{
			locker.unlock();				// ����
		}
	}
}
// �Թ����������1�������߳�
class AddThread extends Thread{  
	private Share s1;
   	public AddThread(Share s3){
   		s1 = s3;
   	}
	public void run(){
		for(int i=0;i<=10;i++){
			s1.add();
			yield();
		}
	}
}	
// �Թ����������1�������߳�
class DecThread extends Thread{  
	private Share s2;
   	public DecThread(Share s4){
   		s2 = s4;
   	}
   	public void run(){
   		for(int i=0;i<=10;i++){	
   			s2.dec();
   			yield();
		}
	}
}
public class LockTest{	
	public static void main(String[] args){
		Share  share = new Share();
  		new AddThread(share).start();
  		new DecThread(share).start();
	}
}
