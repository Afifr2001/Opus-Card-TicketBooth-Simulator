// -------------------------------------------------------------------------
// Assignment 4
// Written by: Mohammed Rahman 40203098
// For COMP 248 Section (ECB) - Fall 2021
// This program generates a simulator in which there are 
// several Ticketbooths that hold tickets and OPUS cards and
// the user can manipulate the content (amount of tickets, price, card info)
// by choosing on of the 9 options available in this application
// -------------------------------------------------------------------------s


import java.util.Scanner;

public class driver 
{

	public static void main(String[] args) 
	{

		// Initialize Scanner to keyboard input
		Scanner keyboard = new Scanner(System.in);
		
		//Declare variables of type integer, string, for the menu and the options of the simulator
		int menu, options;
		int option3, option4, option5, option6, option7, optionCard;
		String option1, option2;
		

		// Hardcode of the ticketbooths 
		
		// Ticketbooth #0
		Tickets booth0 = new Tickets(5, 1, 0, 1, 1);
		
		// Ticketbooth #1
		Tickets booth1 = new Tickets(booth0);
		OPUSCard[] opus1 = new OPUSCard[2];
		
		// content of #0
		opus1[0] = new OPUSCard("STL-M", "Cola", 8, 2024);
		opus1[1] = new OPUSCard("RTL-C", "Venus", 03, 2025);
		
		//content of #1
		OPUSCard[] opus2 = new OPUSCard[2];
		opus2[0] = new OPUSCard("STL-M", "Cola", 8, 2024);
		opus2[1] = new OPUSCard("STM-Z", "Poker", 10, 2022);
		
		// Ticketbooth #2
		Tickets booth2 = new Tickets(5, 5, 5, 5, 5);
		OPUSCard[] opus3 = new OPUSCard[3];
		
		// content of #2 
		opus3[0] = new OPUSCard("RTL-F", "Max", 12, 2021);
		opus3[1] = new OPUSCard("REM-T", "Flona", 04, 2023);
		opus3[2] = new OPUSCard("TRAMREM-S", "EaFL", 11, 2021);
		
		// Ticketbooth #3
		Tickets booth3 = new Tickets(0, 1, 1, 1, 1);
		
		//Ticketbooth #4 (same as #3)
		Tickets booth4 = new Tickets(booth3);
		
		// content of #3 and #4
		OPUSCard[] opus4 = new OPUSCard[0];
		OPUSCard[] opus5 = new OPUSCard[0];
		
		// tickets and OPUS cards of each ticketbooths
		Ticketbooth machine1 = new Ticketbooth(booth0, opus1);
		Ticketbooth machine2 = new Ticketbooth(booth1, opus2);
		Ticketbooth machine3 = new Ticketbooth(booth2, opus3);
		Ticketbooth machine4 = new Ticketbooth(booth3, opus4);
		Ticketbooth machine5 = new Ticketbooth(booth4, opus5);
		
		// putting the content of the 5 ticketbooths into an array
		Ticketbooth[] array = { machine1, machine2, machine3, machine4, machine5 }; 


		// Display Welcome Message
		System.out.println("=====================================================================\n\n"
				+ "    Welcome to Concordia 2021 Fall Geek's Ticketbooth Application\n\n"
				+ "=====================================================================\n");
		
		// Going back to the menu choice based on the input by user 
		boolean endApplication = false;
		
		do 
		{
			// Going through all options available for user to choose 
			do 
			{
				System.out.print("What would you like to do?");
				System.out.print("\n" + "\t1. See the content of all Ticketbooths\n"
						+"\t2. See the content of one Ticketbooth\n"
						+ "\t3. List Ticketbooths with same amounts of tickets' values\n"
						+ "\t4. List Ticketbooths with same Tickets amount\n"
						+ "\t5. List Ticketbooths with same amount of tickets values and same number of OPUS cards\n"
						+ "\t6. Add a OPUS card to an existing Ticketbooth\n"
						+ "\t7. Remove an existing OPUS card from a Ticketbooth\n"
						+ "\t8. Update the expiry date of an existing OPUS card\n"
						+ "\t9. Add tickets to a Ticketbooth\n" + "\t0. To quit");
				
				System.out.print("\n\nPlease enter your choice and press <Enter>:");
				menu = keyboard.nextInt();
				
				if (menu < 0  || menu > 9) 
				{
					System.out.println("Sorry that is not a valid choice. Try again.\n");
				}
			} while (menu < 0 || menu > 9);

			// Verify which option the user selected
			switch (menu)
			{
			
			// Print out the content of all ticketbooths
            case 1:
                int i = 0;
                for (int j = 0; j < array.length; j++) {
                    String print = array[j].toString(i);
                    System.out.println(print);
                    i++;
                }
                break;

            // Print out the content of one ticketbooth
            case 2:
                menu = options(menu, "to see the content of");
                i = 0;
                for (int j = 0; j < array.length; j++) {
                    if(i == menu) {
                        String print = array[j].toString(i);
                        System.out.println(print);
                    }
                    i++;
                }
                break;
		
			// Print out the pairs of ticketbooths with the same total ticket's amount with the same price 
			case 3:
				System.out.println("List of Ticketbooths with same amount of money:\n");
				for (int j = 0; j < array.length; j++)
				{
					for (int k = 1 + j; k < array.length; k++)
					{
						if (array[j].valueTotal(array[k]))
						{
							System.out.println(
									"Ticketbooths " + j + " and " + k + " both have " + array[j].totalPrice());
						}
					}
				}
				System.out.println("");
				break;
				
			//Print out pairs of ticketbooths with the same ticket distribution	
			case 4:
				System.out.println("List of Ticketbooths with same Tickets amount:\n");
				for (int j = 0; j < array.length; j++)
				{
					for (int k = 1 + j; k < array.length; k++)
					{
						if (array[j].numberTickets(array[k]))
							System.out.println(
									"Ticketbooths " + j + " and " + k + " both have " + array[j].ticketBreakdown());
					}
				}
				System.out.println("");
				break;
			
			//Print out pairs of ticketbooth with the same ticket values and number of OPUS cards.
			case 5:
				System.out.println("List of Ticketbooths with same Tickets values and number of OPUS cards:\n");
				for (int j = 0; j < array.length; j++)
				{
					for (int k = 1 + j; k < array.length; k++)
					{
						if (array[j].equals(array[k]))
							System.out.println("Ticketbooths " + j + " and " + k);
					}
				}
				System.out.println("");
				break;
			
			//	Ask user which ticketbooth they want to add an OPUS card and its information and update that ticketbooth
			case 6:
				menu = options(menu, "to add an OPUS card to");
				keyboard.nextLine();
				
				System.out.print(" --> Type of OPUS card (STL, RTL, etc ..): ");
				option1 = keyboard.nextLine();
				
				System.out.print(" --> Full name on OPUS card: ");
				option2 = keyboard.nextLine();
				
				System.out.print("Expiry month number and year (seperate by a space): ");
				option3 = keyboard.nextInt();
				option4 = keyboard.nextInt();
				array[menu].newCard(option1, option2, option3, option4);
				
				System.out.println("You now have " + array[menu].numberOPUS() + " OPUS cards");
				break;
				
			// Ask user which ticketbooth they want to remove an OPUS card & the card index
			case 7:
				menu = options(menu, "to remove an OPUS card from");

				// Verify the number of OPUS card in an existing ticketbooth 
				if (array[menu].numberOPUS() == 0)
				{
					System.out.println("Sorry that Ticketbooth has no cards\n");
				} 
				else
				{
					do 
					{
						System.out.println("(Enter card number 0 to " + (array[menu].numberOPUS() - 1) + ")");
						optionCard = keyboard.nextInt();

						// check if there are an opus card that can be removed
						if (optionCard > array[menu].numberOPUS() || optionCard < 0)
						{
							System.out.println("Sorry but there is no Opus " + optionCard);
						}
					} 
					// remove card selected
					while (optionCard > array[menu].numberOPUS() || optionCard < 0);
					
					array[menu].removeCard(optionCard);
					System.out.println("Card removed successfully");
				}
				break;
				
			// 	Ask user the OPUS card they want to update the expiry date (month, year)
			case 8:
				menu = options(menu, "to update an OPUS card from");
				
				//check if there any OPUS card in the ticketbooth
				if (array[menu].numberOPUS() == 0)
				{
					System.out.println("There are no OPUS cards in the Ticketbooth\n");
				} 
				else 
				{
					do
					{
						System.out.println("(Enter card number 0 to " + (array[menu].numberOPUS() - 1) + ")");
						optionCard = keyboard.nextInt();
						
						// check if there are an opus card that can be updated
						if (optionCard > array[menu].numberOPUS() || optionCard < 0)
						{
							System.out.println("Sorry but there is no Opus " + optionCard);
						}

					} 
					// ask user to insert new month and year for the updated card
					while (optionCard > array[menu].numberOPUS() || optionCard < 0);

					System.out.print("Enter new expiry month number and year (seperate by space): ");
					option3 = keyboard.nextInt();     
					option4 = keyboard.nextInt();
					array[menu].updateMonthYear(option3, option4, optionCard);
					System.out.println("Expiry date updated");
				}
				break;
				
			// Ask user which ticketbooth's ticket and the number of tickets they want to add	
			case 9:
				
				menu = options(menu, "to add Tickets to");
				System.out.print(
						"How many regular, junior, senior, daily and weekly Tickets do you want to add? (Enter 5 numbers seperated by a space): ");
				// user input for the number of ticket for each type of ticket
				option3 = keyboard.nextInt();
				option4 = keyboard.nextInt();
				option5 = keyboard.nextInt();
				option6 = keyboard.nextInt();
				option7 = keyboard.nextInt();
				
				// add number of tickets inputed into the tickets of the ticketbooth
				array[menu].addTicket(option3, option4, option5, option6, option7);
				System.out.println("You now have $" + array[menu].totalPrice());
				break;
				
			//	User selection to end the program
			case 0:
				
				
				// Print out farewell message
				System.out.println("Thank you for using Concordia Fall Geek's Ticketbooth Application!");
				endApplication = true;
				break;
			default:
			}
		} 
		while (endApplication == false);
		
		//Scanner keyboard closed
		keyboard.close();
	}

	

	//Repeat message from the menu option
		public static int options(int menu, String print) 
		{

		Scanner keyboard = new Scanner(System.in);
		
		// Ask user which ticketbooth to select and observe its content
		do
		{
			System.out.print("Which Ticketbooth do you want " + print + "? (Enter number 0 to 4):");
			menu = keyboard.nextInt();
			if (menu < 0 || menu > 4)  
			{
				System.out.println("Sorry but there is no Ticketbooth number " + menu + "\n");
			}
		} 
		while (menu < 0 || menu > 4);
		return menu;
	}
	
	

}
