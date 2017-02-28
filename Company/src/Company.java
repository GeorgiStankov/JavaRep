

public class Company {
	private String name;
	private String bulstat;
	private String date;
	
	public void setName(String name){
		this.name=name;			
	}
	public void setBulstat(String bulstat){
		if(bulstat.length()!=10){
			System.out.println("Enter a valid bulstat length");
		}
		if(bulstat.length()==10){
			this.bulstat=bulstat;
		}
	}
	
	public void setDate(String date){
		this.date=date;			
	}
	
	public String getName(){
		return this.name;
	}

	public String getBulstat(){
		return this.bulstat;
	}
	public String getDate(){
		return this.date;
	}

	public static void main(String[] args) {
	
	}
}

