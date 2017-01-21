
 public class Reservation {
 	private int id;
 	private String username;
 	private int projectionId;
 	private int row;
 	private int col;
 	
 	Reservation(){};
 	Reservation(String username,int projectionId,int row,int col){
 		this.username=username;
 		this.projectionId=projectionId;
 		this.row=row;
 		this.col=col;
 	}
 	public int getId() {
 		return id;
 	}
 	public void setId(int id) {
 		this.id = id;
 	}
 	public String getUsername() {
 		return username;
 	}
 	public void setUsername(String username) {
 		this.username = username;
 	}
 	public int getProjectionId() {
 		return projectionId;
 	}
 	public void setProjectionId(int projectionId) {
 		this.projectionId = projectionId;
 	}
 	public int getRow() {
 		return row;
 	}
 	public void setRow(int row) {
 		this.row = row;
 	}
 	public int getCol() {
 		return col;
 	}
 	public void setCol(int col) {
 		this.col = col;
 	}
 	
 }