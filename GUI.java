import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ItemListener{
        Problem problem = new NavProblem();
        Algoritm algo;
    JPanel cards;
    final static String BUTTONPANEL1 = "BFS";
    final static String BUTTONPANEL2 = "UCS";
    final static String BUTTONPANEL3 = "DFS";
    final static String BUTTONPANEL4 = "DLS";
    final static String BUTTONPANEL5 = "IDS";
    final static String BUTTONPANEL6 = "GBFS";
    final static String BUTTONPANEL7 = "A*";

    public void addToPannel(Container pane){
        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = { BUTTONPANEL1, BUTTONPANEL2, BUTTONPANEL3, BUTTONPANEL4, BUTTONPANEL5, BUTTONPANEL6, BUTTONPANEL7 };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        JTextField tf=new JTextField();  
        tf.setBounds(new Rectangle(10,150,300,300));  

        JPanel card1 = new JPanel();
        JButton runGraph1 = new JButton("Run graph");
        JButton runTree1 = new JButton("Run tree");
        card1.add(runTree1);
        card1.add(runGraph1);
        runTree1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        algo = new BFS(true);
                        algo.setProblem(problem);
                        algo.execute();
                        tf.setText("Cost Cale: " + algo.raspuns.costCale);  
                        tf.validate();
                    }  
                });
        card1.add(tf);


        JPanel card2 = new JPanel();
        JButton runGraph2 = new JButton("Run graph");
        JButton runTree2 = new JButton("Run tree");
        card2.add(runTree2);
        card2.add(runGraph2);
        
        JPanel card3 = new JPanel();
        JButton runGraph3 = new JButton("Run graph");
        JButton runTree3 = new JButton("Run tree");
        card3.add(runTree3);
        card3.add(runGraph3);
        
        JPanel card4 = new JPanel();
        JButton runGraph4 = new JButton("Run graph");
        JButton runTree4 = new JButton("Run tree");
        card4.add(runTree4);
        card4.add(runGraph4);
        
        JPanel card5 = new JPanel();
        JButton runGraph5 = new JButton("Run graph");
        JButton runTree5 = new JButton("Run tree");
        card5.add(runTree5);
        card5.add(runGraph5);
        
        JPanel card6 = new JPanel();
        JButton runGraph6 = new JButton("Run graph");
        JButton runTree6 = new JButton("Run tree");
        card6.add(runTree6);
        card6.add(runGraph6);
        
        JPanel card7 = new JPanel();
        JButton runGraph7 = new JButton("Run graph");
        JButton runTree7 = new JButton("Run tree");
        card7.add(runTree7);
        card7.add(runGraph7);

        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL1);
        cards.add(card2, BUTTONPANEL2);
        cards.add(card3, BUTTONPANEL3);
        cards.add(card4, BUTTONPANEL4);
        cards.add(card5, BUTTONPANEL5);
        cards.add(card6, BUTTONPANEL6);
        cards.add(card7, BUTTONPANEL7);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);

    }
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Algorithms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = frame.getContentPane();
        Dimension d = new Dimension ( 600,400);
        c.setPreferredSize(d);

        GUI gui = new GUI();
        gui.addToPannel(frame.getContentPane());
         
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {




        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run(){
            createAndShowGUI();
        }    
    });
    }
}

