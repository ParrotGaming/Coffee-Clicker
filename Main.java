import javax.swing.*;
import java.awt.*;
class gui {
    public static void main(String args[]) {
        int points = 0;

        //Creating the Frame
        JFrame frame = new JFrame("To Do");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Store");
        mb.add(m1);
        JMenuItem m11 = new JMenuItem("Breeder");
        JMenuItem m22 = new JMenuItem("Aviary");
        m1.add(m11);
        m1.add(m22);

        JLabel l = new JLabel();
        l.setText("label text");
        JPanel pan = new JPanel();
        pan.add(l); 

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
        frame.add(pan);
    }
}