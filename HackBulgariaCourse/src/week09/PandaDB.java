package week09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PandaDB {
	private Pattern pattern;
	private Matcher matcher;

	String name;
	String email;
	String gender;

	PandaDB(String n, String mail, String gen) {
		if (validateMail(mail)) {
			this.name = n;
			this.email = mail;
			this.gender = gen;
		}

		else {
			System.out.println("Not correct input data");
		}
	}

	public boolean validateMail(String checkedMail) {
		String EMAIL_PATTERN =

				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"

						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(checkedMail);

		return matcher.matches();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public boolean isMale(){
		if(gender.equals("male")){
			return true;
		}
		else return false;
	}
	public boolean isFemale(){
		if(gender.equals("female")){
			return true;
		}
		else return false;
	}
  public String toString(){
	  return getName()+" "+getEmail()+" "+getGender();
  }
	
}
