import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField cadena;
	private JTextField Base64;
	private JTextField AES;
	private JTextField DecodAES;
	private JTextField DecodB64;
	private JTextField Baseto64AES;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cifrador");
		lblNewLabel.setBounds(47, 6, 440, 19);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadena a cifrar:");
		lblNewLabel_1.setBounds(15, 35, 98, 16);
		contentPane.add(lblNewLabel_1);
		
		cadena = new JTextField();
		cadena.setBounds(160, 30, 467, 26);
		contentPane.add(cadena);
		cadena.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Base 64:");
		lblNewLabel_2.setBounds(15, 85, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cadena a cifrar en AES:");
		lblNewLabel_2_1.setBounds(15, 123, 144, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("AES:");
		lblNewLabel_2_1_1.setBounds(15, 166, 27, 16);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Descifrado AES:");
		lblNewLabel_2_1_1_1.setBounds(15, 207, 99, 16);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Decodificado Base 64: ");
		lblNewLabel_2_2.setBounds(15, 250, 144, 16);
		contentPane.add(lblNewLabel_2_2);
		
		JButton btnNewButton = new JButton("Cifrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String CadenaOriginal = cadena.getText(); //Se obtiene la cadena a cifrar
				
				try { 
					Cifrados cifrados = aes.ReturnCifrado(CadenaOriginal); //Se cifra la cadena llamanda al método ReturnCifrado de la clase aes
																			//Se almcena en la variable cifrados.
					
					Base64.setText(cifrados.Base64);  //Se plasman los resultados en los testbox
					Baseto64AES.setText(cifrados.Base64toAES);
					AES.setText(cifrados.AES);
					DecodAES.setText(cifrados.DescAES);
					DecodB64.setText(cifrados.DecodBase64);
					
				} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException
						| IllegalBlockSizeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(17, 320, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cadena.setText(""); //Se limpia todos los campos
				Base64.setText("");
				AES.setText("");
				DecodAES.setText("");
				DecodB64.setText("");
				Baseto64AES.setText("");
			}
		});
		btnLimpiar.setBounds(146, 320, 117, 29);
		contentPane.add(btnLimpiar);
		
		Base64 = new JTextField();
		Base64.setColumns(10);
		Base64.setBounds(160, 80, 467, 26);
		contentPane.add(Base64);
		
		AES = new JTextField();
		AES.setColumns(10);
		AES.setBounds(160, 161, 467, 26);
		contentPane.add(AES);
		
		DecodAES = new JTextField();
		DecodAES.setColumns(10);
		DecodAES.setBounds(160, 202, 467, 26);
		contentPane.add(DecodAES);
		
		DecodB64 = new JTextField();
		DecodB64.setColumns(10);
		DecodB64.setBounds(160, 245, 467, 26);
		contentPane.add(DecodB64);
		
		Baseto64AES = new JTextField();
		Baseto64AES.setColumns(10);
		Baseto64AES.setBounds(160, 118, 467, 26);
		contentPane.add(Baseto64AES);
	}
}
