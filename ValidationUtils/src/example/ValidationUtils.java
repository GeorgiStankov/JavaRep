
package example;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidationUtils {
	private static Pattern pattern;
	private static Matcher matcher;
	static final String PERSON_MOBILENUMBER="[(08)0-9{8}]";
	private static final String EMAIL_PATTERN =

			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"

			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	static final String VEHICLE_REGISTRATIONNUMBER="[A-Z{2},0-9{4},A_Z{2}]";
		
	public void EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
		}
		public static boolean validateMail(final String checkedMail) {
		matcher = pattern.matcher(checkedMail);
		return matcher.matches();
	}
		public void mobileNumberValidator(){
			pattern=Pattern.compile(PERSON_MOBILENUMBER);
			}
		public boolean validateMobileNum(final String checkedMobileNum){
			matcher=pattern.matcher(checkedMobileNum);
			return matcher.matches();
		}
		public void registrationnum(){
			pattern=Pattern.compile(VEHICLE_REGISTRATIONNUMBER);
					}
		public boolean validateRegistrationNum(final String checkedRegistrationNUm){
			matcher=pattern.matcher(checkedRegistrationNUm);
			return matcher.matches();
		}
}
