package com.MathIsFun;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler extends DefaultHandler {
	boolean quiz = false;
	boolean Q = false;
	boolean img = false;
	boolean question = false;
	private boolean answers = false;
	boolean answer = false;
	
	private Quiz currentQuiz;
	private Question currentQuestion;
	private Answer[] allAnswers;
	private int answerIndex;
	private boolean correctanswer;
	
	
	
	@Override
	public void startDocument() throws SAXException {
		
		super.startDocument();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		if (localName.equalsIgnoreCase("Quiz")) {
			quiz = true;
			
			currentQuiz = new Quiz();
			
		}

		if (localName.equalsIgnoreCase("Q")) {
			Q = true;
			
			currentQuestion = new Question();

		}
		
		if( localName.equalsIgnoreCase("img")){
			img = true;
			
			currentQuestion.imgUrl = attributes.getValue("src");
		}
		
		if(localName.equalsIgnoreCase("question")){
			question = true;
			currentQuestion.question = attributes.getValue("text");
		}
		
		if(localName.equalsIgnoreCase("answers")){
			answers = true;
			
			allAnswers = new Answer[4];
			answerIndex = 0;
		}
		if(localName.equalsIgnoreCase("answer")){
			answer = true;
			
			allAnswers[answerIndex] = new Answer();
			
			allAnswers[answerIndex].text = attributes.getValue("text");
			allAnswers[answerIndex].correct = Boolean.getBoolean(attributes.getValue("correct"));

			answerIndex++;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (localName.equalsIgnoreCase("Quiz")) {
			quiz = false;
		}

		if (localName.equalsIgnoreCase("Q")) {
			Q = false;
			
			currentQuiz.addQuestion(currentQuestion);
		}
		if (localName.equalsIgnoreCase("question")){
			question = false;
		}
		if(localName.equalsIgnoreCase("answers")){
			answers = false;
			
			currentQuestion.answers = allAnswers;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {					
	}
	
	@Override
	public void endDocument() throws SAXException {
		// Här skickar vi listan till aktiviteten
		super.endDocument();
	}

	public Quiz getQuiz() {
		// TODO Auto-generated method stub
		return currentQuiz;
	}
	
	

}
