package Yeni;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TGraf extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_sayi;
	
	static JTextField[] txtalan;
	static JButton[] lbl;
	
	static int sayi=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TGraf frame = new TGraf();
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
	public TGraf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_sayi = new JTextField();
		txt_sayi.setBounds(165, 13, 55, 22);
		contentPane.add(txt_sayi);
		txt_sayi.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Dugum sayisini giriniz");
		lblNewLabel.setBounds(30, 16, 123, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("G\u00F6nder");		
		btnNewButton.setBounds(242, 12, 97, 25);
		contentPane.add(btnNewButton);
		
		
		
				
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayi = Integer.parseInt(txt_sayi.getText());
				txtalan = new JTextField[sayi];
				lbl = new JButton[sayi];
				
				int i;
				
				for(i=0;i<sayi;i++) {
					
					lbl[i] = new JButton((i+1)+". node");
					lbl[i].setBounds(30, 50 + (i*30), 60, 22);
					contentPane.add(lbl[i]);
					contentPane.repaint();
					
				}
				
				
				btnNewButton.setEnabled(false);
				
			}
		});
		
		
	
	}

}
