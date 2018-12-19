import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
public class JavaGUI {

	private JFrame frame;
	public Client client;
	private static final String FILENAME="Lista.txt";
	private static final String FILENAME1="ListaIesire.txt";
	private JTextField text_nr;
	private JTextField text_nume;
	private JTextField textIndex;
	private JTextField texIndex_ID;
	private JTextField textIndex_Nume;
	private JTextField textIndexSters;
	private JTextField text_author;
	private JTextField textIndex_Author;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaGUI window = new JavaGUI();
					window.client.addFromFile(FILENAME);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		client = new Client();

		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 689, 833);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 127, 343, 93);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnLoad = new JButton("Refres");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel DLM = new DefaultListModel();
				int i=0;
				for(Book b:client.lista)  {
					DLM.addElement(i+". "+b.toString());
					i++;
					}
				list.setModel(DLM);
			}
		});
		btnLoad.setBounds(10, 11, 91, 23);
		frame.getContentPane().add(btnLoad);
		
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numar= Integer.parseInt(text_nr.getText());
				client.lista.add(new Book(numar,text_nr.getText(),text_author.getText()));
				
			}
		});
		btnAdauga.setBounds(353, 126, 91, 23);
		frame.getContentPane().add(btnAdauga);
		
		text_nr = new JTextField();
		text_nr.setBounds(574, 127, 86, 20);
		frame.getContentPane().add(text_nr);
		text_nr.setColumns(10);
		
		text_nume = new JTextField();
		text_nume.setBounds(574, 170, 86, 20);
		frame.getContentPane().add(text_nume);
		text_nume.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(486, 130, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNumele = new JLabel("Numele");
		lblNumele.setBounds(486, 173, 46, 14);
		frame.getContentPane().add(lblNumele);
		
		JButton btnAdaugacuintex = new JButton("AdaugaCuIndex");
		btnAdaugacuintex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int index= Integer.parseInt(textIndex.getText());
				int index_id =Integer.parseInt(texIndex_ID.getText());
				client.lista.add(index, new Book(index_id,textIndex_Nume.getText(),textIndex_Author.getText()));
			}
		});
		btnAdaugacuintex.setBounds(10, 297, 145, 23);
		frame.getContentPane().add(btnAdaugacuintex);
		
		textIndex = new JTextField();
		textIndex.setBounds(257, 298, 86, 20);
		frame.getContentPane().add(textIndex);
		textIndex.setColumns(10);
		
		JLabel lblIndex = new JLabel("Index");
		lblIndex.setBounds(165, 301, 46, 14);
		frame.getContentPane().add(lblIndex);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(165, 346, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nume");
		lblNewLabel_1.setBounds(459, 301, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		texIndex_ID = new JTextField();
		texIndex_ID.setBounds(257, 343, 86, 20);
		frame.getContentPane().add(texIndex_ID);
		texIndex_ID.setColumns(10);
		
		textIndex_Nume = new JTextField();
		textIndex_Nume.setBounds(574, 298, 86, 20);
		frame.getContentPane().add(textIndex_Nume);
		textIndex_Nume.setColumns(10);
		
		JButton btnStergere = new JButton("Stergere");
		btnStergere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index_de_sters=Integer.parseInt(textIndexSters.getText());
				client.lista.remove(index_de_sters);
			}
		});
		btnStergere.setBounds(10, 433, 91, 23);
		frame.getContentPane().add(btnStergere);
		
		textIndexSters = new JTextField();
		textIndexSters.setBounds(257, 434, 86, 20);
		frame.getContentPane().add(textIndexSters);
		textIndexSters.setColumns(10);
		
		JLabel lblIndex_1 = new JLabel("Index");
		lblIndex_1.setBounds(165, 437, 46, 14);
		frame.getContentPane().add(lblIndex_1);
		
		text_author = new JTextField();
		text_author.setBounds(574, 200, 86, 20);
		frame.getContentPane().add(text_author);
		text_author.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(486, 206, 46, 14);
		frame.getContentPane().add(lblAutor);
		
		textIndex_Author = new JTextField();
		textIndex_Author.setBounds(574, 343, 86, 20);
		frame.getContentPane().add(textIndex_Author);
		textIndex_Author.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(459, 346, 46, 22);
		frame.getContentPane().add(lblAuthor);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				client.writeFile(FILENAME1);
			}
		});
		btnSave.setBounds(10, 521, 91, 23);
		frame.getContentPane().add(btnSave);
	}
}
