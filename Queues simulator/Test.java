package SistemGestiuneClienti;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI gui = new GUI();
		gui.b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int minInterval = Integer.parseInt(gui.t5.getText());
				int maxInterval = Integer.parseInt(gui.t6.getText());
				int minServiceTime = Integer.parseInt(gui.t7.getText());
				int maxServiceTime = Integer.parseInt(gui.t8.getText());
				int simulationInterval = Integer.parseInt(gui.t4.getText());
				int nrQueues = 3;
				int peakHour= 0;
				gui.p1.setMaximum(simulationInterval/6);
				gui.p2.setMaximum(simulationInterval/6);
				gui.p3.setMaximum(simulationInterval/6);
				ArrayList<Queue> cozi = new ArrayList<>(nrQueues);
				ArrayList<Thread> threads = new ArrayList<>(nrQueues);
				List<Integer> finalizare = new ArrayList<>();
				String names[] = { "Alin", "Dorin", "George", "Cristi", "Ovidiu", "Laura", "Aurelia", "Marian", "Paul",
						"Flavius" };
				Random rand = new Random();

				for (int i = 0; i < nrQueues; i++) {

					cozi.add(i, new Queue("Queue_" + i));
					threads.add(i, new Thread(cozi.get(i)));
					threads.get(i).setName("Thread_" + i);

				}

				TimerThread t = new TimerThread(0, simulationInterval/2);
				t.start();
				int r = -1,time1 = 0, time2 = 0, time3 = 0, i1 = 0, i2 = 0, i3 = 0;
				while (t.getSeconds() < simulationInterval/2) {
					if(cozi.get(0).getSizeQueue()+cozi.get(1).getSizeQueue()+cozi.get(2).getSizeQueue()>peakHour) peakHour=t.getSeconds();

					try {
						if (cozi.get(0).testEmptyQueue() == true) time1 = t.getSeconds();
						if (cozi.get(1).testEmptyQueue() == true) time2 = t.getSeconds();
						if (cozi.get(2).testEmptyQueue() == true) time3 = t.getSeconds();
						r = rand.nextInt(maxInterval) + minInterval;
						Client c = new Client(rand.nextInt(maxServiceTime) + minServiceTime, t.getSeconds(),names[rand.nextInt(names.length)]);

						if (cozi.get(0).getTotalTimeWaiting() <= cozi.get(1).getTotalTimeWaiting()
								&& cozi.get(1).getTotalTimeWaiting() <= cozi.get(2).getTotalTimeWaiting()) {

							i1++;
							gui.p1.setValue(i1);
							gui.p1.update(gui.p1.getGraphics());
							gui.p1.repaint();
							cozi.get(0).addClient(c);
							finalizare.add(c.getFinishTime());
							finalizare = finalizare.stream().distinct().collect(Collectors.toList());
							Collections.sort(finalizare);
						}

						else if (cozi.get(0).getTotalTimeWaiting() <= cozi.get(2).getTotalTimeWaiting()
								&& cozi.get(2).getTotalTimeWaiting() <= cozi.get(1).getTotalTimeWaiting()) {

							i1++;
							gui.p1.setValue(i1);
							gui.p1.repaint();
							gui.p1.update(gui.p1.getGraphics());
							cozi.get(0).addClient(c);
							finalizare.add(c.getFinishTime());
							finalizare = finalizare.stream().distinct().collect(Collectors.toList());
							Collections.sort(finalizare);

						} else if (cozi.get(1).getTotalTimeWaiting() <= cozi.get(0).getTotalTimeWaiting()
								&& cozi.get(0).getTotalTimeWaiting() <= cozi.get(2).getTotalTimeWaiting()) {

							i2++;
							gui.p2.setValue(i2);
							gui.p2.repaint();
							gui.p2.update(gui.p2.getGraphics());
							cozi.get(1).addClient(c);
							finalizare.add(c.getFinishTime());
							finalizare = finalizare.stream().distinct().collect(Collectors.toList());
							Collections.sort(finalizare);

						} else if (cozi.get(1).getTotalTimeWaiting() <= cozi.get(2).getTotalTimeWaiting()
								&& cozi.get(2).getTotalTimeWaiting() <= cozi.get(0).getTotalTimeWaiting()) {

							i2++;
							gui.p2.setValue(i2);
							gui.p2.repaint();
							gui.p2.update(gui.p2.getGraphics());
							cozi.get(1).addClient(c);
							finalizare.add(c.getFinishTime());
							finalizare = finalizare.stream().distinct().collect(Collectors.toList());
							Collections.sort(finalizare);

						} else if (cozi.get(2).getTotalTimeWaiting() <= cozi.get(0).getTotalTimeWaiting()
								&& cozi.get(0).getTotalTimeWaiting() <= cozi.get(1).getTotalTimeWaiting()) {

							i3++;
							gui.p3.setValue(i3);
							gui.p3.repaint();
							gui.p3.update(gui.p3.getGraphics());
							cozi.get(2).addClient(c);
							finalizare.add(c.getFinishTime());
							finalizare = finalizare.stream().distinct().collect(Collectors.toList());
							Collections.sort(finalizare);

						} else if (cozi.get(2).getTotalTimeWaiting() <= cozi.get(1).getTotalTimeWaiting()
								&& cozi.get(1).getTotalTimeWaiting() <= cozi.get(0).getTotalTimeWaiting()) {

							i3++;
							gui.p3.setValue(i3);
							gui.p3.repaint();
							gui.p3.update(gui.p3.getGraphics());
							cozi.get(2).addClient(c);
							finalizare.add(c.getFinishTime());
							finalizare = finalizare.stream().distinct().collect(Collectors.toList());
							Collections.sort(finalizare);
						}

						Thread.sleep(1000 * r);

					} catch (InterruptedException e1) {

						e1.printStackTrace();
					}

				}
				
				float f1 = 0, f2 = 0, f3 = 0,a1 = 0, a2 = 0, a3 = 0;
				f1 = cozi.get(0).getAverageTimeService();
				f2 = cozi.get(1).getAverageTimeService();
				f3 = cozi.get(2).getAverageTimeService();
				a1 = cozi.get(0).getAverageTimeWaiting();
				a2 = cozi.get(1).getAverageTimeWaiting();
				a3 = cozi.get(2).getAverageTimeWaiting();

				TimerThread t1 = new TimerThread(0, simulationInterval/2);
				t1.start();
				while (t1.getSeconds() < simulationInterval/2) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					if (!finalizare.isEmpty()) {
						if (t1.getSeconds() == finalizare.get(0)) {
							if (!cozi.get(0).clients.isEmpty()) {
								if (finalizare.get(0) == cozi.get(0).clients.peek().getFinishTime()) {
									i1--;
									gui.p1.setValue(i1);
									gui.p1.repaint();
									gui.p1.update(gui.p1.getGraphics());
									cozi.get(0).removeClient();
								}
							}
							if (!cozi.get(1).clients.isEmpty()) {
								if (finalizare.get(0) == cozi.get(1).clients.peek().getFinishTime()) {
									i2--;
									gui.p2.setValue(i2);
									gui.p2.repaint();
									gui.p2.update(gui.p2.getGraphics());
									cozi.get(1).removeClient();
								}
							}
							if (!cozi.get(0).clients.isEmpty()) {
								if (finalizare.get(0) == cozi.get(2).clients.peek().getFinishTime()) {
									i3--;	
									gui.p3.setValue(i3);
									gui.p3.repaint();
									gui.p3.update(gui.p3.getGraphics());
									cozi.get(2).removeClient();
								}
							}
							finalizare.remove(0);
						}}}
				
				threads.get(0).start();
				threads.get(1).start();
				threads.get(2).start();
                 
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(2);	
				gui.t9.setText(df.format(f1));
				gui.t10.setText(df.format(f2));
				gui.t11.setText(df.format(f3));
				gui.t12.setText(df.format(a1));
				gui.t13.setText(df.format(a2));
				gui.t14.setText(df.format(a3));
				gui.t15.setText(Integer.toString(time1));
				gui.t16.setText(Integer.toString(time2));
				gui.t17.setText(Integer.toString(time3));
				gui.t18.setText(Integer.toString(peakHour));

			}
		});
	}
}
