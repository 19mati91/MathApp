package se.goransson.saxtest;

public class Quiz {
	String q1;
	String q2;
	String q3;
	
	public Quiz(String q1, String q2, String q3){
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
	}
	
	public Quiz(){
		//Constructor
	}
	
	public void setQ1(String q1){
		this.q1 = q1;
	}
	
	public void setQ2(String q2){
		this.q2 = q2;
	}
	
	public void setQ3(String q3){
		this.q3 = q3;
	}

}
