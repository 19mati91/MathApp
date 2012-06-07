package com.MathIsFun;

import java.io.Serializable;
import java.util.ArrayList;

import android.widget.ImageView;

public class Quiz implements Serializable {

	/**
	 *
	 */
	ArrayList<Question> questions = new ArrayList<Question>();

	public Quiz() {
		// Constructor
	}

	/**
	 * A method for adding new questions to the array
	 */
	public void addQuestion(Question q) {
		questions.add(q);
		
	}

	/**
	 * A method for retrieving questions from the array
	 */
	public Question getQuestion(int i) {
		return questions.get(i);
	}

	
	
	/**
	 * A method for converting values within the array into strings
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for( Question q : questions){
			sb.append(q.toString()).append(" ");
		}

		return sb.toString();
	}

}
