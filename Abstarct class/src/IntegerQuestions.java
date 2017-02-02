
public class IntegerQuestions extends Questions {
	int correctAnswer;
	int currentAnswer;
	 
	IntegerQuestions(int correctAnswer){
	super();
	this.correctAnswer=correctAnswer;
	}

	@Override
	void saveAnswer(String answer) {
		
		int currentAnswer=Integer.parseInt(answer);
		
	}

	@Override
	boolean checkQuestion() {
		if(currentAnswer!=correctAnswer){
	
		return false;}
	else
	return true;
		

	}
	public int getCorrectAnswer() {
		return correctAnswer;
		}

		public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
		}

		public int getCurrentAnswer() {
		return currentAnswer;
		}

		public void setCurrentAnswer(int currentAnswer) {
		this.currentAnswer = currentAnswer;
		}
	


}