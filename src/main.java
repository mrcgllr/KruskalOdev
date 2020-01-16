import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.awt.Canvas;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField txtRasgele;
	ArrayList<Edge> mst;
	Graph graph;
	ArrayList<JLabel> jLabel;
	ArrayList<Vertex> vertexList;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelEkleme = new JPanel();
		panelEkleme.setToolTipText("Grup");
		panelEkleme.setBounds(10, 11, 111, 162);
		contentPane.add(panelEkleme);
		panelEkleme.setLayout(null);
		
		txtRasgele = new JTextField();
		txtRasgele.setBounds(10, 21, 86, 20);
		panelEkleme.add(txtRasgele);
		txtRasgele.setColumns(10);
		
		JLabel lblRastgeleNoktaEkle = new JLabel("Rastgele Nokta Ekle");
		lblRastgeleNoktaEkle.setBackground(Color.RED);
		lblRastgeleNoktaEkle.setForeground(Color.BLACK);
		lblRastgeleNoktaEkle.setBounds(10, 0, 95, 14);
		panelEkleme.add(lblRastgeleNoktaEkle);
		
		JButton btnEkle = new JButton("Ekle");
		
		btnEkle.setBounds(10, 47, 89, 23);
		panelEkleme.add(btnEkle);
		
		JLabel lblKmelemeAdedi = new JLabel("K\u00FCmeleme Adedi");
		lblKmelemeAdedi.setBounds(10, 81, 86, 14);
		panelEkleme.add(lblKmelemeAdedi);
		
		JButton btnCalistir = new JButton("\u00C7al\u0131\u015Ft\u0131r");
		btnCalistir.setBounds(7, 130, 89, 23);
		panelEkleme.add(btnCalistir);
		
		JSpinner spinCalistir = new JSpinner();
		spinCalistir.setBounds(10, 106, 86, 20);
		panelEkleme.add(spinCalistir);
		
		Panel panelIstatistik = new Panel();
		panelIstatistik.setBounds(10, 187, 111, 201);
		contentPane.add(panelIstatistik);
		panelIstatistik.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0130statistikler");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 101, 14);
		panelIstatistik.add(lblNewLabel);
		
		JPanel panelNokta = new JPanel();
		panelNokta.setBounds(131, 11, 540, 380);
		contentPane.add(panelNokta);
		panelNokta.setLayout(null);
		
	
		btnCalistir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jLabel.clear();
				Kruskal kruskal=new Kruskal();
				mst=kruskal.getMST(graph,vertexList.get(1));
				
				Clustering cluster=new Clustering(mst);
				
				cluster.grupOlustur(graph.getRandomVertex(),(int)spinCalistir.getValue());
				
				jLabel = cluster.noktaRenklendir(vertexList);
				for(int i =0;i<jLabel.size();i++) {
					panelNokta.add(jLabel.get(i));
				}
				
				
				
			}
		});
		btnEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jLabel = new ArrayList<JLabel>();
				Random rnd = new Random();
				int sayi=0;
				if(txtRasgele.getText().equals(""))
					JOptionPane.showMessageDialog(null,"Sayý Girilmedi");
				else 
					sayi= Integer.valueOf(txtRasgele.getText().toString());
				 graph = new Graph();
				for(int i = 0;i<sayi;i++) {
					int x,y;
					x=rnd.nextInt()*540+1;
					y=rnd.nextInt()*380+1;
					graph.vertexEkle(i, x, y);
					vertexList.add(graph.getVertexById(i));
					jLabel.add(new JLabel("."));
					jLabel.get(i).setBounds(x, y, 100, 100);
					jLabel.get(i).setFont(new Font("Tahoma",Font.BOLD,30));
					panelNokta.add(jLabel.get(i));			
				}
				graph.generateEdges();
				
				
			}
		});
	}
}
