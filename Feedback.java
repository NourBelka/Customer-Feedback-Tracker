package Assignment9;

public class Feedback<T extends Number> {
	
	private String name;
	private String message;
	private T rating;
	
	public Feedback(String name, String message, T rating) {
		this.name = name;
		this.message = message;
		this.rating = rating;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public String getMessage() {
		return message;
	}
	
	public T  getRating() {
		return rating;
	}
	
	//Setters
	public void setName(String name) {
		this.name = name ;
	}
	 public void setMessage(String message) {
		 this.message = message;
	 }
	 
	 public void setRating(T rating) {
		 this.rating = rating;
	 }
	
	public String toString() {
		return "Name: " + name + "\nMessage: " + message + "\nRating: " + (rating == null ? "No rating" : rating);
	}

}
