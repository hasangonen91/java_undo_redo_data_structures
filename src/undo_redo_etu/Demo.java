import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.undo.UndoManager;

public class Demo {

    UndoManager undo = new UndoManager();
    JTextField textField = new JTextField();
    char undoArray[];
    char redoArray[];

    int redoSayac;

    Demo() {

        textField.setBounds(40, 50, 250, 100);
        LinkedList<String> undoWords = new LinkedList<>();
        LinkedList<String> redoWords = new LinkedList<>();
        LinkedList<String> tutulan = new LinkedList<>();
        JFrame frame = new JFrame("UNDO AND REDO");
        JLabel l = new JLabel("NOTHING ENTERED");
        JLabel uyari = new JLabel("LISTENIN ILK HALI");
        JLabel tanim = new JLabel("ONCE LISTEYI GIRIN VE KAYDETE BASINIZ VE UNDO REDO CALISMAYA HAZIR ");
        JLabel bilgi = new JLabel("DarkSor");
        l.setBounds(50, 150, 500, 100);
        uyari.setBounds(50, 150, 500, 50);
        tanim.setBounds(20, 15, 500, 20);
        bilgi.setBounds(30, 230, 500, 20);
        frame.add(textField, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        frame.setBounds(40, 80, 200, 200);

        undo = new UndoManager();
        textField.getDocument().addUndoableEditListener(undo);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.getText();
                l.setText(" List [ " + textField.getText() + " ]");
                JOptionPane.showMessageDialog(frame, " List [ " + "," + textField.getText() + "," + " ]", 
                        "NEW LIST", JOptionPane.INFORMATION_MESSAGE);
                frame.add(l);
                panel.add(l);
                frame.add(panel);
                frame.add(uyari);
                frame.add(tanim);
                frame.add(bilgi);
                System.out.println(frame.add(l));
            }
        });
        JButton submit = new JButton();
        frame.add(submit = new JButton("KAYDET"));
        submit.setBounds(350, 50, 95, 30);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.getText();
                tutulan.add(textField.getText());
                uyari.setText("TUTULAN  List [ " + textField.getText() + " ]");
                frame.add(uyari);
                frame.add(tanim);
            }
        });
        JButton undoButton = new JButton();
        frame.add(undoButton = new JButton("UNDO"));
        undoButton.setBounds(350, 110, 95, 30);
        undoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (undo.canUndo()) {
                    undo.undo();
                    undoWords.add(textField.getText());
                    l.setText("Undo List [ " + textField.getText() + " ]");
                    JOptionPane.showMessageDialog(frame, "undoListesi List [ " + textField.getText() + " ]",
                            "NEW LIST", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Geri alinamaz!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton redoButton = new JButton();
        frame.add(redoButton = new JButton("REDO"));
        redoButton.setBounds(350, 170, 95, 30);
        redoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    redoSayac = 1;
                    while(redoSayac <6  ){
                  if(redoSayac==5){
                      redoSayac++;
                      break;
                   }
                    l.setText("Redo List [ " + textField.getText() + " ]");
                    JOptionPane.showMessageDialog(frame, "redoListesi List [ " + textField.getText() + " ]", 
                            "NEW LIST", JOptionPane.INFORMATION_MESSAGE);
                    if (undo.canRedo() ) {
                        undo.redo();
                        redoWords.add(textField.getText());
                        break;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Geri alinamaz!",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }
        });
        panel.add(l);
        frame.add(panel);
        frame.add(l);
        frame.add(uyari);
        frame.add(tanim);
        frame.add(bilgi);
        frame.add(textField);
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        System.out.println("HASAN GÖNEN 180303051 ");
        new Demo();
    }

}
//hasangonen91 //instagram-- my contact address