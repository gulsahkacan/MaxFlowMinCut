package Yeni;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Table extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int[][] matris;
	public int  sat,sut;
	
	int sourceVertex,destinationVertex;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField txt_row;
	private JTextField txt_col;
	
	DefaultTableModel modelim = new DefaultTableModel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table();
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
	public Table() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 45, 329, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.setBounds(391, 212, 138, 79);
		scrollPane.setViewportView(table);
		
		txt_row = new JTextField();
		txt_row.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_row.setText("1");
		txt_row.setBounds(61, 13, 49, 22);
		contentPane.add(txt_row);
		txt_row.setColumns(10);
		
		JLabel lblSatr = new JLabel("Sat\u0131r");
		lblSatr.setBounds(12, 16, 56, 16);
		contentPane.add(lblSatr);
		
		JLabel lblStun = new JLabel("S\u00FCtun");
		lblStun.setBounds(122, 16, 56, 16);
		contentPane.add(lblStun);
		
		txt_col = new JTextField();
		txt_col.setText("1");
		txt_col.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_col.setColumns(10);
		txt_col.setBounds(175, 10, 49, 22);
		contentPane.add(txt_col);
				
		JButton btnNewButton = new JButton("Olu\u015Ftur");
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sat = Integer.parseInt(txt_row.getText());
				sut  = Integer.parseInt(txt_col.getText());
				
				modelim.setRowCount(sat);
				modelim.setColumnCount(sut);
				
				table.setModel(modelim);
				
							
			}
		});
		

		btnNewButton.setBounds(236, 12, 97, 25);
		contentPane.add(btnNewButton);
		//final String deneme = "";
		
		JButton btnAta = new JButton("ATA");
		btnAta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int gulsah = modelim.getColumnCount();
				final int[][] matris = new int[gulsah][gulsah];
				//System.out.println("Sat : " + gulsah);
				int ab = 0;
				
				//Graf Matrisi
				for(int i = sourceVertex; i < gulsah; i++) {//For each row
			        for(int j = destinationVertex; j < gulsah; j++) {//For each column in that row
			        		ab = Integer.parseInt((String) table.getModel().getValueAt(i,j));
			        		matris[i][j]=ab;
			        	System.out.print(matris[i][j] + " "); 
			        }//For loop inner
			        System.out.print("\n");
			    }//For loop outer
			/*	
				int source;
				int sink;
				int maxFlow;

				
				Scanner scanner = new Scanner(System.in);
				System.out.println("Baslangic dugumunu giriniz");
				source = scanner.nextInt();
				System.out.println("Cikis dugumunu giriniz");
				sink = scanner.nextInt();
			*/	
				//MaxFlowMinCut fonksiyon=new MaxFlowMinCut(gulsah);
						
				//System.out.println(fonksiyon.maxFlowMinCut(matris, source, sink));					
				
				
			}
		});
		btnAta.setBounds(139, 324, 85, 21);
		contentPane.add(btnAta);

	}
}

