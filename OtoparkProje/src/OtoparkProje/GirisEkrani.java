package OtoparkProje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GirisEkrani extends JFrame {

	private JPanel contentPane;
	private JTextField isim;
	private JTextField plaka;
	public String sql_giris;
	public static String g_isim,g_plaka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisEkrani frame = new GirisEkrani();
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
	public GirisEkrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AKSU OTOPARKA HOŞGELDİNİZ");
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(42, 23, 457, 67);
		contentPane.add(lblNewLabel);
		
		JButton misafir = new JButton("Misafir Girişi");
		misafir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				misafirGiris msfr = new misafirGiris();
				msfr.setVisible(true);
				setVisible(false);
			}
		});
		misafir.setBackground(new Color(127, 255, 212));
		misafir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		misafir.setBounds(147, 116, 237, 51);
		contentPane.add(misafir);
		
		JLabel lblNewLabel_1 = new JLabel("ÜYE GİRİŞİ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(30, 190, 173, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("İsim :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(157, 266, 85, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Plaka No:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(157, 313, 85, 25);
		contentPane.add(lblNewLabel_3);
		
		isim = new JTextField();
		isim.setBounds(268, 266, 153, 25);
		contentPane.add(isim);
		isim.setColumns(10);
		
		plaka = new JTextField();
		plaka.setBounds(268, 313, 153, 24);
		contentPane.add(plaka);
		plaka.setColumns(10);
		
		JButton giris = new JButton("GİRİŞ");
		giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baglanti.baglan();
				
				g_isim=isim.getText();
				g_plaka=plaka.getText();
				
				sql_giris="SELECT count(mus_id) as giris FROM public.uye WHERE mus_isim='"+g_isim+"' and mus_plaka='"+g_plaka+"'";
				ResultSet rs = Baglanti.sorgu(sql_giris);
				
				try {
					while(rs.next()) {
						if(rs.getInt("giris")==1){
							harita hrt = new harita();
							hrt.setVisible(true);
							setVisible(false);
						}
						else {
							giris.setText("Hatalı Giris");
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			
			}
		});
		giris.setBackground(new Color(127, 255, 212));
		giris.setForeground(new Color(0, 0, 0));
		giris.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		giris.setBounds(414, 347, 85, 41);
		contentPane.add(giris);
		
		JButton kayitol = new JButton("KAYİT OL");
		kayitol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KayitOl kyt = new KayitOl();
				kyt.setVisible(true);
				setVisible(false);
			}
		});
		kayitol.setBackground(new Color(230, 230, 250));
		kayitol.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		kayitol.setBounds(147, 384, 102, 47);
		contentPane.add(kayitol);
		
		JButton admingiris = new JButton("ADMİN GİRİŞ");
		admingiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin adm = new admin();
				adm.setVisible(true);
				setVisible(false);
			}
		});
		admingiris.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		admingiris.setBackground(new Color(230, 230, 250));
		admingiris.setBounds(10, 384, 130, 47);
		contentPane.add(admingiris);
	}
}
