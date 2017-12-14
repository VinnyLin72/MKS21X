import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TempConvert extends JFrame implements ActionListener{
    
    private Container pane;
    private JButton b;
    private JLabel l, l2;
    private JCheckBox c, f;
    private JTextField t;
    
    public static double CtoF(double c){
	return ((c * 9) / 5) + 32;
    }

    public static double FtoC(double f){
	return ((f - 32) * 5) / 9;
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        System.out.println(s);
        if(s.equals("ByteMe")){
            //button code here
            if( c.isSelected() ){
                t.setText(t.getText().toUpperCase());
            }else{
                t.setText("What do you want?");
            }
        }
        if(s.equals("Clear")){
            //button code here
            t.setText("");
        }

    }

    public TempConvert(){
	this.setTitle("Temperature Converter");
	this.setSize(300,150);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	b = new JButton("Convert");
	l = new JLabel("Enter Temp Here:");
	c = new JCheckBox("Celsius to Fahrenheit");
	f = new JCheckBox("Fahrenheit to Celsius");
	l2 = new JLabel("which one?");
	t = new JTextField(5);

	b.addActionListener(this);
	c.addActionListener(this);
        f.addActionListener(this);
        t.addActionListener(this);

	pane.add(l);
	pane.add(t);
	pane.add(b);
	pane.add(l2);
	pane.add(c);
	pane.add(f);
     }

    public static void main(String[] args) {
        TempConvert g = new TempConvert();
        g.setVisible(true);
    }
    
}
