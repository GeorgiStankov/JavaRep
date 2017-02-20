
public class MVRCSSofia extends MVRCS{

	public  MVRCSSofia(int number){
		super(number);
	}
	public int addInquiry(AutomobileInquiry inq1){
		if(inq1.getFirstLetters().equals("CA") || inq1.getFirstLetters().equals("C") || inq1.getFirstLetters().equals("CB")){
			arrayOfAutomobileInquiry.add(inq1);
			return 1;
		}
			else{
				System.out.println("invalid");
				
								return 0;
			}
		}
		
	}
