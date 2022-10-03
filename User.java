import java.util.ArrayList;

/**
 * <h1> User.java </h1>
 * This class contains a constructor that creates an object to 
 * store data (user name and purchase data) for each eReader user.
 * 
 * @author Austin
 * @version 1.0
 * @since 1-28-2021
 */

public class User {
	
	//Create the private variables and objects that will be required for the constructor. 
	private ArrayList<Boolean> purchaseHistory = new ArrayList<Boolean>();
	private String userName;
	
	/**
	 * This is the default constructor for the User.java class. This constructor 
	 * creates the objects for all created user.
	 * 
	 * @param userName This parameter is for storing the string of the user's name within the object.
	 * @param purchaseHistory This parameter us for storing a boolean ArrayList which indicates if a 
	 * 							user has purchased the "viewing rights" to open a eBook. 
	 */
	public User(String userName, ArrayList<Boolean> purchaseHistory)
	{
		this.userName = userName;
		/*	This for loop ensured that a attribute-by-attribute copy of purchaseHistory from the method
		 *	parameters to the local private object of the object. This ensures data security and prevents
		 *	data-leaks and/or data-bleed-over between users/console operators. 
		 */
		for(int i = 0; i < purchaseHistory.size(); i++)
		{
			this.purchaseHistory.add(purchaseHistory.get(i));
		}
	}
	
	/**
	 * This is a getter method for the attribute userName from each User object.
	 * @return this returns a string value of the current attribute userName from the objects.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * This is a setter method for the attribute userName for each User object.
	 * @param userName	This is a string variable that is parsed into the method
	 * 					to update the local private userName variable.
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
					
	/**
	 * This is functionally a "setter method" for the individual element values from the 
	 * ArrayList purchaseHistory. A true value indicates that the user has purchased the "viewing 
	 * rights" to open a eBook, a false value indicates that the user has not purchased the eBook.
	 * 
	 * @param purchaseIndexNumber This int variable indicates which boolean element will be updated to
	 * 								true in the purchaseHistory ArrayList. This will allow the user to be 
	 * 								able to access the title associated with that particular value.
	 */
	public void buyBook(int purchaseIndexNumber)
	{
		purchaseHistory.set(purchaseIndexNumber, true);
	}
	
	/**
	 * This also functionally a "getter method' for the individual element values form the ArrayList
	 * purchaseHistory. This method changes the value of a boolean element in the ArrayList purchaseHistory
	 * to false, this removing the ability to view a eBook from the user.
	 * @param purchaseIndexNumber This int variable indicates which boolean element will be updated to
	 * 								false in the purchaseHistory ArrayList. This will revoke access to the 
	 * 								title associated with the particular value.
	 */
	public void returnBook(int purchaseIndexNumber)
	{
		purchaseHistory.set(purchaseIndexNumber, false);
	}
	
	/**
	 * This is a getter method that returns the current boolean
	 * value of an element with the purchaseHistory ArrayList. 
	 * This method is used to comfirm if the user has or has not 
	 * purchased a book.
	 * @param purchaseIndexNumber This is an integer value that indicated which boolean element will be
	 * 								returned as a result.
	 * @return this returns a boolean value for the given index of purchaseHistory.
	 */
	public boolean getPurchaseHistoryEntry(int purchaseIndexNumber)
	{
		return purchaseHistory.get(purchaseIndexNumber);
	}
	
	
	/**
	 * This is a toString() method that prints out basic user data
	 * @return A String value that displays the user's name and purchase data.
	 */
	public String toString()
	{
		return userName + " | Purchase History: "+purchaseHistory+"\n";
	}
}
