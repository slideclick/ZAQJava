package org.concurrency.communication;
class Share{	
	private int[] data = new int[10];
  	private int pos =0;					// ָ���һ�����пռ䣬���ڷ���ֵ
  	//**********�ٽ�������������з���ֵ*************
  	public synchronized void put(int v){
  		while( pos >9 ){					// �ռ�����
  			try{
  				
  				System.out.println(Thread.currentThread().getName()+":Producer wait");
  				this.wait();				// ��������״̬���ȴ��������߳�ȡֵ����
			} catch(InterruptedException e){ }
		}
		data[pos++]=v; 						// ����ֵ
		this.notifyAll();						// �������ǣ������λ��Ѹ��ٽ��������Ͽ����е�
										// �ȴ�ȡֵ���������̣߳���֮����ֵ�ɹ�ȡ��
	}
//**********�ٽ������ӹ��������ȡֵ*************
	public synchronized int get(){				
		int value; 
 		while( pos<=0 ){					// �ռ�ȫ�գ���ֵ��ȡ
 			try{
 				System.out.println(Thread.currentThread().getName()+":Consumer wait");
				this.wait();					// ��������״̬���ȴ��������̷߳���ֵ����
				
			} catch(InterruptedException e){ 
				e.printStackTrace();
			}
		}
		value = data[--pos]; 					// ȡֵ
		this.notifyAll();						// �������ǣ������λ��Ѹ��ٽ��������Ͽ����е�
										// �ȴ����ÿռ���������̣߳���֮���п��пռ�
  		return value;
		}
}
class Producer extends Thread{ 				// �������߳�
	private Share s1;	
  	public Producer(Share s3)
		{ 	s1 = s3;	}
		public void run(){	
			for (int i = 0;i<100;i++ ){
     			s1.put(i);
         		System.out.println("������: "+i); 
			}
		}
}
class Consumer extends Thread{ 		// �������߳�
		private Share s2;
  		public Consumer(Share s4){
				s2 = s4;
			}
			public void run(){
				int v=0;
   	 	 for (int i = 0;i<100;i++ ){
     		v = s2.get();
       		 System.out.println("������: "+v); 
			}
		}
	}
public class Test{
		public static void main(String[] args){
			Share share = new Share(); 			// ����һ�����й�������Ķ���
    		Producer p = new Producer(share) ; 	// ����һ���������߳�
   	 	Consumer c = new Consumer(share);	// ����һ���������߳�
    		p.start();
    		c.start();
		}
}
