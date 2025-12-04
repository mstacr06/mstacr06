package restoran.sipariş.formu;

import java.awt.ScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RestoranSiparişFormu {
  
    public static void main(String[] args) {

        JFrame frame = new JFrame("Restaurant Order System");
        frame.setLayout(null);
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel labelname = new JLabel("Name: ");
        labelname.setBounds(20, 20, 80, 25);
        frame.add(labelname);
        
        JTextField txtname = new JTextField(".");
        txtname.setBounds(100, 20, 200, 25);
        frame.add(txtname);
        
        JLabel labelphone = new JLabel("Phone: ");
        labelphone.setBounds(350, 20, 80, 25);
        frame.add(labelphone);
        
        JTextField txtphone = new JTextField();
        txtphone.setBounds(420, 20, 200, 25);
        frame.add(txtphone);
        
        JLabel labelmeal = new JLabel("Choose a meal: ");
        labelmeal.setBounds(20, 70, 150, 25);
        frame.add(labelmeal);
        
        String [] meals ={"Pasta - $12","Burger - $10","Salad - $8"};
        JComboBox <String> mealsBox = new JComboBox<>(meals);
        mealsBox.setBounds(20, 100, 200, 25);
        frame.add(mealsBox);
        
        JLabel labelquantity = new JLabel("Quantity: ");
        labelquantity.setBounds(20, 135, 150, 25);
        frame.add(labelquantity);
        
        JSpinner spinner = new JSpinner();
        spinner.setBounds(20, 160, 60, 30);
        frame.add(spinner);
        
        JCheckBox cheesebox = new JCheckBox("Extra Cheese (+$2)");
        cheesebox.setBounds(20, 200, 200, 25);
        frame.add(cheesebox);
        
        JLabel labeldrink = new JLabel("Choose a drink: ");
        labeldrink.setBounds(20, 250, 150, 25);
        frame.add(labeldrink);
        
        JCheckBox cola = new JCheckBox("Cola - $2");
        cola.setBounds(20, 280, 150, 25);
        frame.add(cola);
        
        JCheckBox water = new JCheckBox("Water - $1");
        water.setBounds(20, 310, 150, 25);
        frame.add(water);
        
        JCheckBox ice = new JCheckBox("Add Ice(+$0.50)");
        ice.setBounds(20, 340, 150, 25);
        frame.add(ice);
        
        JLabel labeldessert = new JLabel("Choose a dessert: ");
        labeldessert.setBounds(20, 385, 150, 25);
        frame.add(labeldessert);
        
        JRadioButton radiocake = new JRadioButton("Cake - $4");
        radiocake.setBounds(20, 415, 150, 25);
        frame.add(radiocake);
        
        JRadioButton radioicecream = new JRadioButton("Ice cream - $3");
        radioicecream.setBounds(20, 445, 150, 25);
        frame.add(radioicecream);
        
        JCheckBox toppings = new JCheckBox("Extra Toppings (+$1)");
        toppings.setBounds(20, 475, 200, 25);
        frame.add(toppings);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radiocake);
        group.add(radioicecream);
        
        JTextArea area = new JTextArea();
        
        JScrollPane scrollpane = new JScrollPane(area); 
        scrollpane.setBounds(300, 100, 350, 400);      
        frame.add(scrollpane); 
       
        
        JLabel total = new JLabel("Total: ");
        total.setBounds(20, 520, 80, 25);
        frame.add(total);
        
        JLabel price = new JLabel();
        price.setBounds(20, 520, 80, 25);
        frame.add(price);
        
        JButton calculatePrice = new JButton("Calculate Price");
        calculatePrice.setBounds(300, 520, 140, 35);
        frame.add(calculatePrice);
        
        JButton resetorder = new JButton("Reset Order");
        resetorder.setBounds(470, 520, 140, 35);
        frame.add(resetorder);
        
         

        calculatePrice.addActionListener((e) -> {
        
            area.append(txtname.getText());
            area.append(txtphone.getText());
            
            int fee=0;
            
            if(mealsBox.getSelectedItem()=="Pasta - $12"){
            
             
                fee+=12*(Integer)spinner.getValue();
                
                area.append("Pasta - $12   ");
                
            }else if(mealsBox.getSelectedItem()=="Burger - $10"){
            
                fee+=10*(Integer)spinner.getValue();
                
                area.append("Burger - $10   ");
                
            }else if(mealsBox.getSelectedItem()=="Salad - $8"){
            
                fee+=8*(Integer)spinner.getValue();
                
                area.append("Salad - $8   ");
            }

            if(cola.isSelected()) {
                fee+=2;
            area.append("cola - $2   ");
            }
            if(water.isSelected()) {
            
                fee+=1;
            area.append("cola - $2   ");
            }
            if(ice.isSelected()) {
                
                fee+=0.5;
            area.append("adding ice - $0.5   ");  
            }
            
            if(radiocake.isSelected()) fee+=4;
            else if(radioicecream.isSelected()) fee+=3;
            
            if(toppings.isSelected()) fee+=1;
            
            area.append("Total: "+fee+"\n");
            
        });
        
        resetorder.addActionListener((e) -> {
            txtname.setText("");
            txtphone.setText("");
            mealsBox.setSelectedIndex(0);
            spinner.setValue(1);
            cheesebox.setSelected(false);
            cola.setSelected(false);
            water.setSelected(false);
            ice.setSelected(false);
            group.clearSelection();
            toppings.setSelected(false);
            area.setText("");
            price.setText("$0.00");
        });
        
    frame.setVisible(true);
    
    }
    
}
