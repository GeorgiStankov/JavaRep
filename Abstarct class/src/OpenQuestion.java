
public class OpenQuestion extends Questions{
	String currentAnswer;
	String correctAnswer;

	OpenQuestion(String correctAnswer){
		super();
		this.correctAnswer=correctAnswer;
		
	}
	@Override
	void saveAnswer(String answer) {
		String currentAnswer=answer;
		if(currentAnswer.length()>=255){
			System.out.println("Eror,please enter less than 255 characters");
		}
	}

	@Override
	boolean checkQuestion() {
		return correctAnswer.equals(currentAnswer);		
	}

	public String getCurrentAnswer(){
		return currentAnswer;
	}
	public String getCorrectAnswer(){
		return correctAnswer;
	}
	public void setCurrrentAnswer(String currentAnswer){
		this.currentAnswer=currentAnswer;
	}
	public void setCorrectAnswer(String CorrectAnswer){
		this.correctAnswer=correctAnswer;
	}

}
