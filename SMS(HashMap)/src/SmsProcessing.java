import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsProcessing {
	private Matcher matcher;
	private Pattern pattern;
	private static final String NUMBER_PATTERN ="[^a-zA-Z]+[0-9]{12}";
	private static final String TEXT_PATTERN ="[^a-zA-Z]+[0-9]{160}";
	
private void processAllSms(){
	BufferedReader br=null;
	String data;
	Queue<String> sms=new LinkedList<String>();
	try{
		br=new BufferedReader(new FileReader("D://texx.txt"));
		while(br.read()!=-1){
		data=br.readLine();
		sms.offer(data);
		
		}
		System.out.println(sms.peek());
		br.close();
	}
	catch(FileNotFoundException e){
		System.out.println("file not found");
	}
	catch(IOException e){
		
	}
	finally{
		
	}
}

private boolean validateSms(String checkedNumber,String checkedText){
	pattern = Pattern.compile(NUMBER_PATTERN);
	matcher=pattern.matcher(checkedNumber);
	pattern = Pattern.compile(TEXT_PATTERN);
	matcher=pattern.matcher(checkedText);
	return matcher.matches();
	}

}
