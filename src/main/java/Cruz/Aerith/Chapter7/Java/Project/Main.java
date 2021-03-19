package Cruz.Aerith.Chapter7.Java.Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 58, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 20, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numerator");
		lblNewLabel.setBounds(10, 24, 87, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Denominator");
		lblNewLabel_1.setBounds(10, 61, 83, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Result:");
		lblNewLabel_2.setBounds(260, 23, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel resultLabel = new JLabel(" ");
		resultLabel.setBounds(315, 23, 45, 13);
		frame.getContentPane().add(resultLabel);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double numerator = Double.parseDouble(textField_1.getText());
				double denominator = Double.parseDouble(textField_2.getText());
				
				SimpleMath math = new SimpleMath();
				
				double result = math.divide(numerator, denominator);
				
				try {
					resultLabel.setText(String.valueOf(result));
				} catch (ArithmeticException f) {
					resultLabel.setText("Cannot divide by 0");
				}
			 
			}
		});
		btnNewButton.setBounds(10, 97, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
}
