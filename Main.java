import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
class gui {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Coffe Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Store");
        JMenu m2 = new JMenu("File");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Upgrade Grinder");
        m1.add(m11);
        JMenuItem m12 = new JMenuItem("Hire Barista");
        m1.add(m12);
        JMenuItem m21 = new JMenuItem("Save");
        m2.add(m21);
        JMenuItem m22 = new JMenuItem("Load");
        m2.add(m22);

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

        class State {
            public void SaveGame() {
                try {
                    FileWriter writer = new FileWriter("Save.txt", false);
                    writer.write(gv.getpoints() + "\n");
                    writer.write(gv.getgrinders() + "\n");
                    writer.write(gv.getbaristas() + "\n");

                    writer.close();
                }catch(Exception e){
                
                }
            }
            public void LoadGame() {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("Save.txt"));
                    String line = reader.readLine();
                    int pos = 0;
                    int result = Integer.parseInt(line);
                    while(line != null) {
                        if(pos == 0) {
                            gv.setpoints(result);
                            l.setText(Integer.toString(gv.getpoints()));
                            pan.add(l);
                            mb.add(pan);
                        }
                        else if(pos == 1) {
                            gv.setgrinders(result);
                        }
                        else if(pos == 2) {
                            gv.setbaristas(result);
                        }
                        pos = pos +1;
                        line = reader.readLine();
                        result = Integer.parseInt(line);
                    }
                }catch(Exception e) {

                }
            }
        }

        //Define button to get points
        JButton butt = new JButton("Get Beans");
        class MyCoolActionListener implements ActionListener {
            public void actionPerformed (ActionEvent arg0) {
                gv.setpoints(gv.getpoints() +gv.getgrinders());
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
                        gcost = gcost + 5 * gv.getgrinders();
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
                        bcost = bcost + gv.getbaristas() * 10;
                    }
                }else{
                    l.setText("You Don't Have Enough Beans!");
                    pan.add(l);
                    mb.add(pan);
                }
                System.out.println("Bcost: "+bcost);
            }
        }

        State state = new State();

        class MyCoolActionListener4 implements ActionListener {
            public void actionPerformed (ActionEvent ev) {
                state.SaveGame();
            }
        }

        class MyCoolActionListener5 implements ActionListener {
            public void actionPerformed (ActionEvent ev) {
                state.LoadGame();
            }
        }

        MyCoolActionListener2 al2 = new MyCoolActionListener2();
        m11.addActionListener(al2);

        MyCoolActionListener3 al3 = new MyCoolActionListener3();
        m12.addActionListener(al3);

        MyCoolActionListener4 al4 = new MyCoolActionListener4();
        m21.addActionListener(al4);

        MyCoolActionListener5 al5 = new MyCoolActionListener5();
        m22.addActionListener(al5);

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