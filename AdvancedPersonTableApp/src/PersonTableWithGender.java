import javax.swing.*; // Swing kütüphanesi: JFrame, JButton, JTextField, JTable vb. UI bileşenleri için
import javax.swing.table.DefaultTableModel; // JTable'ın veri modelini oluşturmak için
import java.awt.event.*; // ActionListener gibi olay sınıflarını kullanmak için

public class PersonTableWithGender { // Ana sınıf: programın başlangıç noktası
    public static void main(String[] args) { // Programın çalıştığı main metodu
        
        JFrame frame = new JFrame("Person Table with Gender"); // Ana pencereyi oluşturur ve başlık verir
        frame.setSize(500, 400); // Pencere boyutunu ayarlar (genişlik:500, yükseklik:400)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Kapatılınca programın sonlanmasını sağlar
        frame.setLayout(null); // Layout yöneticisini kapatır → bileşenleri elle konumlandıracağız

        // --- JTable ve modeli ---
        DefaultTableModel model = new DefaultTableModel( // Tablo verisini tutan model
            new String[]{"First Name", "Last Name", "Gender"}, 0 // Sütun isimleri: Ad, Soyad, Cinsiyet
        );
        JTable table = new JTable(model); // Modeli tabloya bağlar
        JScrollPane scrollPane = new JScrollPane(table); // Tabloyu kaydırılabilir yapar
        scrollPane.setBounds(20, 20, 450, 150); // ScrollPane’in konumunu ve boyutunu ayarlar

        // --- Metin kutuları ---
        JTextField firstNameField = new JTextField(); // Ad girişi için metin kutusu
        firstNameField.setBounds(20, 180, 150, 30); // x=20, y=180 konumuna 150x30 boyutunda yerleştir

        JTextField lastNameField = new JTextField(); // Soyad girişi için metin kutusu
        lastNameField.setBounds(180, 180, 150, 30); // x=180, y=180 konumunda

        // --- RadioButton (Cinsiyet seçimi) ---
        JRadioButton maleButton = new JRadioButton("Male"); // Erkek seçeneği
        maleButton.setBounds(340, 180, 80, 30); // Konum ve boyut

        JRadioButton femaleButton = new JRadioButton("Female"); // Kadın seçeneği
        femaleButton.setBounds(340, 210, 80, 30); // Konum ve boyut

        // --- ButtonGroup ---
        ButtonGroup genderGroup = new ButtonGroup(); // Aynı anda sadece bir radio seçilsin diye grup oluşturur
        genderGroup.add(maleButton); // Male’i gruba ekle
        genderGroup.add(femaleButton); // Female’i gruba ekle

        // --- Ekleme butonu ---
        JButton addButton = new JButton("Add Person"); // Yeni kişi eklemek için buton
        addButton.setBounds(20, 250, 150, 30); // Konum ve boyut

        // --- Butona tıklanınca yapılacak işlemler ---
        addButton.addActionListener(new ActionListener() { // Olay dinleyicisi ekleniyor
            @Override
            public void actionPerformed(ActionEvent e) { // Butona tıklanınca bu metod çalışır
                String firstName = firstNameField.getText(); // Ad kutusundaki yazıyı alır
                String lastName = lastNameField.getText(); // Soyad kutusundaki yazıyı alır
                String gender; // Cinsiyet bilgisini tutmak için değişken

                if(firstName.isEmpty()){
                
                    JOptionPane.showMessageDialog(frame, "please enter the name");
                    return;
                }else if (lastName.isEmpty()){
                
                    JOptionPane.showMessageDialog(frame, "please enter the last name!");
                    return;
                }
                
                if (maleButton.isSelected()) { // Eğer erkek seçiliyse
                    gender = "Male"; // gender değişkenine "Male" yaz
                } else if (femaleButton.isSelected()) { // Eğer kadın seçiliyse
                    gender = "Female"; // gender değişkenine "Female" yaz
                } else { // Hiçbiri seçilmediyse
                    JOptionPane.showMessageDialog(frame, "Please select a gender."); // Uyarı mesajı göster
                    return; // Metodu bitir (ekleme yapılmasın)
                }

                // --- Veriyi tabloya ekleme ---
                model.addRow(new Object[]{firstName, lastName, gender}); // Girilen verileri tabloya yeni satır olarak ekler

                // --- Alanları temizleme ---
                firstNameField.setText(""); // Ad kutusunu temizler
                lastNameField.setText(""); // Soyad kutusunu temizler
                genderGroup.clearSelection(); // RadioButton’ların seçimini sıfırlar
            }
        });

        // --- Bileşenleri frame’e ekleme ---
        frame.add(scrollPane); // Tabloyu ekler
        frame.add(firstNameField); // Ad kutusunu ekler
        frame.add(lastNameField); // Soyad kutusunu ekler
        frame.add(maleButton); // Erkek radio butonunu ekler
        frame.add(femaleButton); // Kadın radio butonunu ekler
        frame.add(addButton); // Ekle butonunu ekler

        frame.setVisible(true); // Pencereyi görünür yapar
    }
}
