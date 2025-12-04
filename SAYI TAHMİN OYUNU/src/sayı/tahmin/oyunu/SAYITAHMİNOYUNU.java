package sayı.tahmin.oyunu;

import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class SAYITAHMİNOYUNU {
   
    public static void main(String[] args) {


        JFrame frame = new JFrame("SAYI TAHMIN OYUNU");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setVisible(true);
    
        JLabel label = new JLabel("1-100 arasi tahmin et");
        label.setBounds(100, 30, 200, 25);
        frame.add(label);
        
        JSlider slide = new JSlider(0,100,50);
        slide.setBounds(50, 70, 300, 50);
        slide.setMajorTickSpacing(10);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);
        frame.add(slide);
        
        JButton btn = new JButton("tahmin");
        btn.setBounds(130, 140, 120, 30);
        frame.add(btn);
        
        JLabel lblDeger = new JLabel("Seçilen sayı: 50");
        lblDeger.setBounds(130, 250, 200, 25);
        lblDeger.setForeground(Color.BLACK);
        frame.add(lblDeger);
        
        slide.addChangeListener((e) -> {
         
            int deger = slide.getValue();
            lblDeger.setText("Seçilen sayı: " + deger);
        
        });
        
        
        
        JLabel labelsonuc = new JLabel("Sonuç: ");
        labelsonuc.setBounds(100, 190, 250, 25);
        frame.add(labelsonuc);
        
        
        
        Random random = new Random();
        int gizliSayi = random.nextInt(100)+1;
        
        
        btn.addActionListener((e) -> {
            
            int tahmin = slide.getValue();
            
            if(tahmin == gizliSayi){
                
                labelsonuc.setText("BRAVO TEBRIKLER DOGRU BULDUNUZ!!!   sayi: "+slide.getValue());
                
                
            }else if(tahmin>gizliSayi){
            
                labelsonuc.setText("DAHA KUCUK BIR SAYI DENE   sayi: "+slide.getValue());
                
            }else {
            
                labelsonuc.setText("DAHA BUYUK BIR SAYI DENE   sayi: "+slide.getValue());
            
            }
            
        });
        
        
        

    }
    
    

    
}
