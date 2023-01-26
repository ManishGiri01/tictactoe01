package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.jar.JarEntry;

public class tic_tac implements ActionListener {
    Random r=new Random();
    JFrame f=new JFrame();
    JPanel tp=new JPanel();
    JPanel bp=new JPanel();
    JLabel tf=new JLabel();
    JButton[] b=new JButton[9];
    boolean pl1;

    tic_tac()
    {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,800);
        f.getContentPane().setBackground(Color.black);
        f.setLayout(new BorderLayout());
        f.setVisible(true);

        tf.setBackground(new Color(25,25,25));
        tf.setForeground(new Color(24,250,0));
        tf.setFont(new Font("ink",Font.BOLD,75));
        tf.setHorizontalAlignment(JLabel.CENTER);
        tf.setText("tic tac toe");
        tf.setOpaque(true);

        tp.setLayout(new BorderLayout());
        tp.setBounds(0,0,800,100);


        bp.setLayout(new GridLayout(3,3));
        bp.setBackground(Color.BLUE);

        for(int i=0;i<9;i++)
        {
            b[i]=new JButton();
            bp.add(b[i]);
            b[i].setFont(new Font("mv",Font.BOLD,120));
            b[i].setBackground(Color.orange);
            b[i].setFocusable(false);
            b[i].addActionListener(this);
        }

        tp.add(tf);
        f.add(tp,BorderLayout.NORTH);
        f.add(bp);
        first_turn();
    }

public void actionPerformed(ActionEvent e)
{
    for(int i=0;i<9;i++)
    {
        if(e.getSource()==b[i]){
            if(pl1)
            {
                if(b[i].getText()=="")
                {
                    b[i].setForeground(new Color(255,0,0));
                    b[i].setText("X");
                    pl1=false;
                    tf.setText("O turn");
                    check();
                }
            }
            else
            {
                if(b[i].getText()=="")
                {
                    b[i].setForeground(new Color(0,0,255));
                    b[i].setText("O");
                    pl1=true;
                    tf.setText("X turn");
                    check();
                }
            }
        }
    }
}
public void first_turn()
{
    try
    {
        Thread.sleep(2000);
    }catch (InterruptedException e)
    {
        e.printStackTrace();
    }
    if(r.nextInt(2)==0)
    {
        pl1=true;
        tf.setText("X turn");

    }
    else
    {
        pl1=false;
        tf.setText("O turn");
    }
}
public void check()
{
    if((b[0].getText()=="X") && (b[1].getText()=="X") && (b[2].getText()=="X"))
    {
        x_wins(0,1,2);
    }
    if((b[3].getText()=="X") && (b[4].getText()=="X") && (b[5].getText()=="X"))
    {
        x_wins(3,4,5);
    }
    if((b[6].getText()=="X") && (b[7].getText()=="X") && (b[8].getText()=="X"))
    {
        x_wins(6,7,8);
    }
    if((b[0].getText()=="X") && (b[3].getText()=="X") && (b[6].getText()=="X"))
    {
        x_wins(0,3,6);
    }
    if((b[1].getText()=="X") && (b[4].getText()=="X") && (b[7].getText()=="X"))
    {
        x_wins(1,4,7);
    }
    if((b[2].getText()=="X") && (b[5].getText()=="X") && (b[8].getText()=="X"))
    {
        x_wins(2,5,8);
    }
    if((b[0].getText()=="X") && (b[4].getText()=="X") && (b[8].getText()=="X"))
    {
        x_wins(0,4,8);
    }
    if((b[2].getText()=="X") && (b[4].getText()=="X") && (b[6].getText()=="X"))
    {
        x_wins(2,4,6);
    }
    if((b[0].getText()=="O") && (b[1].getText()=="O") && (b[2].getText()=="O"))
    {
        o_wins(0,1,2);
    }
    if((b[3].getText()=="O") && (b[4].getText()=="O") && (b[5].getText()=="O"))
    {
        o_wins(3,4,5);
    }
    if((b[6].getText()=="O") && (b[7].getText()=="O") && (b[8].getText()=="O"))
    {
        o_wins(6,7,8);
    }
    if((b[0].getText()=="O") && (b[3].getText()=="O") && (b[6].getText()=="O"))
    {
        o_wins(0,3,6);
    }
    if((b[1].getText()=="O") && (b[4].getText()=="O") && (b[7].getText()=="O"))
    {
        o_wins(1,4,7);
    }
    if((b[2].getText()=="O") && (b[5].getText()=="O") && (b[8].getText()=="O"))
    {
        o_wins(2,5,8);
    }
    if((b[0].getText()=="O") && (b[4].getText()=="O") && (b[8].getText()=="O"))
    {
        o_wins(0,4,8);
    }
    if((b[2].getText()=="O") && (b[4].getText()=="O") && (b[6].getText()=="O"))
    {
        o_wins(2,4,6);
    }
}
public void x_wins(int a,int c,int d)
{

       b[a].setBackground(Color.GREEN);
       b[d].setBackground(Color.GREEN);
       b[c].setBackground(Color.GREEN);

       for(int i=0;i<9;i++)
       {
           b[i].setEnabled(false);
       }
       tf.setText("X wins");
}
public void o_wins(int a,int c,int d)
{
    b[a].setBackground(Color.GREEN);
    b[d].setBackground(Color.GREEN);
    b[c].setBackground(Color.GREEN);

    for(int i=0;i<9;i++)
    {
        b[i].setEnabled(false);
    }
    tf.setText("O wins");
}

}

