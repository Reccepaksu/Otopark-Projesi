package OtoparkProje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class KayitOl extends JFrame {

	private JPanel contentPane;
	private JTextField adText;
	private JTextField soyadText;
	private JTextField telText;
	private JTextField plakaText;
	private JButton btnNewButton;
	public static String sql_kayit;
	public static String kayitAd,kayitSoyad,kayitPlaka;
	public static int kayitTel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitOl frame = new KayitOl();
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
	public KayitOl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KAYİT OL ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 11, 315, 66);
		contentPane.add(lblNewLabel);
		
		JLabel adLabel = new JLabel("AD : ");
		adLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		adLabel.setBounds(30, 123, 104, 34);
		contentPane.add(adLabel);
		
		JLabel soyadLabel = new JLabel("SOYAD : ");
		soyadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		soyadLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		soyadLabel.setBounds(30, 179, 104, 34);
		contentPane.add(soyadLabel);
		
		JLabel telefonLabel = new JLabel("TELEFON :");
		telefonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		telefonLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		telefonLabel.setBounds(30, 241, 104, 34);
		contentPane.add(telefonLabel);
		
		JLabel plakaLabel = new JLabel("PLAKA : ");
		plakaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		plakaLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		plakaLabel.setBounds(30, 303, 104, 34);
		contentPane.add(plakaLabel);
		
		adText = new JTextField();
		adText.setBounds(144, 127, 159, 28);
		contentPane.add(adText);
		adText.setColumns(10);
		
		soyadText = new JTextField();
		soyadText.setColumns(10);
		soyadText.setBounds(144, 183, 159, 28);
		contentPane.add(soyadText);
		
		telText = new JTextField();
		telText.setToolTipText("");
		telText.setColumns(10);
		telText.setBounds(144, 245, 159, 28);
		
		contentPane.add(telText);
		
		plakaText = new JTextField();
		plakaText.setColumns(10);
		plakaText.setBounds(144, 307, 159, 28);
		contentPane.add(plakaText);
		
		btnNewButton = new JButton("TAMAM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kayitAd=adText.getText();
				kayitSoyad=soyadText.getText();
				String tel =telText.getText();
				kayitTel=Integer.parseInt(tel);
				kayitPlaka=plakaText.getText();
				
				sql_kayit="INSERT INTO public.uye(mus_isim,mus_soyisim,mus_telefon,mus_plaka)VALUES ('"+kayitAd+"','"+kayitSoyad+"',"+kayitTel+",'"+kayitPlaka+"')";
				System.out.println(sql_kayit);
				Baglanti.baglan();
				Baglanti.sorgu(sql_kayit);
				
				JOptionPane.showInternalMessageDialog(null,"Sayin : "+kayitAd+" "+kayitSoyad+" aramıza hoşgeldiniz...");
				
				GirisEkrani grs = new GirisEkrani();
				grs.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(207, 367, 128, 44);
		contentPane.add(btnNewButton);
	}
}
