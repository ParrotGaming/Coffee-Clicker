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

        //Define button to get points
        JButton butt = new JButton("Get Beans");
        class MyCoolActionListener implements ActionListener {
            public int points = 0;
            public void actionPerformed (ActionEvent arg0) {
                    points = points +1;
                    l.setText(Integer.toString(points));
                    pan.add(l);
                    mb.add(pan);
            }
            public int getpoints() {
                return points;
            }
        }

        MyCoolActionListener al = new MyCoolActionListener();
        butt.addActionListener(al);
        al.getpoints();

        class MyCoolActionListener2 extends MyCoolActionListener implements ActionListener {
            @Override
            public void actionPerformed (ActionEvent arg1) {
                points = points -5;
            }
        }

        MyCoolActionListener al2 = new MyCoolActionListener();
        m11.addActionListener(al2);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.SOUTH, butt);
        frame.setVisible(true);
    }
}