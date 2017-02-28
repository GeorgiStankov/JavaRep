
public class ET extends Company{
	private String owner;
	private double startC;
	private double actualC;
	
	public ET(){
		super();
	}
	 public void setOwner(String owner){
		 this.owner=owner;
	 }
	 public void setStartC(double startC){
		 this.startC=startC;
	 }
	 public void setActualCr(double actualC){
		 this.actualC=actualC;
	 }
	 public String getOwner(){
		 return this.owner;
	 }
	 public double getstartC(){
		 return this.startC;
	 }
	 public double getActualC(){
		 return this.actualC;
	 }
	 
	 public double result(){
		 return this.actualC-this.startC;
	 }
	  

	 
}
