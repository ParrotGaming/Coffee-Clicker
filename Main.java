import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class gui {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Coffe Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Store");
        mb.add(m1);
        JMenuItem m11 = new JMenuItem("Upgrade Grinder");
        m1.add(m11);
        JMenuItem m12 = new JMenuItem("Hire Barista");
        m1.add(m12);

        //Making the points visible
        JLabel l = new JLabel();
        l.setText("0");
        JPanel pan = new JPanel();
        pan.add(l);
        mb.add(pan);

        //Define Globals
        class Globals {
            private int points = 0;
            private int grinders = 1;
            private int baristas = 0;
            public int getpoints() {
                return points;
            }
            public void setpoints(int points) {
                this.points = points;
            }
            public int getgrinders() {
                return grinders;
            }
            public void setgrinders(int grinders) {
                this.grinders = grinders;
            }
            public int getbaristas() {
                return baristas;
            }
            public void setbaristas(int baristas) {
                this.baristas = baristas;
            }
        }

        Globals gv = new Globals();

        //Define button to get points
        JButton butt = new JButton("Get Beans");
        class MyCoolActionListener implements ActionListener {
            public void actionPerformed (ActionEvent arg0) {
                gv.setpoints(gv.getpoints() +1);
                if(gv.getgrinders()>1) {
                    gv.setpoints(gv.getpoints()+gv.getgrinders()-1);
                }
                l.setText(Integer.toString(gv.getpoints()));
                pan.add(l);
                mb.add(pan);    
            }
        }

        MyCoolActionListener al = new MyCoolActionListener();
        butt.addActionListener(al);

        class MyCoolActionListener2 implements ActionListener {
            int gcost = 5;
            public void actionPerformed (ActionEvent ev) {
                boolean clicked = false;
                if(gv.getpoints()>=gcost) {
                    gv.setpoints(gv.getpoints() -gcost);
                    l.setText(Integer.toString(gv.getpoints()));
                    pan.add(l);
                    mb.add(pan);
                    gv.setgrinders(gv.getgrinders()+1);
                    if(gv.getgrinders() > 0) {
                        gcost = 5 * gv.getgrinders();
                    }
                }else{
                    l.setText("You Don't Have Enough Beans!");
                    pan.add(l);
                    mb.add(pan);
                }
                System.out.println("Gcost: "+gcost);
            }
        }

        class MyCoolActionListener3 implements ActionListener {
            int bcost = 10;
            public void actionPerformed (ActionEvent ev) {
                boolean clicked = false;
                if(gv.getpoints()>=bcost) {
                    gv.setpoints(gv.getpoints() -bcost);
                    l.setText(Integer.toString(gv.getpoints()));
                    pan.add(l);
                    mb.add(pan);
                    gv.setbaristas(gv.getbaristas()+1);
                    if(gv.getbaristas() > 0) {
                        bcost = bcost + gv.getgrinders() * 10;
                    }
                }else{
                    l.setText("You Don't Have Enough Beans!");
                    pan.add(l);
                    mb.add(pan);
                }
                System.out.println("Bcost: "+bcost);
            }
        }

        MyCoolActionListener2 al2 = new MyCoolActionListener2();
        m11.addActionListener(al2);

        MyCoolActionListener3 al3 = new MyCoolActionListener3();
        m12.addActionListener(al3);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.SOUTH, butt);
        frame.setVisible(true);
        while(true) {
            try {
                while (true) {
                    gv.setpoints(gv.getpoints() +gv.getbaristas());
                    l.setText(Integer.toString(gv.getpoints()));
                    pan.add(l);
                    mb.add(pan);
                    Thread.sleep(2 * 1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}