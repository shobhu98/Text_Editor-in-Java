import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.*;

public class First_GUI {
    public static void main(String[] args) {
        abc obj=new abc();

    }

}

class abc extends JFrame implements ActionListener {
    JTextField t1,t2;
    JButton b1,b2;
    JLabel l;


    abc(){
         JTextArea jtf = new JTextArea();
         t1=new JTextField(20);
         t2=new JTextField(20);
         b1=new JButton("ADD");
         b2=new JButton("Sub");
        l=new JLabel("result");
        add(jtf);
        add(t1);
        add(t2);
        add(b1);
        add(b2);
        add(l);
        b1.addActionListener(this);
        b2.addActionListener(this);






        setLayout(new FlowLayout());
        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent var1){
        int num1=Integer.parseInt(t1.getText());
        int num2=Integer.parseInt(t2.getText());


        if(var1.getSource()==b1){
            int value=num1+num2;
            l.setText(value+"");
        }
        else {
            int val=num1-num2;
            l.setText(val+"");
        }



    }

}
