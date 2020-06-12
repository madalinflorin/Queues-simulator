package SistemGestiuneClienti;

public class Client {
	
	private int serviceTime;
	private int arrivalTime;
	private String name;
	private int finishTime;
	private int waitingTime;
	
	public Client(int a,int c,String b) {
		this.serviceTime=a;
		this.arrivalTime=c;
		this.name=b;
	}
	
	public int getArrivalTime() {
		return this.arrivalTime;
	}
	
	public int getServiceTime() {
		return this.serviceTime;
	}
	
	public String getName() {
		return this.name;
	

}
	public void setFinishTime(int ftime) {
		this.finishTime=ftime;
	}
	
	public int getFinishTime() {
		return this.finishTime;
	}
	public void setWaitingTime(int ftime) {
		this.waitingTime=ftime;
	}
	
	public int getWaitingTime() {
		return this.waitingTime;
	}
}
