package org.concurrency.communication;
class Share{	
	private int[] data = new int[10];
  	private int pos =0;					// 指向第一个空闲空间，用于放入值
  	//**********临界区：向共享变量中放入值*************
  	public synchronized void put(int v){
  		while( pos >9 ){					// 空间已满
  			try{
  				
  				System.out.println(Thread.currentThread().getName()+":Producer wait");
  				this.wait();				// 进入阻塞状态，等待消费者线程取值后唤醒
			} catch(InterruptedException e){ }
		}
		data[pos++]=v; 						// 放入值
		this.notifyAll();						// 不能忘记：有责任唤醒该临界区对象上可能有的
										// 等待取值的消费者线程，告之已有值可供取走
	}
//**********临界区：从共享变量中取值*************
	public synchronized int get(){				
		int value; 
 		while( pos<=0 ){					// 空间全空，无值可取
 			try{
 				System.out.println(Thread.currentThread().getName()+":Consumer wait");
				this.wait();					// 进入阻塞状态，等待生产者线程放入值后唤醒
				
			} catch(InterruptedException e){ 
				e.printStackTrace();
			}
		}
		value = data[--pos]; 					// 取值
		this.notifyAll();						// 不能忘记：有责任唤醒该临界区对象上可能有的
										// 等待可用空间的生产者线程，告之已有空闲空间
  		return value;
		}
}
class Producer extends Thread{ 				// 生产者线程
	private Share s1;	
  	public Producer(Share s3)
		{ 	s1 = s3;	}
		public void run(){	
			for (int i = 0;i<100;i++ ){
     			s1.put(i);
         		System.out.println("生产者: "+i); 
			}
		}
}
class Consumer extends Thread{ 		// 消费者线程
		private Share s2;
  		public Consumer(Share s4){
				s2 = s4;
			}
			public void run(){
				int v=0;
   	 	 for (int i = 0;i<100;i++ ){
     		v = s2.get();
       		 System.out.println("消费者: "+v); 
			}
		}
	}
public class Test{
		public static void main(String[] args){
			Share share = new Share(); 			// 产生一个含有共享变量的对象
    		Producer p = new Producer(share) ; 	// 产生一个生产者线程
   	 	Consumer c = new Consumer(share);	// 产生一个消费者线程
    		p.start();
    		c.start();
		}
}
