import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TempConvert{
    
    private Container pane;
    private JButton b;
    private JLabel l;
    private JCheckBox c;
    private JTextField t;
    
    public static double CtoF(double c){
	return ((c * 9) / 5) + 32;
    }

    public static double FtoC(double f){
	return ((f - 32) * 5) / 9;
    }

    public TempConvert(){
	this.setTitle("Temperature Converter");
	this.setSize(800,600);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setlayout(new FlowLayout());
	b = new JButton("Convert");
	l = new JLabel("Enter Temp Here:");
	c = new JCheckBox("Celsius to Fahrenheit");
	f = new JCheckBox("Fahrenheit to Celsius");
	l2 = new JLabel("which one?");
	t = new JTextField(5);

	pane.add(l);
	pane.add(l);
	pane.add(l);
	pane.add(l);
	pane.add(l);
	
     }
    
}
