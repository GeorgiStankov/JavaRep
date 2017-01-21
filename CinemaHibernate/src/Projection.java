public class Projection {
 
 	private int id;
 	private int movieId ;
 	private String type ;
 	private String date ; 
 	private String time;
 	
 	Projection(){};
 	
 	public int getId() {
 		return id;
 	}
 	public void setId(int id) {
 		this.id = id;
 	}
 	public int getMovieId() {
 		return movieId;
 	}
 	public void setMovieId(int movie_id) {
 		this.movieId = movie_id;
 	}
 	public String getType() {
 		return type;
 	}
 	public void setType(String type) {
 		this.type = type;
 	}
 	public String getDate() {
 		return date;
 	}
 	public void setDate(String date) {
 		this.date = date;
 	}
 	public String getTime() {
 		return time;
 	}
 	public void setTime(String time) {
 		this.time = time;
 	}
 }