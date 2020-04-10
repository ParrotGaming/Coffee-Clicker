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

        //Making the points visible
        JLabel l = new JLabel();
        l.setText("0");
        JPanel pan = new JPanel();
        pan.add(l);
        mb.add(pan);

        //Define Globals
        class Globals {
            private int points = 0;
            private int grinders = 0;
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
        }

        Globals gv = new Globals();

        //Define button to get points
        JButton butt = new JButton("Get Beans");
        class MyCoolActionListener implements ActionListener {
            public void actionPerformed (ActionEvent arg0) {
                gv.setpoints(gv.getpoints() +1);
                if(gv.getgrinders()>0) {
                    gv.setpoints(gv.getpoints()+gv.getgrinders());
                }
                l.setText(Integer.toString(gv.getpoints()));
                pan.add(l);
                mb.add(pan);    
            }
        }

        MyCoolActionListener al = new MyCoolActionListener();
        butt.addActionListener(al);

        class MyCoolActionListener2 implements ActionListener {
            int gcost;
            public void actionPerformed (ActionEvent ev) {
                boolean clicked = false;
                if(gv.getgrinders() <=0) {
                    gcost = 5;
                } else if(gv.getpoints()>=gcost) {
                    gcost = gcost * gv.getgrinders();
                }
                if(gv.getpoints()>=gcost) {
                    gv.setpoints(gv.getpoints() -gcost);
                    l.setText(Integer.toString(gv.getpoints()));
                    pan.add(l);
                    mb.add(pan);
                    gv.setgrinders(gv.getgrinders()+1);
                    clicked = true;
                }else if(clicked = false){
                    l.setText("You Don't Have Enough Beans!");
                    pan.add(l);
                    mb.add(pan);
                }
                System.out.println();
                System.out.println(gv.getpoints());
                System.out.println();
                System.out.println(gcost);
                System.out.println();
                System.out.println(gv.getgrinders());
            }
        }

        MyCoolActionListener2 al2 = new MyCoolActionListener2();
        m11.addActionListener(al2);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.SOUTH, butt);
        frame.setVisible(true);
    }
}