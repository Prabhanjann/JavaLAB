class BMSDisplayThread extends Thread{
	public void run(){
		while(true){
			System.out.println("BMSCE");
			try{
				Thread.sleep(10000);
			}
			catch(InterruptedException e){
				System.out.println(e);
			}
		}
	}
}
class CSEDisplayThread extends Thread{
	public void run(){
		while (true){
			System.out.println("CSE");
			try{
				Thread.sleep(2000);
			}
			catch(InterruptedException e){
				System.out.println(e);
			}
		}
	}
}
class Main{
	public static void main(String[] args){
		Thread bmsThread = new BMSDisplayThread();
		Thread cseThread = new CSEDisplayThread();
		bmsThread.start();
		cseThread.start();
	}
}
