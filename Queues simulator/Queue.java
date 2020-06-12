package SistemGestiuneClienti;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Queue implements Runnable {
	private static final Logger LOGGER = Logger.getLogger(Logg.class.getName());
	LinkedBlockingQueue<Client> clients = new LinkedBlockingQueue<>();
	private String nameQueue;
	private float averageTimeService = 0;
	private float averageWaitingTime=0;
	private int totalTimeService = 0;
	private int totalTimeWaiting=0;
	private int totalClients = 0;
	private int finishTime = 0;
	private int timeWaiting=0;

	public Queue(String a) {
		this.nameQueue = a;
	}

	public void addClient(Client c) {
		Logg.setupLogger();
		LOGGER.log(Level.INFO, c.getName() + " enters " + nameQueue);
		
		
		totalTimeService = totalTimeService+c.getServiceTime();
		if(timeWaiting==0)
		timeWaiting=c.getServiceTime();
		else if(finishTime>=c.getArrivalTime()) timeWaiting=finishTime-c.getArrivalTime()+c.getServiceTime();
		else timeWaiting=c.getServiceTime();
		if(finishTime==0)
		finishTime = finishTime + c.getServiceTime() + c.getArrivalTime();
		else if(finishTime>=c.getArrivalTime()) finishTime=finishTime+c.getServiceTime();
		else finishTime=c.getArrivalTime()+c.getServiceTime();
		
		totalTimeWaiting=totalTimeWaiting+timeWaiting;
		totalClients++;
		c.setFinishTime(finishTime);
		c.setWaitingTime(timeWaiting);
		clients.add(c);

	}
	
	public void removeClient() {
		Logg.setupLogger();
		if (!clients.isEmpty()) {
            LOGGER.log(Level.INFO,"The number of clients in  " + nameQueue + " is " + getSizeQueue());
            Client client;
            client = clients.peek();
            LOGGER.log(Level.INFO,client.getName() + " having service time " + client.getServiceTime() + " seconds");
            LOGGER.log(Level.INFO, client.getName() + " leaves from " + nameQueue);

            clients.remove();

	}
	}

	public int getFinishTime() {
		return this.finishTime;
	}

	public int getSizeQueue() {
		return clients.size();
	}
	
	public int getTotalClients(){
		return this.totalClients;
	}
	
	public float getAverageTimeService() {
		this.averageTimeService=(float) (this.totalTimeService*1.0/this.totalClients);
		return this.averageTimeService;
	}
	
	public float getAverageTimeWaiting() {
		this.averageWaitingTime=(float) (this.totalTimeWaiting*1.0/this.totalClients);
		return this.averageWaitingTime;
	}
	
	public int getTotalTimeService() {
		return this.totalTimeService;
	}

	public int getTotalTimeWaiting() {
		return this.totalTimeWaiting;
	}

	public String printQueue() {
		String sir = "";
		for (Client c1 : clients) {
			sir = sir + "Clientul " + c1.getName() + " cu timpul de procesare " + c1.getServiceTime()
					+ " cu timpul de venire " + c1.getArrivalTime() + " cu timpul de finalizare " + c1.getFinishTime()
					+ " timpul de asteptare "+c1.getWaitingTime()+" ";
		}
		return sir;
	}

	public String getNameOfThisQueue() {
		return this.nameQueue;
	}
	

	public boolean testEmptyQueue() {
		if (clients.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public void run() {
		Logg.setupLogger();
		// TODO Auto-generated method stub
		 while (true) {
	            if (!clients.isEmpty()) {
	                LOGGER.log(Level.INFO,"The number of clients in  " + nameQueue + " is " + getSizeQueue());
	                Client client;
	                client = clients.peek();

	                LOGGER.log(Level.INFO,client.getName() + " having Service Time " + client.getServiceTime() + " seconds");

	                try {
	                    TimeUnit.SECONDS.sleep(client.getFinishTime());
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                clients.remove();
	               
	                LOGGER.log(Level.INFO,client.getName() + " has finished and leaves from " + nameQueue);

	               
	            }
		
	}

}
}
