import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class gui {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("To Do");
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

        //Define button to get points
        JButton butt = new JButton("Get Beans");

        class MyCoolActionListener implements ActionListener {
            int points = 0;
            public void actionPerformed (ActionEvent arg0) {
                    points = points +1;
                    l.setText(Integer.toString(points));
                }
            public int getpoints() {
                return points;
            }
        }

        MyCoolActionListener al = new MyCoolActionListener();
        butt.addActionListener(al);
        al.getpoints();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
        frame.add(butt);

        //Main loop
        while(true) {
            pan.add(l);
            mb.add(pan); 
        }
    }
}