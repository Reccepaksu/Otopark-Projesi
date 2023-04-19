package OtoparkProje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class admin extends JFrame {

	private JPanel contentPane;
	private JTextField admin_isim;
	private JTextField admin_sifre;
	public String ad_ad,ad_sifre;
	public String sql_admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 337);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMİN GİRİŞ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(42, 11, 243, 72);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ADMİN İSİM : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(23, 106, 112, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADMİN SİFRE : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(23, 176, 112, 39);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("GİRİŞ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baglanti.baglan();
				
				ad_ad=admin_isim.getText();
				ad_sifre=admin_sifre.getText();
				
				sql_admin="SELECT count(admin_id) as giris FROM public.admin WHERE admin_isim='"+ad_ad+"' and admin_sifre='"+ad_sifre+"'";
				ResultSet rs = Baglanti.sorgu(sql_admin);
				
				try {
					while(rs.next()) {
						if(rs.getInt("giris")==1){
							JOptionPane.showInternalMessageDialog(null,"Sayin : "+ad_ad+"  hoşgeldin...");
							adminHarita adhrt = new adminHarita();
							adhrt.setVisible(true);
							setVisible(false);
						}
						else {
							btnNewButton.setText("Hatalı Giris");
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(new Color(173, 255, 47));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(217, 248, 104, 39);
		contentPane.add(btnNewButton);
		
		admin_isim = new JTextField();
		admin_isim.setBounds(143, 115, 178, 20);
		contentPane.add(admin_isim);
		admin_isim.setColumns(10);
		
		admin_sifre = new JTextField();
		admin_sifre.setColumns(10);
		admin_sifre.setBounds(145, 185, 178, 20);
		contentPane.add(admin_sifre);
	}

}
