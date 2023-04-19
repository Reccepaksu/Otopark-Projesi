package OtoparkProje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class misafirGiris extends JFrame {

	private JPanel contentPane;
	private JTextField misaifr_ad;
	private JTextField misafir_plaka;
	public String mis_ad,mis_plaka;
	public String sql_misafir_ekle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					misafirGiris frame = new misafirGiris();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public misafirGiris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adınız : ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(32, 89, 116, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Plakanız :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(32, 161, 116, 34);
		contentPane.add(lblNewLabel_1);
		
		misaifr_ad = new JTextField();
		misaifr_ad.setBounds(190, 97, 181, 20);
		contentPane.add(misaifr_ad);
		misaifr_ad.setColumns(10);
		
		misafir_plaka = new JTextField();
		misafir_plaka.setBounds(190, 169, 181, 20);
		contentPane.add(misafir_plaka);
		misafir_plaka.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("MİSAFİR GİRİŞ\r\n");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(91, 11, 232, 43);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("GİRİŞ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mis_ad=misaifr_ad.getText();
				mis_plaka=misafir_plaka.getText();
				sql_misafir_ekle="INSERT INTO public.musteri(uye_isim,uye_plaka) VALUES('"+mis_ad+"','"+mis_plaka+"');";
				Baglanti.baglan();
				Baglanti.sorgu(sql_misafir_ekle);
				
				harita hrt = new harita();
				hrt.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setBackground(new Color(173, 216, 230));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBounds(325, 216, 99, 34);
		contentPane.add(btnNewButton);
	}
}
