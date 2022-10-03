import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1> UserInterface.java </h1>
 * This is a driver class that creates and maintains the 
 * primary user command line interface and it manages the 
 * User.java and Book.java classes and associated objects.
 * 
 * @author Austin
 * @version 1.0
 * @since 1-28-2021
 * 
 */

public class UserInterface {
	//This variable controls the While loop that run the program
	public static boolean runProcess = true;
	//This variable indicates if a user has logged in or not.
	public static boolean isLoggedIn = false;
	//This variable indicated the which user is logged in.
	public static int loggedInUserNameCode = -1;
	//This variable stores the current user name for who is logged in.
	public static String loggedInUserName = "null";
	//This variable stores the user name login input from the user
	public static String userNameData;
	//This variable stores the command input from the user
	public static String commandDataFromUser;
	//This variable stores whether the user command input is incorrect or not.
	public static boolean isCommandInputIncorrect;
	//This variable stores the current object index value for allBooks ArrayList
	public static int selectedBookIndex;

	//create arrayList to store all User Objects
	public static ArrayList<Object> allUsers = new ArrayList<Object>();
	//create ArrayList to store all Book Objects
	public static ArrayList<Object> allBooks = new ArrayList<Object>();
	//Create a boolean ArrayList that scales for every book available. 
	public static ArrayList<Boolean> purchaseHistory = new ArrayList<Boolean>();
	//public static ArrayList<String> userName = new ArrayList<String>(Arrays.asList("user","admin","hacker"));
	public static ArrayList<String> commands = new ArrayList<String>(Arrays.asList("Logout","help","close","store"));

	/* This is the main method that initializes some of the objects that 
	 * will be used and it start the method that controls the user interface
	 * and manages all other primary functions.
	 */
	public static void main(String[] args)
	{

		 /* Add new Book Objects to the allBooks ArrayList with pre-generated eBook Data.
		 * These Books will be referenced in interfaces and also when their methods are 
		 * called.
		 * Use the default constructor for Book.java to reference the creation of each
		 * Book object.
		 */
		allBooks.add(new Book("Northanger Abbey","Jane Austen",1814,"Penguin",18.20,
				"No one who had ever seen Catherine Morland in her infancy would have\n"
				+ " supposed her born to be an heroine. Her situation in life, the\n"
				+ " character of her father and mother, her own person and disposition,\n"
				+ " were all equally against her. Her father was a clergyman, without\n"
				+ " being neglected, or poor, and a very respectable man, though his\n"
				+ " name was Richard—and he had never been handsome. He had a considerable\n"
				+ " independence besides two good livings—and he was not in the least\n"
				+ " addicted to locking up his daughters. Her mother was a woman of\n"
				+ " useful plain sense, with a good temper, and, what is more remarkable,\n"
				+ " with a good constitution. She had three sons before Catherine was born;\n"
				+ " and instead of dying in bringing the latter into the world, as anybody\n"
				+ " might expect, she still lived on—lived to have six children more—to see\n"
				+ " them growing up around her, and to enjoy excellent health herself. A\n"
				+ " family of ten children will be always called a fine family, where there\n"
				+ " are heads and arms and legs enough for the number; but the Morlands had\n"
				+ " little other right to the word, for they were in general very plain, and\n"
				+ " Catherine, for many years of her life, as plain as any. She had a thin\n"
				+ " awkward figure, a sallow skin without colour, dark lank hair, and strong\n"
				+ " features—so much for her person; and not less unpropitious for heroism\n"
				+ " seemed her mind. She was fond of all boy’s plays, and greatly preferred\n"
				+ " cricket not merely to dolls, but to the more heroic enjoyments of infancy,\n"
				+ " nursing a dormouse, feeding a canary-bird, or watering a rose-bush. Indeed\n"
				+ " she had no taste for a garden; and if she gathered flowers at all, it was\n"
				+ " chiefly for the pleasure of mischief—at least so it was conjectured from\n"
				+ " her always preferring those which she was forbidden to take.\n"));
		
		allBooks.add(new Book("War and Peace","Leo Tolstoy",1965,"Penguin",12.70,
				"Well, Prince, so Genoa and Lucca are now just family estates of the Buonapartes\n."
				+ " But I warn you, if you don’t tell me that this means war, if you still try to\n"
				+ " defend the infamies and horrors perpetrated by that Antichrist—I really believe\n"
				+ " he is Antichrist—I will have nothing more to do with you and you are no longer\n"
				+ " my friend, no longer my ‘faithful slave,’ as you call yourself! But how do you\n"
				+ " do? I see I have frightened you—sit down and tell me all the news.\n" +  
				"It was in July, 1805, and the speaker was the well-known Anna Pávlovna Schérer,\n"
				+ " maid of honor and favorite of the Empress Márya Fëdorovna. With these words she\n"
				+ " greeted Prince Vasíli Kurágin, a man of high rank and importance, who was the first\n"
				+ " to arrive at her reception. Anna Pávlovna had had a cough for some days. She was,\n"
				+ " as she said, suffering from la grippe; grippe being then a new word in St. Petersburg,\n"
				+ " used only by the elite.\n"));
		
		allBooks.add(new Book("Anna Karenina","Leo Tolstoy",1875,"Penguin",13.50,
				"Happy families are all alike; every unhappy family is unhappy in its own way.\n"
				+ "Everything was in confusion in the Oblonskys’ house. The wife had discovered\n"
				+ " that the husband was carrying on an intrigue with a French girl, who had been\n"
				+ " a governess in their family, and she had announced to her husband that she\n"
				+ " could not go on living in the same house with him. This position of affairs\n"
				+ " had now lasted three days, and not only the husband and wife themselves, but\n"
				+ " all the members of their family and household, were painfully conscious of it.\n"
				+ " Every person in the house felt that there was no sense in their living together,\n"
				+ " and that the stray people brought together by chance in any inn had more in common\n"
				+ " with one another than they, the members of the family and household of the Oblonskys.\n"
				+ " The wife did not leave her own room, the husband had not been at home for three days.\n"
				+ " The children ran wild all over the house; the English governess quarreled with the\n"
				+ " housekeeper, and wrote to a friend asking her to look out for a new situation for her;\n"
				+ " the man-cook had walked off the day before just at dinner time; the kitchen-maid,\n"
				+ " and the coachman had given warning.\n"));
		
		allBooks.add(new Book("Mrs. Dalloway","",1999,"Penguin",9.99,
				"Mrs. Dalloway said she would buy the flowers herself. For Lucy had her work cut out for\n"
				+ " her. The doors would be taken off their hinges; Rumpelmayer's men were coming. And\n"
				+ " then, thought Clarissa Dalloway, what a morning--fresh as if issued to children on\n"
				+ " a beach. What a lark! What a plunge! For so it had always seemed to her, when, with\n"
				+ " a little squeak of the hinges, which she could hear now, she had burst open the French\n"
				+ " windows and plunged at Bourton into the open air. How fresh, how calm, stiller than\n"
				+ " this of course, the air was in the early morning; like the flap of a wave; the kiss\n"
				+ " of a wave; chill and sharp and yet (for a girl of eighteen as she then was) solemn,\n"
				+ " feeling as she did, standing there at the open window, that something awful was about\n"
				+ " to happen; looking at the flowers, at the trees with the smoke winding off them and\n"
				+ " the rooks rising, falling; standing and looking until Peter Walsh said\n"
				+ ", \"Musing among the vegetables?\"--was that it?--\"I prefer men to cauliflowers\"\n"
				+ "--was that it? He must have said it at breakfast one morning when she had gone out\n"
				+ " on to the terrace--Peter Walsh. He would be back from India one of these days, June\n"
				+ " or July, she forgot which, for his letters were awfully dull; it was his sayings one\n"
				+ " remembered; his eyes, his pocket-knife, his smile, his grumpiness and, when millions\n"
				+ " of things had utterly vanished--how strange it was!--a few sayings like this about\n"
				+ " cabbages.\n"));
		
		allBooks.add(new Book("Huckleberry Finn","Mark Twain",1865,"Random House",5.76,
				"You don’t know about me without you have read a book by the name of The Adventures of\n"
				+ " Tom Sawyer; but that ain’t no matter. That book was made by Mr. Mark Twain, and he\n"
				+ " told the truth, mainly. There was things which he stretched, but mainly he told the\n"
				+ " truth. That is nothing. I never seen anybody but lied one time or another, without\n"
				+ " it was Aunt Polly, or the widow, or maybe Mary. Aunt Polly—Tom’s Aunt Polly, she\n"
				+ " is—and Mary, and the Widow Douglas is all told about in that book, which is mostly\n"
				+ " a true book, with some stretchers, as I said before. Now the way that the book winds\n"
				+ " up is this: Tom and me found the money that the robbers hid in the cave, and it made\n"
				+ " us rich. We got six thousand dollars apiece—all gold. It was an awful sight of money\n"
				+ " when it was piled up. Well, Judge Thatcher he took it and put it out at interest,\n"
				+ " and it fetched us a dollar a day apiece all the year round—more than a body could\n"
				+ " tell what to do with. The Widow Douglas she took me for her son, and allowed she\n"
				+ " would sivilize me; but it was rough living in the house all the time, considering\n"
				+ " how dismal regular and decent the widow was in all her ways; and so when I couldn’t\n"
				+ " stand it no longer I lit out. I got into my old rags and my sugar-hogshead again,\n"
				+ " and was free and satisfied. But Tom Sawyer he hunted me up and said he was going\n"
				+ " to start a band of robbers, and I might join if I would go back to the widow and\n"
				+ " be respectable. So I went back.\n"));
		
		allBooks.add(new Book("Bleak House","Charles Dickens",1870,"Random House",5.75,
				"London. Michaelmas term lately over, and the Lord Chancellor sitting in Lincoln's Inn\n"
				+ " Hall. Implacable November weather. As much mud in the streets as if the waters had\n"
				+ " but newly retired from the face of the earth, and it would not be wonderful to meet\n"
				+ " a Megalosaurus, forty feet long or so, waddling like an elephantine lizard up Holborn\n"
				+ " Hill. Smoke lowering down from chimney-pots, making a soft black drizzle, with flakes\n"
				+ " of soot in it as big as full-grown snowflakes—gone into mourning, one might imagine,\n"
				+ " for the death of the sun. Dogs, undistinguishable in mire. Horses, scarcely better;\n"
				+ " splashed to their very blinkers. Foot passengers, jostling one another's umbrellas\n"
				+ " in a general infection of ill temper, and losing their foot-hold at street-corners,\n"
				+ " where tens of thousands of other foot passengers have been slipping and sliding\n"
				+ " since the day broke (if this day ever broke), adding new deposits to the crust\n"
				+ " upon crust of mud, sticking at those points tenaciously to the pavement, and\n"
				+ " accumulating at compound interest."));
		
		allBooks.add(new Book("Tom Sawyer","Mark Twain",1862,"Random House",7.75,
				"TOM!\n"
				+ "No answer.\n" 
				+ "TOM!\n"
				+ "No answer.\n"
				+ "What’s gone with that boy,  I wonder? You TOM!\n"
				+ "No answer.\n" 
				+ "The old lady pulled her spectacles down and looked over them about the room; then\n"
				+ " she put them up and looked out under them. She seldom or never looked through\n"
				+ " them for so small a thing as a boy; they were her state pair, the pride of her\n"
				+ " heart, and were built for style, not service—she could have seen through a\n"
				+ " pair of stove-lids just as well. She looked perplexed for a moment, and then\n"
				+ " said, not fiercely, but still loud enough for the furniture to hear:\n" 
				+ "Well, I lay if I get hold of you I’ll—\n"
				+ "She did not finish, for by this time she was bending down and punching under the\n"
				+ " bed with the broom, and so she needed breath to punctuate the punches with.\n"
				+ " She resurrected nothing but the cat.\n"));
		
		allBooks.add(new Book("Hamlet","Prince of Denmark",1603,"Signet Classics",7.95,
				"SCENE I. Elsinore. A platform before the castle.\n"
				+ "FRANCISCO at his post. Enter to him BERNARDO\n"
				+ "BERNARDO\n" 
				+ "Who's there?\n" 
				+ "FRANCISCO\n"
				+ "Nay, answer me: stand, and unfold yourself.\n" 
				+ "BERNARDO\n"
				+ "Long live the king!\n"
				+ "FRANCISCO\n"
				+ "Bernardo?\n" 
				+ "BERNARDO\n" 
				+ "He.\n"
				+ "FRANCISCO\n"
				+ "You come most carefully upon your hour.\n"
				+ "BERNARDO\n"
				+ "'Tis now struck twelve; get thee to bed, Francisco.\n"
				+ "FRANCISCO\n"
				+ "For this relief much thanks: 'tis bitter cold,\n"
				+ "And I am sick at heart.\n"));
		
		allBooks.add(new Book("Lord of the Rings","J. R. Tolkien",1937,"Penguin",27.45,
				"When Mr. Bilbo Baggins of Bag End announced that he would shortly be celebrating\n"
				+ " his eleventy-first birthday with a party of special magnificence, there was\n"
				+ " much talk and excitement in Hobbiton. Bilbo was very rich and very peculiar,\n"
				+ " and had been the wonder of the Shire for sixty years, ever since his remarkable\n"
				+ " disappearance and unexpected return. The riches he had brought back from his\n"
				+ " travels had now become a local legend, and it was popularly believed, whatever\n"
				+ " the old folk might say, that the Hill at Bag End was full of tunnels stuffed\n"
				+ " with treasure. And if that was not enough for fame, there was also his prolonged\n"
				+ " vigour to marvel at. Time wore on, but it seemed to have little effect on\n"
				+ " Mr. Baggins. At ninety he was much the same as at fifty. At ninety-nine they\n"
				+ " began to call him well-preserved, but unchanged would have been nearer the mark.\n"
				+ " There were some that shook their heads and thought this was too much of a good\n"
				+ " thing; it seemed unfair that anyone should possess (apparently) perpetual youth\n"
				+ " as well as (reputedly) inexhaustible wealth.‘It will have to be paid for,’ they\n"
				+ " said. ‘It isn’t natural, and trouble will come of it!’ But so far trouble had\n"
				+ " not come; and as Mr. Baggins was generous with his money, most people were\n"
				+ " willing to forgive him his oddities and his good fortune. He remained on visiting\n"
				+ " terms with his relatives (except, of course, the Sackville-Bagginses), and he had\n"
				+ " many devoted admirers among the hobbits of poor and unimportant families. But he\n"
				+ " had no close friends, until some of his younger cousins began to grow up.\n"));
		
		/* For the size of allBooks, add a false boolean value to the purchaseHistory ArrayList,
		 * This is in term passed into each user Object declaration to store all of the eBook
		 * purchase records. By Default all user will start out own no eBooks. 
		 */ 
		for(int i = 0; i < allBooks.size(); i++)
		{
			//add a false boolean value to purchaseHistory
			purchaseHistory.add(false);
		}
 
		//initialize All of the user Objects and store that in the allUsers ArrayList.
		allUsers.add(new User("admin",purchaseHistory));
		allUsers.add(new User("Sue",purchaseHistory));
		allUsers.add(new User("Sally",purchaseHistory));	
		allUsers.add(new User("Jose",purchaseHistory));
		allUsers.add(new User("Bob",purchaseHistory));		
		
		/* For every Book Object in allBooks, add the the given strings to the commands
		 * ArrayList. This ArrayList serves to create a database of recognized eBook
		 * commands. Each book has a unique "buybook","readbook", and "returnbook" command
		 * as a result of this for loop.
		 */
		for(int i = 0; i < allBooks.size(); i++)
		{
			commands.add("buybook"+i);
			commands.add("readbook"+i);
			commands.add("returnbook"+i);
		}
		
		//Printout the eBook Catalog and headers
		System.out.println("-------------------------------------- eReader Store -------------------------------------------");
		System.out.println("| Book #: | eBook Titles & Prices:");
		System.out.println("------------------------------------------------------------------------------------------------");
		//Printout the all of the data from each Book Object.
		for(int i = 0; i < allBooks.size(); i++)
		{
			System.out.println("| # = "+i+"  | "+allBooks.get(i)+" |");
		}
		System.out.println("------------------------------------------------------------------------------------------------");
		
		//Call the primary method
		runProcess();
	}
	
	/* This is the primary method that operates all major the major functions that
	 * the end user will interact with.
	 */
	public static void runProcess()
	{
		/* While the boolean variable runProcess is true, then operate 
		 * the loop continuously. This loop will stop if the user uses the "close"
		 * command.
		 */
		while(runProcess)
		{
			/* If the primary "fork in the road" or "Split" that operates the user command line interface.
			 * If a user is logged in, then evaluate user commands and either execute the desired action
			 * or return and error, if the user is NOT logged in then
			 * display a login prompt and evaluate inputs to verify that they are valid logins.
			 */
			if(isLoggedIn)
			{
				System.out.println("\nPlease Type a Command: [Commands: help, logout, store, buy book #, read book #, return book #, close]");
				//Set the string value of commandDataFromUser to the return String from getScannerInput method. 
			    commandDataFromUser = getScannerInput();
				//Format the string value from commandDataFromUser from the given to having all lower case characters.
				commandDataFromUser = commandDataFromUser.toLowerCase();
				/* Set the variable isCommandInputIncorrect to false default, prior to cross-referencing to
				 * the commands ArrayList. This is so that the user input command can be verified to either
				 * be a recognized command with an executable task or an error on the part of the user.
				 */
				isCommandInputIncorrect = true;

				//Integrate this For loop for every entry in the ArrayList commands
				for(int i = 0; i < commands.size(); i++)
				{
					//If the String data from commandDataFromUser is recognized in the ArrayList commands.
					if(commandDataFromUser.equalsIgnoreCase(commands.get(i)))
					{
						//Set the isCommandInputIncorrect to false since the input at this point has been verified.
						isCommandInputIncorrect = false;
						
						//If commandDataFromUser has the char sequence "store" then print out the eBook store.
						if((commandDataFromUser.contains("store")))
						{
							//Printout the eBook Catalog and headers
							System.out.println("-------------------------------------- eReader Store -------------------------------------------");
							System.out.println("| Book #: | eBook Titles & Prices:");
							System.out.println("------------------------------------------------------------------------------------------------");
							/* Printout the all of the data from each Book Object.
							 * Integrate for every book in the ArrayList allBooks.
							 */
							for(int x = 0; x < allBooks.size(); x++)
							{
								/* If the current element value of the current user's purchase history
								 * is true, then print out the book data statement as purchase.
								 */
								if((((User) allUsers.get(loggedInUserNameCode)).getPurchaseHistoryEntry(x)))
								{
									System.out.println("| # = "+x+"  | "+(((Book) allBooks.get(x)).getTitle())+" by "
										+(((Book) allBooks.get(x)).getAuthor())+", published in "
										+(((Book) allBooks.get(x)).getYearWritten())
										+", Edition: "+(((Book) allBooks.get(x)).getEdition())
										+" | PURCHASED");
								}
								/* If the the current element value of the current user's purchase history is
								 * false, then print out the book data with the purchase value of said eBook entry.
								 */
								else
								{
									System.out.println("| # = "+x+"  | "+(((Book) allBooks.get(x)).getTitle())+" by "
										+(((Book) allBooks.get(x)).getAuthor())+", published in "
										+(((Book) allBooks.get(x)).getYearWritten())
										+", Edition: "+(((Book) allBooks.get(x)).getEdition())
										+" | Price: $"+(((Book) allBooks.get(x)).getPrice()));
								}

							}
							System.out.println("------------------------------------------------------------------------------------------------");
						}
						
						//If commandDataFromUser has the char sequence "close" then terminate program.
						if((commandDataFromUser.contains("close")))
						{
							System.out.println("[i] Closing Program...");
							//Terminate the program.
							runProcess = false;
							System.exit(0);
						}
						
						//If commandDataFromUser has the char sequence "help" then print out the help prompt.
						if(commands.get(i).equalsIgnoreCase("help"))
						{
							//Printout the "help" prompt
							System.out.println("-------------------------------------- eReader Commands Help -------------------------------------------\n"
									+"| # | User selected eBook index. This is a integer value used for the eBook-related commands above.\n"
									+"| help | Prints out this command refference help interface.\n"
									+"| store | Prints out the eReader store selection.\n"
									+"| store | Prints out the eReader store selection.\n"
									+"| close | This command close out the program.\n"
									+"| logout | Logs out the current user from the eReader sim.\n"
									+"| buy book # | Purchases the given eBook from the eBook index number.\n"
									+"| read book # | Prints the given eBook from the eBook index number.\n"
									+"| return book # | Return the given eBook from the eBook index number (this revokes eBook purchases).\n"
									+"--------------------------------------------------------------------------------------------------------");

						}
						//If commandDataFromUser has the char sequence "logout" then modify the logout the user.
						if(commands.get(i).equalsIgnoreCase("logout"))
						{
							System.out.println("[i] Logout Successful.\n");
							/*  Modify the isLoggedIn status to false, and change loggedInUserNameCode to -1, 
							 *	and change the string value of loggedInUserName to "null." This 
							 *	forces the primary if statement (isLoggedIn) to evaluate to false
							 *	thus making the login prompt appear to the user.
							 */
							isLoggedIn = false;
							loggedInUserNameCode = -1;
							loggedInUserName = "null";
						}

						//if commandDatFromUser has the char sequence "buybook" then check the purchase status
						if((commandDataFromUser.contains("buybook")))
						{
							/* Update the variable selectedBookIndex to the index integer behind the "buy book" command.
							 * This statement removes the char sequence "buybook" (just leaving a string value) and 
							 * parse this as a integer value.
							 */
							selectedBookIndex = (Integer.parseInt((commandDataFromUser.replace("buybook", ""))));
							//Check to see if the user has not purchase the book, if the user has not purchase the book then allow the transaction.
							if(((((User) allUsers.get(loggedInUserNameCode)).getPurchaseHistoryEntry(selectedBookIndex))) == false)
							{
								/* Change the boolean element attribute associated with this Book index number
								 * to true for the user object, thus this results in the user having purchasing access
								 * to book of the given index (selectedBookIndex).
								 */
								((User) allUsers.get(loggedInUserNameCode)).buyBook(selectedBookIndex);
								System.out.println((((Book) allBooks.get(selectedBookIndex)).getPurchaseNotification()));
							}
							else
							{
								//If the user has already has purchased the selected eBook then print out an error message.
								System.out.println("[!] Error: You have already purchased this eBook.\n"
												+ "[i] To read this eBook, please use the commands \"read "
												+ "book #\" to read this book, or \"return book #\" to return this book.");
							}
						}
						
						//If commandDataFromUser has the char sequence "readbook" then check the purchase status.
						if((commandDataFromUser.contains("readbook")))
						{
							/* Update the variable selectedBookIndex to the index integer behind the "buy book" command.
							 * This statement removes the char sequence "readbook" (just leaving a string value) and 
							 * parse this as a integer value.
							 */
							selectedBookIndex = (Integer.parseInt((commandDataFromUser.replace("readbook", ""))));
							/* Check to see if the user own the eBook, if the user own the eBook 
							 * then print out the book text, else print an error message, and a prompt to buy the eBook.
							 */
							if((((User) allUsers.get(loggedInUserNameCode)).getPurchaseHistoryEntry(selectedBookIndex)) == true)
							{
								//Printout a header and the book content.
								System.out.println("--------------------------------------------------------------------------------------------------------");
								System.out.println(((Book) allBooks.get(selectedBookIndex)).getBookContent());
							
							}
							else
							{
								//Print out an error massage and a prompt to buy the eBook.
								System.out.println("[!] Error: You Cannot Read This Book Becuase You Don't Own It\n"
													+ "[i] To Buy This Book Type \"buy book "+selectedBookIndex+"\"");
							}
						}

						//If commandDataFromUser has the char sequence "returnbook" then check the purchase status.
						if((commandDataFromUser.contains("returnbook")))
						{
							/* Update the variable selectedBookIndex to the index integer behind the "buy book" command.
							 * This statement removes the char sequence "returnbook" (just leaving a string value) and 
							 * parse this as a integer value.
							 */
							selectedBookIndex = (Integer.parseInt((commandDataFromUser.replace("returnbook", ""))));
							/* Change the boolean element attribute associated with this Book index number
							 * to fase for the user object, thus this results in the user removing purchasing access
							 * to book of the given index (selectedBookIndex).
							 */
							if((((User) allUsers.get(loggedInUserNameCode)).getPurchaseHistoryEntry(selectedBookIndex)) == true)
							{
								//return the book: change the boolean value to false on the purchaseHistory arraylist on the user object.
								((User) allUsers.get(loggedInUserNameCode)).returnBook(selectedBookIndex);
								//Printout a return statement from the book object.
								System.out.println((((Book) allBooks.get(selectedBookIndex)).getReturnNotification()));
							}
							else
							{
								//If the user does not own the book that is trying to be returned then display an error message.
								System.out.println("[!] Error: You don't own this eBook.");
							}
						}
					}
				}
				
				//If the command that was inputed by the user is unrecognized then print an error message.
				if(isCommandInputIncorrect == true)
				{
					System.out.println("[!] Unrecognized command.");
				}
			}
			else
			{
				//print out the login prompt with all of the available users 
				System.out.print("Please Log in as: [");
				//This for loop prints out all users in the arraylist allUsers however, to autoformat the print out.
				for(int i = 0; i < allUsers.size(); i++)
				{
					//If the index is one minus the overall size, then just print out the name.
					if(i == allUsers.size()-1)
					{
						System.out.print(((User) allUsers.get(i)).getUserName());
					}
					//If the index is not one minus the overall size, the place a comma and a space between entries.
					else
					{
						System.out.print(((User) allUsers.get(i)).getUserName()+", ");
					}
				}
				System.out.print("]\n");
				//Set the string value of userNameData to the return String from getScannerInput method. 
				userNameData = getScannerInput();
				/* Create a boolean variable to evaluate whether or not the user name input is value.
				 * By default it is true until is is verified
				 */
				boolean isUserNameInputIncorrect = true;
				//For every entry in allUsers
				for(int i = 0; i < allUsers.size(); i++)
				{
					if(userNameData.equalsIgnoreCase(((User) allUsers.get(i)).getUserName()))
					{
						/*if the input from the user (userNameData) is equal to (ignore case) the given entry
						 * in the arraylist then set loggedInUserNameCode to the current value of i, isLoggedIn to true
						 * loggedInUserName to the retuned String from the User object class getUserName(), and isUserNameInputIncorrect
						 * to false, this is change the whole status of the program from the login screen to the command interface. 
						 */
						loggedInUserNameCode = i;
						isLoggedIn = true;
						loggedInUserName = ((User) allUsers.get(i)).getUserName();
						isUserNameInputIncorrect = false;
					}
				}
				
				/*
				 * If the user name input is incorrect then print and error message,
				 * else, print a welcome message.
				 */
				if(isUserNameInputIncorrect)
				{
					//Print out a message for an unrecognized username.
					System.out.println("[!] Username input is not recognized.");
				}
				else
				{
					//Print out a welcome message for an affirmed user name account.
					System.out.println("[i] Login successful. Welcome back "+loggedInUserName+".");
				}
			}
		}
	}
	

	/**
	 * This method that is creates a scanner object to receive all inputs from the user.
	 * @return This returns a String variable value of what the user inputs into the scanner prompt.
	 */
	public static String getScannerInput()
	{
		//Create Scanner object
		Scanner userInput = new Scanner(System.in);
		//Print terminal user input cursor
		System.out.print("> ");
		//Create the String variable input and set that to the Scanner object
		String input = userInput.nextLine();
		input = input.replace(" ", "");
		//Clear the Scanner object value
		userInput = null;
		return input;
	}
}
