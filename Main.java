package Assignment9;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArrayList<Feedback<Integer>> fbs = new ArrayList <>();

		System.out.println("Welcome to CoffeeShop Feedback Tracker!\n");
		
		while (true) {
	
		//name + check
		String name = "";
		while(true) {
		System.out.print("Enter customer name: ");
		name = scanner.nextLine();
		
		if (name.isEmpty())
		System.out.println("Name cannot be empty. Please try again.\n");
		else break;
		} 
		
		//feedback
		System.out.print("Enter feedback: ");        
		String message = scanner.nextLine();
		
		//rating + check
		Integer rating = null;
		while (true) {
		try { 
		System.out.print("Enter rating (1-5) or 0 for no rating: ");
		rating = scanner.nextInt();
		scanner.nextLine();
		
		if (rating >= 1 && rating <= 5)
			break;
		
		else if (rating == 0) {
			rating = null;
			break;
			} else 
			System.out.println("Please enter a rating between 1 and 5 or 0 for no rating.\n");
		
		} catch (InputMismatchException i) {
			System.out.println("Invalid input. Please try again.\n");
			scanner.nextLine();
			}
		}
		
		//adding feedback
		Feedback<Integer> feedback = new Feedback<>(name, message, rating);
		fbs.add(feedback);
		
		//other feedbacks
		System.out.print("\nAdd another? (yes/no)): ");
		String input = scanner.next();
		scanner.nextLine();
		System.out.println("");
			
			if (input.equalsIgnoreCase("no")) 
				break;
		}
		
		//printing feedback entries
		System.out.println("--- Feedback Entries ---");
		for(int i=0; i < fbs.size(); i++) {
			System.out.println(fbs.get(i));
			System.out.println();
		}
		
		//total feedback
		System.out.println("\nTotal feedback entries: " + fbs.size());
		

		//asking if user wants to update feedback
		while(true) {
		System.out.print("\nWould you like to update any feedback? (yes/no): ");
		String input = scanner.next();
		scanner.nextLine();

		System.out.println("");
		
		if (input.equalsIgnoreCase("no")) 
			break;
		
		//updating name + check
		String name = "";
		
		while (true) {
		    System.out.print("Enter name to update: ");
		    name = scanner.nextLine();

		    if (name.isEmpty())
		        System.out.println("Name cannot be empty. Please try again.\n");
		    else break;
		}
		
		//updating message
		System.out.print("Enter new message: ");        
		String updatedMessage = scanner.nextLine();
		
		//updating rating + check
		Integer updatedRating = null;
		while (true) {
		    try {
		        System.out.print("Enter new rating (1-5) or 0: ");
		         updatedRating = scanner.nextInt();
		        scanner.nextLine(); 

		        if (updatedRating >= 1 && updatedRating <= 5) 
		            break;
		         else if (updatedRating == 0) {
		            updatedRating = null;
		            break;
		        } else {
		            System.out.println("Please enter a number between 1 and 5 or 0 for no rating.\n");
		        }
		    } catch (InputMismatchException e) {
		        System.out.println("Invalid input. Please enter a number.\n");
		        scanner.nextLine(); 
		    }
		}

		
		//updating feedback
		for(Feedback<Integer> f: fbs) {
		if (f.getName().equalsIgnoreCase(name)) {
			f.setMessage(updatedMessage);
			f.setRating(updatedRating);
			break;
		 		}
			}
		
		}
		
		//deleting feedbacks
		while (true) {
			System.out.print("Would you like to delete any feedback? (yes/no): ");
			String input = scanner.next();
			scanner.nextLine();
			System.out.println("");
			
			if (input.equalsIgnoreCase("no")) 
				break;
			
			System.out.print("Enter name to delete: ");
			String name = scanner.next();
			
			boolean found = false;
			
			for(int i=0; i < fbs.size(); i++) {
				if (fbs.get(i).getName().equals(name)) {
					fbs.remove(i);
					found = true; 
					System.out.println("Feedback for " + name + " has been deleted.\n");
					break;
					}
			}
			
			if(!found) {
				System.out.println("No feedback found for " + name + ".");
			}
		}
		
		//printing final feedback list with for each loop
		System.out.println("--- Final Feedback List ---");
		for(Feedback<Integer> f: fbs) {
			System.out.println("Name: " + f.getName() + " - Message: " + f.getMessage() + " - Rating: " + (f.getRating() == null ? "No rating" : f.getRating()));
		}

		scanner.close();
	}
 
}
