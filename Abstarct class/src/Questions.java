import java.util.Scanner;

public abstract class Questions  {
	void askQuestion(){
		
		System.out.println("Question");
		Scanner n=new Scanner(System.in);
		String answer=n.nextLine();
		saveAnswer(answer);
		
		
	}
	abstract void saveAnswer(String answer);
	abstract boolean checkQuestion();
}
