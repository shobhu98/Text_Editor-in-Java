import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Text_Editor extends JFrame implements ActionListener {
    JFrame p;
    JTextArea t;


    Text_Editor(){
        p = new JFrame("Text_Editor");
        t = new JTextArea();

        Font font = new Font("Verdana",Font.BOLD,16);
        t.setFont(font);



        JMenuBar mb = new JMenuBar();

        JMenu m1 = new JMenu("File");
        JMenuItem mi1 = new JMenuItem("Open");
        JMenuItem mi2 = new JMenuItem("New");
        JMenuItem mi3 = new JMenuItem("Save");


        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);

        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);



        JMenu m2 = new JMenu("Edit");
        JMenuItem mi4 = new JMenuItem("Cut");
        mi4.addActionListener(this);
        JMenuItem mi5 = new JMenuItem("Copy");
        mi5.addActionListener(this);
        JMenuItem mi6 = new JMenuItem("Paste");
        mi6.addActionListener(this);
        JMenuItem mi7 = new JMenuItem("Replace");
        mi7.addActionListener(this);
        JMenuItem mi8 = new JMenuItem("Replace All");
        mi8.addActionListener(this);
        JMenuItem mi9 = new JMenuItem("UpperCase");
        mi9.addActionListener(this);
        JMenuItem mi10 = new JMenuItem("Lower Case");
        mi10.addActionListener(this);


        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);
        m2.add(mi7);
        m2.add(mi8);
        m2.add(mi9);
        m2.add(mi10);





        mb.add(m1);
        mb.add(m2);
//        mb.add(close);
        p.setJMenuBar(mb);
        p.add(t);
        JScrollPane scroll = new JScrollPane(t,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        p.add(scroll);
        p.setSize(700,700);
        p.setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setVisible(true);


    }

    public static void main(String[] args) {
        Text_Editor tx=new Text_Editor();
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("New")){
            t.setText("");
        }
        else if(s.equals("Open")){
            JFileChooser j = new JFileChooser("f:");
            int r = j.showOpenDialog(null);
            if(r == JFileChooser.APPROVE_OPTION){
                try{
                    File fi = new File(j.getSelectedFile().getAbsolutePath());
                    String s1 = "",sl = "";
                    FileReader fr = new FileReader(fi);
                    BufferedReader br = new BufferedReader(fr);
                    while((s1 = br.readLine())!=null){
                        sl = sl+s1+"\n";
                    }
                    t.setText(sl);
                }catch(Exception e1){
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(null,"user cancelled");
            }
        }else if(s.equals("Save")){
            JFileChooser j = new JFileChooser("f:");
            int r = j.showSaveDialog(null);
            if(r == JFileChooser.APPROVE_OPTION){
                File fi = new File(j.getSelectedFile().getAbsolutePath());
                try{
                    FileWriter fw = new FileWriter(fi);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(t.getText());
                    bw.flush();
                    bw.close();
                }catch(Exception e3){
                    JOptionPane.showMessageDialog(null,e3.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(null,"user cancelled");
            }


    }else if(s.equals("Cut")){
            t.cut();
        }else if(s.equals("Copy")){
            t.copy();
        }else if(s.equals("Paste")){
            t.paste();
        }
        else if(s.equals("Replace")){
            JOptionPane.showMessageDialog( null, "CAUTION:Replace only replaces the first occurence of the word");
            String s2 =t.getText();
            String s3=JOptionPane.showInputDialog("Enter the word to be found");
            String s4=JOptionPane.showInputDialog("Enter the word to be used as a replacement");
            String s5=s2.replaceFirst(s3,s4);
            t.setText(s5);

        }
        else if(s.equals("Replace All")){
            String s2 =t.getText();
            String s3=JOptionPane.showInputDialog("Enter the word to be found");
            String s4=JOptionPane.showInputDialog("Enter the word to be used as a replacement");
            s2=s2.replaceAll(s3,s4);
            t.setText(s2);
        }
        else if(s.equals("UpperCase")){
            String s2 =t.getSelectedText();
            s2=s2.toUpperCase();
            t.setText(s2);
        }
        else if(s.equals("Lower Case")){
            String s2 =t.getSelectedText();
            s2=s2.toLowerCase();
            t.setText(s2);
        }


}
}
