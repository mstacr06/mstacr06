package hesapmakinesi;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HesapMakinesi {
    
    public static void main(String[] args) {

    JFrame frame = new JFrame("HESAP MAKİNESİ");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLayout(null);
    frame.setVisible(true);
    
    frame.getContentPane().setBackground(new java.awt.Color(0, 128, 128));

    JLabel label1 = new JLabel("1.sayı");
    label1.setBounds(30, 30, 100, 25);
   
   
    JTextField txt1 = new JTextField("");
    txt1.setBounds(100, 30, 100, 25);
   
    
    JLabel label2 = new JLabel("2.sayi");
    label2.setBounds(30, 70, 100, 25);
    
    
    JTextField txt2 = new JTextField("");
    txt2.setBounds(100, 70, 100, 25);
   
    
    JButton topla = new JButton("+");
    topla.setBounds(20, 110, 50, 50);
   
    
    JButton cikart = new JButton("-");
    cikart.setBounds(70, 110, 50, 50);
    
    
    JButton carp = new JButton("x");
    carp.setBounds(120, 110, 50, 50);
  
    
    JButton bol = new JButton("÷");
    bol.setBounds(170, 110, 50, 50);
    
    
    JButton kuvvet = new JButton("^");
    kuvvet.setBounds(220, 110, 50, 50);
   
    
    JLabel sonuc = new JLabel("SONUÇ: ");
    sonuc.setBounds(20, 200, 200, 200);
   
    
    topla.addActionListener((e) -> {
    
        double a = Double.parseDouble(txt1.getText());
        double b = Double.parseDouble(txt2.getText());
        
        double sonucc = a+b;
        
        sonuc.setText("SONUÇ: "+sonucc);
        
    });
    
    
    cikart.addActionListener((e) -> {
    
        double a = Double.parseDouble(txt1.getText());
        double b = Double.parseDouble(txt2.getText());
        
        double sonucc= a-b;
        
        sonuc.setText("SONUÇ: "+ sonucc);
    
    });
    
    
    carp.addActionListener((e) -> {
    
        double a = Double.parseDouble(txt1.getText());
        double b = Double.parseDouble(txt2.getText());
        
        double sonucc = a*b;
        
        sonuc.setText("SONUÇ: " + sonucc);
    
    });
    
    bol.addActionListener((e) -> {
    
        double a = Double.parseDouble(txt1.getText());
        double b = Double.parseDouble(txt2.getText());
        
        if(b!=0){
        
            double sonucc = a/b;
            sonuc.setText("SONUÇ: " + sonucc);
            
        }else{
            
            sonuc.setText("Payda sifir olamaz!!! " );
            
        }
        frame.add(label1);
    });
    
    kuvvet.addActionListener((e) -> {
        
        double a = Double.parseDouble(txt1.getText());
        double b = Double.parseDouble(txt2.getText());
        double sonucc =1;
        
        if(b>=1){
            for (int i = 0; i < b; i++) {
                
                sonucc = sonucc*a;
                
            }
            sonuc.setText("SONUÇ: "+ sonucc);
        }else {
        
        
            sonuc.setText("ÇOK YAKINDA YAPACAĞIZ...");
            
        }
    
    
    
    });
     frame.add(txt1); 
     frame.add(label1);
     frame.add(label2);
     frame.add(txt2); 
     frame.add(topla);
     frame.add(cikart); 
     frame.add(carp);
     frame.add(bol); 
     frame.add(kuvvet);
     frame.add(sonuc);
    
    
    
            
    
    
        
    
    }
    
}
