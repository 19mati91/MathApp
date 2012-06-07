package se.goransson.saxtest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Bleh extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bleh frame = new Bleh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private SAXParser parser;
	MyDefaultHandler dh = new MyDefaultHandler();

	/**
	 * Create the frame.
	 */
	public Bleh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				SAXParserFactory factory = SAXParserFactory.newInstance();
				try {
					parser = factory.newSAXParser();
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				}

				try {
					parser.parse("people.xml", dh);
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});
		contentPane.add(btnNewButton, BorderLayout.NORTH);
	}

}
