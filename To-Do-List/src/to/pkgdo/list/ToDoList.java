
package to.pkgdo.list;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class ToDoList {

    public static void main(String[] args) {

        JFrame frame = new JFrame("To do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        JPanel panel = new JPanel();
        TitledBorder title = new TitledBorder("To do List");
        panel.setBorder(title);
        panel.setLayout(null);
        panel.setBounds(10, 10, 500, 60);
        frame.add(panel);
        
        JTextField txtf = new JTextField();
        txtf.setBounds(200, 20, 100, 30);
        panel.add(txtf);
        
        JButton buton = new JButton("add task");
        buton.setBounds(300, 20, 100, 30);
        panel.add(buton);
        
        JButton delete= new JButton("Delete Task"); 
        delete.setBounds(200, 500, 200, 30); 
        frame.add(delete); 
        delete.setEnabled(false);
        
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBounds(10, 100, 500, 400);
        frame.add(scroll);
        
        JButton clear = new JButton("CLEAR");
        clear.setBounds(500, 500, 200, 30);
        frame.add(clear);
        
        clear.addActionListener((e) -> {
        
           model.removeAllElements();
            
        });

        buton.addActionListener((e) -> {
        
            String text = txtf.getText();
            
            if(text.isEmpty()){
            
                JOptionPane.showMessageDialog(frame, "please enter a task");
            
                return;
            }
        model.addElement(text);
        txtf.setText("");
            
            
        });
        
        delete.addActionListener((e) -> {
            
            int selected = list.getSelectedIndex();
            
            if(selected!=-1){
            
                model.remove(selected);
                
            }
            
        });
        list.addListSelectionListener((e) -> {
        
            if (list.getSelectedIndex() == -1) {
            delete.setEnabled(false);
        } else {
            delete.setEnabled(true);
        }
            
        });
        frame.setVisible(true);
    }
    
}
