import java.util.ArrayList;
public class MVRCS extends AutomobileInquiry {
   protected static ArrayList<AutomobileInquiry> arrayOfAutomobileInquiry=new ArrayList<AutomobileInquiry>();
   private int number;
   private static int currentIncomeNumber;
   public MVRCS(int number){
	   super(number);
	   this.number=number;
	   
   }
   public int addInquity(AutomobileInquiry inq){
	   currentIncomeNumber++;
	   inq.setIncomeNumber(currentIncomeNumber);
	   arrayOfAutomobileInquiry.add(inq);
	   return currentIncomeNumber;
   }
   public void deleteInquiry(int incomeNumber){
	   for(AutomobileInquiry a:arrayOfAutomobileInquiry){
		   if(a.getIncomeNumber()==incomeNumber){
			   arrayOfAutomobileInquiry.remove(a);
		   }
	   }
   }

}
