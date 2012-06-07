package se.goransson.saxtest;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler extends DefaultHandler {
	boolean quizzes = false;
	boolean q1 = false;
	boolean q2 = false;
	boolean q3 = false;
	private Quiz myQuiz;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start doc");
		super.startDocument();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("Quizzes")) {
			quizzes = true;

			myQuiz = new Quiz();
		}

		if (qName.equalsIgnoreCase("q1")) {
			q1 = true;
		}
		
		if (qName.equalsIgnoreCase("q2")) {
			q2 = true;
		}
		
		if (qName.equalsIgnoreCase("q3")) {
			q3 = true;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equalsIgnoreCase("Quizzes")) {
			quizzes = false;

			System.out.println(myQuiz);
		}

		if (qName.equalsIgnoreCase("q1")) {
			q1 = false;
		}
		
		if (qName.equalsIgnoreCase("q2")) {
			q2 = false;
		}
		
		if (qName.equalsIgnoreCase("q3")) {
			q3 = false;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (q1) {
			myQuiz.setQ1(new String(ch, start, length));
		}
		
		if (q2) {
			myQuiz.setQ2(new String(ch, start, length));
		}
		
		if (q3) {
			myQuiz.setQ3(new String(ch, start, length));
		}
	}
	
	@Override
	public void endDocument() throws SAXException {
		// Här skickar vi listan till aktiviteten
		super.endDocument();
	}

}