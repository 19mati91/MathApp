package com.MathIsFun;

import java.io.Serializable;


public class Question implements Serializable {

	String question;
	String imgUrl;
	Answer[] answers;
	String correctAnswer;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for( Answer a : answers)
			sb.append(a.text);
		
		return " " + question + " " + sb.toString();
	}
}
