import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

  public class MyCompiler implements ActionListener,WindowListener,MouseListener
{ 
    JFrame fr=new JFrame("MyEditor");
    JMenuBar mb = new JMenuBar();
    JMenu me1 =new JMenu("FILE");
    JMenu me2=new JMenu("EDIT");
    JMenu me4=new JMenu("Format");
    JMenu me41=new JMenu("Font");
    JMenu me42=new JMenu("Font Style");
    JMenu me43=new JMenu("Font Size");
    JMenu me44=new JMenu("Font Color");
    JMenuItem me441=new JMenuItem("Blue");
    JMenuItem me442=new JMenuItem("Magenta");
    JMenuItem me443=new JMenuItem("Red");
    JMenuItem me444=new JMenuItem("Orange");
    JMenuItem me445=new JMenuItem("Yellow");
    JMenuItem me411=new JMenuItem("Serif");
    JMenuItem me412=new JMenuItem("Cohin");
    JMenuItem me413=new JMenuItem("Freestyle Script");
    JMenuItem me414=new JMenuItem("Courier New");
    JMenuItem me415=new JMenuItem("Forte");
    JMenuItem me421=new JMenuItem("Italic");
    JMenuItem me422=new JMenuItem("Bold");
    JMenuItem me423=new JMenuItem("Plain");
    JMenuItem me424=new JMenuItem("Plain_Italic");
    JMenuItem me425=new JMenuItem("Italic_Bold");
    JMenuItem me431=new JMenuItem("16");
    JMenuItem me432=new JMenuItem("18");
    JMenuItem me433=new JMenuItem("20");
    JMenuItem me434=new JMenuItem("24");
    JMenu me3=new JMenu("ABOUT US");
    JMenuItem me31=new JMenuItem("Suman and Aj");
    JMenuItem mi11=new JMenuItem("New");
    JMenuItem mi12=new JMenuItem("Open");
    JTextArea ta=new  JTextArea(30,121);
    JMenuItem mi13=new JMenuItem("Save");
    JMenuItem mi14=new JMenuItem("Saveas");
    JMenuItem mi15=new JMenuItem("Close");
    JMenuItem mi21=new JMenuItem("Cut");
    JMenuItem mi22=new JMenuItem("Paste");
    JMenuItem mi23=new JMenuItem("Copy");
    JMenuItem sel=new JMenuItem("SelectAll");
    JMenuItem mi21p=new JMenuItem("Cut");
    JMenuItem mi22p=new JMenuItem("Paste");
    JMenuItem mi23p=new JMenuItem("Copy");
    JMenuItem selp=new JMenuItem("SelectAll");
    JFileChooser fc = new JFileChooser();
    JScrollPane scroll = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    String currentLine,s1="" ;
    int result;
    File selectedFile;
    BufferedReader bf;
    JPopupMenu popup = new JPopupMenu();
    

    MyCompiler(char c)
    {
        JOptionPane.showMessageDialog(fr,"Hi!! Welcome to Editor...\nCreated by 'Ajay'\nPress Ok to continue");
    }

    MyCompiler(int a)
	{
	me31.setIcon(new ImageIcon("help1.gif"));
	me3.add(me31);
	me31.setForeground(Color.CYAN);
    mi11.setForeground(Color.CYAN);
    mi12.setForeground(Color.RED);
    mi13.setForeground(Color.CYAN);
    mi14.setForeground(Color.RED);
    mi15.setForeground(Color.CYAN);
    mi21.setForeground(Color.CYAN);
    mi22.setForeground(Color.RED);
    mi23.setForeground(Color.CYAN);
    me41.setForeground(Color.CYAN);
    me42.setForeground(Color.RED);
    me43.setForeground(Color.CYAN);
    me44.setForeground(Color.RED);
    sel.setForeground(Color.RED);
    mi11.setIcon(new ImageIcon("tt.gif"));
    mi12.setIcon(new ImageIcon("open.gif"));
    mi13.setIcon(new ImageIcon("save.gif"));
    mi14.setIcon(new ImageIcon("saveas.png"));
    mi15.setIcon(new ImageIcon("cancel.gif"));
    mi21.setIcon(new ImageIcon("cut.gif"));
    mi22.setIcon(new ImageIcon("paste.gif"));
    mi23.setIcon(new ImageIcon("copy.gif"));
    sel.setIcon(new ImageIcon("aj.png"));
    me43.setIcon(new ImageIcon("fn.png"));
    me42.setIcon(new ImageIcon("fn3.png"));
    me41.setIcon(new ImageIcon("fn1.png"));
    me44.setIcon(new ImageIcon("xx.png"));
    me411.setForeground(Color.CYAN);
    me412.setForeground(Color.RED);
    me413.setForeground(Color.CYAN);
    me414.setForeground(Color.RED);
    me415.setForeground(Color.CYAN);
    me421.setForeground(Color.RED);
    me422.setForeground(Color.CYAN);
    me423.setForeground(Color.RED);
    me424.setForeground(Color.CYAN);
    me425.setForeground(Color.RED);
     me431.setForeground(Color.CYAN);
    me432.setForeground(Color.RED);
    me433.setForeground(Color.CYAN);
    me434.setForeground(Color.RED);
    me441.setForeground(Color.BLUE);
    me442.setForeground(Color.MAGENTA);
    me443.setForeground(Color.RED);
    me444.setForeground(Color.GREEN);
    me445.setForeground(Color.YELLOW);
    me41.add(me411);
    me41.add(me412);
    me41.add(me413);
    me41.add(me414);
    me41.add(me415);
    me42.add(me421);
    me42.add(me422);
    me42.add(me423);
    me42.add(me424);
    me42.add(me425);
    me43.add(me431);
    me43.add(me432);
    me43.add(me433);
    me43.add(me434);
    me44.add(me441);
    me44.add(me442);
    me44.add(me443);
    me44.add(me444);
    me44.add(me445);
    me1.add(mi11);
    me1.add(mi12);
    me1.add(mi13);
    me1.add(mi14);
    me1.add(mi15);
    me1.addSeparator();
    me2.add(mi21);
    me2.add(sel);
    me2.add(mi23);
    me2.add(mi22);
    me4.add(me41);
    me4.add(me42);
    me4.add(me43);
    me4.add(me44);
    mb.add(me1);
    mb.add(me2);
    mb.add(me4);
    mb.add(me3);
    fr.setJMenuBar(mb);
    
    
    me1.setBackground(Color.YELLOW);
    me1.setForeground(Color.BLUE);
    me4.setBackground(Color.YELLOW);
    me4.setForeground(Color.BLUE);
    me2.setBackground(Color.YELLOW);
    me2.setForeground(Color.BLUE);
    me3.setBackground(Color.YELLOW);
    me3.setForeground(Color.BLUE);
    mb.setBackground(Color.PINK);
    mb.setForeground(Color.WHITE);
    ta.setFont(new Font("Serif", Font.PLAIN, 16));
    ta.setBackground(Color.lightGray);
    fr.add(scroll/*,BorderLayout.CENTER*/);

    fr.setSize(1400,750);
    fr.setLocationRelativeTo(null);
    fr.setLayout(new FlowLayout(FlowLayout.LEFT));
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.setVisible(true);
    mi11.addActionListener(this);
    mi12.addActionListener(this);
    mi13.addActionListener(this);
    mi15.addActionListener(this);
    me31.addActionListener(this);
    mi14.addActionListener(this);
    mi21.addActionListener(this);
    mi23.addActionListener(this);
    mi22.addActionListener(this);
    mi13.addActionListener(this);
    sel.addActionListener(this);
    me411.addActionListener(this);
    me412.addActionListener(this);
    me413.addActionListener(this);
    me414.addActionListener(this);
    me415.addActionListener(this);
    me421.addActionListener(this);
    me422.addActionListener(this);
    me423.addActionListener(this);
    me424.addActionListener(this);
    me425.addActionListener(this);
    me431.addActionListener(this);
    me432.addActionListener(this);
    me433.addActionListener(this);
    me434.addActionListener(this);
    me441.addActionListener(this);
    me442.addActionListener(this);
    me443.addActionListener(this);
    me444.addActionListener(this);
    me445.addActionListener(this);
    fr.addWindowListener(this);
    
    //popup.addMouseListener(this);
    mi11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    mi13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    mi21.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    mi23.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    mi22.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
    sel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    mi12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    mi14.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
    me31.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
    mi15.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
    me421.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
    me422.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
    me423.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
    mi21p.setForeground(Color.CYAN);
    mi22p.setForeground(Color.RED);
    mi23p.setForeground(Color.CYAN);
    selp.setForeground(Color.RED);
    mi21p.setIcon(new ImageIcon("cut.gif"));
    mi22p.setIcon(new ImageIcon("paste.gif"));
    mi23p.setIcon(new ImageIcon("copy.gif"));
    selp.setIcon(new ImageIcon("aj.png"));
    mi21p.addActionListener(this);
    mi23p.addActionListener(this);
    mi22p.addActionListener(this);
    selp.addActionListener(this);
    popup.add(mi21p);
    popup.add(mi22p);
    popup.add(mi23p);
    popup.add(selp);
    ta.addMouseListener(this);


}



 public void mousePressed(MouseEvent es) {
                showPopup(es);
            }
            public void mouseReleased(MouseEvent es) {
                
                showPopup(es);
            }
             
            public void mouseEntered(MouseEvent es)
            {

            }
            public void mouseExited(MouseEvent es)
            {

            }
            public void mouseClicked(MouseEvent es)
            {

            }
            void showPopup(MouseEvent es) {
                if (es.isPopupTrigger()) {
                    popup.show(es.getComponent(),
                            es.getX(), es.getY());
                }
            }




   public void windowClosing(WindowEvent a) {
   int close=JOptionPane.showConfirmDialog(fr,"Do you want to exit from this editor ?","confirm",JOptionPane.YES_NO_OPTION);
    if(close==JOptionPane.YES_OPTION)
{
    //fc.setCurrentDirectory(new File(System.getProperty("user.home")));
    result = fc.showSaveDialog(null);
    if (result == JFileChooser.APPROVE_OPTION)
{   FileWriter fw=null;
        try{
            fw=new FileWriter(fc.getSelectedFile().getAbsolutePath());
            ta.write(fw);
            }
        catch(IOException ex)
            {
                ex.printStackTrace();
            }
}

                    System.exit(0);
}
    else
        if(close==JOptionPane.NO_OPTION)
{
        JOptionPane.showMessageDialog(fr,"you cancel it !!");
        fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

}



    
}
  

  public void windowOpened(WindowEvent a) {}
  public void windowClosed(WindowEvent a) {}
  public void windowIconified(WindowEvent a) {}
  public void windowDeiconified(WindowEvent a) {}
  public void windowActivated(WindowEvent a) {}
  public void windowDeactivated(WindowEvent a) {}


     public void actionPerformed(ActionEvent e){  

    if(e.getSource()==me441)
        
    {  
       ta.setForeground(Color.BLUE);       
    }


    if(e.getSource()==me442)
    {
        ta.setForeground(Color.MAGENTA);    
    }

    if(e.getSource()==me443)
    {
        ta.setForeground(Color.RED);    
    }

    if(e.getSource()==me444)
    {
        ta.setForeground(Color.ORANGE);    
    }

    if(e.getSource()==me445)
    {
        ta.setForeground(Color.YELLOW);    
    }

   if(e.getSource()==me431)
    {
        ta.setFont(new Font("Serif", Font.PLAIN, 16));    
    }

    if(e.getSource()==me432)
    {
        ta.setFont(new Font("Serif", Font.PLAIN, 18));    
    }

    if(e.getSource()==me433)
    {
        ta.setFont(new Font("Serif", Font.PLAIN, 20));    
    }

    if(e.getSource()==me434)
    {
        ta.setFont(new Font("Serif", Font.PLAIN, 24));    
    }

   if(e.getSource()==me421)
    {
        ta.setFont(new Font("Serif", Font.ITALIC, 16));    
    }

    if(e.getSource()==me422)
    {
        ta.setFont(new Font("Serif", Font.BOLD, 16));    
    }

    if(e.getSource()==me423)
    {
        ta.setFont(new Font("Serif", Font.PLAIN, 16));    
    }

    if(e.getSource()==me424)
    {
        ta.setFont(new Font("Serif", Font.PLAIN +Font.ITALIC, 16));    
    }
    if(e.getSource()==me425)
    {
        ta.setFont(new Font("Serif", Font.ITALIC+Font.BOLD, 16));    
    }

     if(e.getSource()==me411)
    {
        ta.setFont(new Font("Serif", Font.PLAIN, 16));    
    }
     

     if(e.getSource()==me412)
    {
        ta.setFont(new Font("Cochin", Font.PLAIN, 16));    
    }


    if(e.getSource()==me413)
    {
        ta.setFont(new Font("Freestyle Script", Font.PLAIN, 16));    
    }



    if(e.getSource()==me414)
    {
        ta.setFont(new Font("Courier New", Font.PLAIN, 16));    
    }


    if(e.getSource()==me415)
    {
        ta.setFont(new Font("Forte", Font.PLAIN, 16));    
    } 


 if(e.getSource()==mi11)
{
	ta.setText("");
}
    if(e.getSource()==mi12)
{
    
    result = fc.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION)
{
    selectedFile = fc.getSelectedFile();
    try{
        bf=new BufferedReader(new FileReader(selectedFile));
        while((currentLine=bf.readLine())!=null)
        { 
        ta.read(bf,null);
        }
        }
    catch(Exception error)
        {
        error.printStackTrace();
        }
} 
           
}

    if(e.getSource()==mi13)

{
   
    result = fc.showSaveDialog(null);
    if (result == JFileChooser.APPROVE_OPTION)
{   FileWriter fw=null;
    try{
            fw=new FileWriter(fc.getSelectedFile().getAbsolutePath());
            ta.write(fw);
        }
    catch(IOException ex)
        {
            ex.printStackTrace();
        }
}


}

           
    if(e.getSource()==mi14)
{
    
    result = fc.showSaveDialog(null);
    if (result == JFileChooser.APPROVE_OPTION)
{   FileWriter fw=null;
    try{
        fw=new FileWriter(fc.getSelectedFile().getAbsolutePath());
        ta.write(fw);
        }
    catch(IOException ex)
        {
        ex.printStackTrace();
        }
}


}
     
    if(e.getSource()==mi15)
{
    int close=JOptionPane.showConfirmDialog(fr,"Do you want to exit from this editor ?","confirm",JOptionPane.YES_NO_OPTION);
    if(close==JOptionPane.YES_OPTION)
{
        result = fc.showSaveDialog(null);
    if (result == JFileChooser.APPROVE_OPTION)
{   FileWriter fw=null;
        try{
            fw=new FileWriter(fc.getSelectedFile().getAbsolutePath());
            ta.write(fw);
            }
        catch(IOException ex)
            {
                ex.printStackTrace();
            }
}

                    
                System.exit(0);
}
        else
        if(close==JOptionPane.NO_OPTION)
{
        JOptionPane.showMessageDialog(fr,"you cancel it !!");
}
}

    if(e.getSource()==me31)
{
    JFrame fj=new JFrame("AboutUs");
     JTextArea fg=new JTextArea("Hey guys,\nThis is created by 'SUMAN RANI' and 'AJAY SAHU'.\nWe are pursuing Bachelors in Information Technology in Lovely Professional University (L.P.U),phagwara,Punjab.\nRegistration No:-\nSuman=11401280\nAjay=1140788\nRoll No.:-\nSuman=A04\nAjay=A02.\n\nThis is a simple editor based on Graphical User Interface in Java Programming.\nThis is our project given by 'Ravikant Sahu'.\nSir help us whenever we have a difficulty and confusion.\nThankyou sir,\nDue to this project we have learnt many important things and concepts,which will be very helpful for us in future....\n",100,300);
    fg.setFont(new Font("Serif", Font.PLAIN, 16));

    fg.setBackground(Color.lightGray);
    fg.setForeground(Color.blue);
    fj.add(fg);
     fg.setEditable(false);
     fj.setSize(800,600);
     fj.setLocationRelativeTo(null);
     fj.setLayout(new FlowLayout(FlowLayout.LEFT));
     fj.setDefaultCloseOperation(fj.DISPOSE_ON_CLOSE);
     fj.setVisible(true);
 }


    if(e.getSource()==mi21)
{
    s1 = ta.getSelectedText();
    ta.replaceRange("", ta.getSelectionStart(), ta.getSelectionEnd());

}
if(e.getSource()==mi21p)
{
    s1 = ta.getSelectedText();
    ta.replaceRange("", ta.getSelectionStart(), ta.getSelectionEnd());

}

    if(e.getSource()==mi22)
{ 
    ta.insert(s1, ta.getCaretPosition());
}

if(e.getSource()==mi22p)
{ 
    ta.insert(s1, ta.getCaretPosition());
}
            
    if(e.getSource()==mi23)
{
    s1= ta.getSelectedText();
}

if(e.getSource()==mi23p)
{
    s1= ta.getSelectedText();
}
    if(e.getSource()==sel)
{
    ta.selectAll();
}
if(e.getSource()==selp)
{
    ta.selectAll();
}
  

}
    public static void main(String as[])
{
      	new MyCompiler('c');
        new MyCompiler(1);
        
}


}
