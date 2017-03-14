package mavenDemo;

import java.util.Date;


public class TestThread implements Runnable {
	
	
	protected static TestThread instance ;
	
	

	public static TestThread getInstance() {
		if(instance == null){
			instance = new TestThread();
			new Thread(instance).start();
		}
		return instance;
	}

	public void run() {
		
		while(true){
			try {
				System.err.println("��ӡ�߳�..."+"״̬��"+Thread.currentThread().getState()+new Date());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
