package SistemGestiuneClienti;

import javax.swing.*;
import java.awt.*;

public class GUI {
	JFrame frame;
	JPanel panel;
	JLabel j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12,j13,j14,j15,j16,j17,j18;
	JProgressBar p1,p2,p3;
	JTextField t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18;
	JButton b1;
	public GUI() {
		
	frame = new JFrame("Sistem gestiune clienti");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(640, 480);

	panel = new JPanel();
	panel.setLayout(new GridLayout(19, 2));
	
	j1=new JLabel("Queue 1: ");	
	panel.add(j1);
	p1=new JProgressBar(0,25);
	p1.setStringPainted(true);
	panel.add(p1);
	
	j2=new JLabel("Queue 2: ");
	panel.add(j2);
	p2=new JProgressBar();
	p2.setStringPainted(true);
	panel.add(p2);
	
	j3=new JLabel("Queue 3: ");
	panel.add(j3);
	p3=new JProgressBar();
	p3.setStringPainted(true);
	panel.add(p3);
	
	j4=new JLabel("SimulationInterval: ");
	panel.add(j4);
	t4=new JTextField("Introdu valoarea");
	panel.add(t4);
	
	j5=new JLabel("MinInterval: ");
	panel.add(j5);
	t5=new JTextField("Introdu valoarea");
	panel.add(t5);
	
	j6=new JLabel("MaxInterval: ");
	panel.add(j6);
	t6=new JTextField("Introdu valoarea");
	panel.add(t6);
	
	
	
	j7=new JLabel("MinService: ");
	panel.add(j7);
	t7=new JTextField("Introdu valoarea");
	panel.add(t7);
	
	j8=new JLabel("MaxService: ");
	panel.add(j8);
	t8=new JTextField("Introdu valoarea");
	panel.add(t8);
	
	j9=new JLabel("Average service time queue1: ");
	panel.add(j9);
	t9=new JTextField("Rezultat");
	panel.add(t9);
	
	j10=new JLabel("Average service time queue2: ");
	panel.add(j10);
	t10=new JTextField("Rezultat");
	panel.add(t10);
	
	j11=new JLabel("Average service time queue3: ");
	panel.add(j11);
	t11=new JTextField("Rezultat");
	panel.add(t11);
	
	j12=new JLabel("Average waiting time queue1: ");
	panel.add(j12);	
	t12=new JTextField("Rezultat");
	panel.add(t12);
	
	j13=new JLabel("Average waiting time queue2: ");
	panel.add(j13);
	t13=new JTextField("Rezultat");
	panel.add(t13);
	
	j14=new JLabel("Average waiting time queue3: ");
	panel.add(j14);
	t14=new JTextField("Rezultat");
	panel.add(t14);
	
	j15=new JLabel("Empty queue1 time: ");
	panel.add(j15);
	t15=new JTextField("Rezultat");
	panel.add(t15);
	
	j16=new JLabel("Empty queue2 time: ");
	panel.add(j16);
	t16=new JTextField("Rezultat");
	panel.add(t16);
	
	j17=new JLabel("Empty queue3 time: ");
	panel.add(j17);
	t17=new JTextField("Rezultat");
	panel.add(t17);
	
	j18=new JLabel("Peak hour for the simulation interval: ");
	panel.add(j18);
	t18=new JTextField("Rezultat");
	panel.add(t18);
	
	b1=new JButton("Buton");
	panel.add(b1);
	
	
	frame.setContentPane(panel);
	frame.setVisible(true);
}
}