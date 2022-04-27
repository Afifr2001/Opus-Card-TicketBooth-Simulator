public class Ticketbooth
{

	// Initialize variable attributes
	private Tickets ticket;
	private OPUSCard[] opus;

	// Default constructor
	public Ticketbooth() {
	}

	// Constructor to set initial value of the two attributes
	public Ticketbooth(Tickets ticket, OPUSCard[ ] opus) 
	{

		this.ticket = ticket;
		this.opus = opus;

	}

	// Method returning true for the total value of tickets from two Ticketbooth to be equal
	public boolean valueTotal(Ticketbooth t1) 
	{
		return (t1.totalPrice() == this.totalPrice());
	}

	// Method returning true for the number of ticket of each type of tickets to be equal
	public boolean numberTickets(Ticketbooth t1)
	{
		return (t1.ticket.equals(this.ticket));

	}

	// Method returning the total price of the tickets in a ticketbooth
	public double totalPrice() 
	{

		double totalPrice = ticket.totalTickets();
		return totalPrice;
	}

	// method returning the number of OPUS cards in a ticketbooth
	public int numberOPUS() 
	{

		int opusCardNbrs = 0;
		if (opus == null) 
		{
			opusCardNbrs = 0;
		} else
		{
			for (int i = 0; i < opus.length; i++) 
			{
				opusCardNbrs++;
			}
		}
		return opusCardNbrs;
	}

	// Method to add a new OPUS card to a ticketbooth
	public void newCard(String cardType, String name, int monthExp, int yearExp) 
	{

		OPUSCard newCard[] = new OPUSCard[this.opus.length + 1];
		for (int i = 0; i < newCard.length; i++) 
		{
			if (i == newCard.length - 1)
			{
				newCard[i] = new OPUSCard(cardType, name, monthExp, yearExp);
			} else {
				newCard[i] = opus[i];
			}
		}
		this.opus = newCard;
	}

	// Method for removing an OPUS card from a ticketbooth
	public void removeCard(int nbrElements) 
	{

		OPUSCard[] newCard = new OPUSCard[this.opus.length - 1];
		for (int i = 0, j = 0; i < this.opus.length; i++)
			if (i != nbrElements) 
			{
				newCard[j] = this.opus[i];
				j++;
			}
			this.opus = newCard;
	}

	// Method to update the expiration (month,year) date of an OPUS card
	public void updateMonthYear(int updateMonth, int updateYear, int nbrElements)
	{
		opus[nbrElements].setMonthExpiration(updateMonth);
		opus[nbrElements].setYearExpiration(updateYear);
	}

	// Method to add tickets to a ticketbooth and change the new total value of ticket's amount in the ticketbooth
	public void addTicket(int regular, int junior, int senior, int daily, int weekly) 
	{
		this.ticket.addTickets(regular, junior, senior, daily, weekly);
	}

	// Method returning true when the total value of tickets and number of OPUS cards tickets from two ticketbooth
	public boolean equals(Ticketbooth object) 
	{
		return (object.numberOPUS() == this.numberOPUS() && object.totalPrice() == this.totalPrice()); 
		
	}

	// Method returning string with number of each ticket and details of each OPUS card in the ticketbooth 
	public String toString(int boothNbr) 
	{

		String ticketNbrDetail = "";
		if (opus == null)
		{
			ticketNbrDetail = "Ticketbooth #" + boothNbr + "\n" + ticket.toString() + "\n" + "No OPUS cards\n";
		} else 
		{
			ticketNbrDetail = "Ticketbooth #" + boothNbr + "\n" + ticket.toString() + "\n";
			for (int i = 0; i < opus.length; i++)
			{
				if (opus[i] == null)
				{
					ticketNbrDetail += "";
				} else {
					ticketNbrDetail += opus[i].toString() + "\n";
				}
			}
		}
		return ticketNbrDetail;

	}

	// Method returning a string with the breakdown of the tickets
	public String ticketBreakdown() 
	{
		return ticket.toString();
	}

}
