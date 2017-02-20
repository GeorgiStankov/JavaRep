
public class AutomobileInquiry {
	private String owner;
	private String newOwner;
	private String registrationNumber;
	private int incomeNumber;
	
	public AutomobileInquiry(String owner,
	String newOwner,
	String registrationNumber){
		this.owner=owner;
		this.newOwner=newOwner;
		this.registrationNumber=registrationNumber;
		this.incomeNumber=0;
		
	}
	
	public AutomobileInquiry(int number) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @return the newOwner
	 */
	public String getNewOwner() {
		return newOwner;
	}
	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	/**
	 * @return the incomeNumber
	 */
	public int getIncomeNumber() {
		return incomeNumber;
	}
	/**
	 * @param incomeNumber the incomeNumber to set
	 */
	public void setIncomeNumber(int incomeNumber) {
		this.incomeNumber = incomeNumber;
	}
	public String getFirstLetters(){
		if(registrationNumber!=null){
			if(Character.isDigit(registrationNumber.charAt(1))){
				return registrationNumber.substring(0,2);
			}
			else{
				return String.valueOf(registrationNumber.charAt(0));
			}
		}
		return newOwner;
	}

}
