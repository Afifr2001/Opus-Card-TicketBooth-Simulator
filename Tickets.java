public class Tickets 
{

	
	// Initialize variables for the types of tickets
	private int regularAmount, juniorAmount, seniorAmount, dailyAmount, weeklyAmount;

	// Static constants for the values of each type of tickets
	private static double tktRegular = 3.50, tktJunior = 2.50, tktSenior = 1.00, tktDaily = 10, tktWeekly = 40;

	//Default constructor
	public Tickets() {
	}

	//Constructor for parameters for number of each ticket in the ticketbooth
	public Tickets(int regularAmount, int juniorAmount, int seniorAmount, int dailyAmount, int weeklyAmount) 
	{

		this.regularAmount = regularAmount;
		this.juniorAmount = juniorAmount;
		this.seniorAmount = seniorAmount;
		this.dailyAmount = dailyAmount;
		this.weeklyAmount = weeklyAmount;
	}

	//Copy constructor of type Tickets
	public Tickets(Tickets another) 
	{

		regularAmount = another.regularAmount;
		juniorAmount = another.juniorAmount;
		seniorAmount = another.seniorAmount;
		dailyAmount = another.dailyAmount;
		weeklyAmount = another.weeklyAmount;
	}

	// Accessor and mutator methods for non-constant attributes
	public int getRegularAmount() 
	{
		return regularAmount;
	}

	public void setRegularAmount(int regularAmount) 
	{
		this.regularAmount = regularAmount;
	}

	public int getJuniorAmount() 
	{
		return juniorAmount;
	}

	public void setJuiorAmount(int juniorAmount) 
	{
		this.juniorAmount = juniorAmount;
	}

	public int getSeniorAmount()
	{
		return seniorAmount;
	}

	public void setSeniorAmount(int seniorAmount) 
	{
		this.seniorAmount = seniorAmount;
	}

	public int getDailyAmount() 
	{
		return dailyAmount;
	}

	public void setDailyAmount(int dailyAmount)
	{
		this.dailyAmount = dailyAmount;
	}

	public int getWeeklyAmount() 
	{
		return weeklyAmount;
	}

	public void setWeeklyAmount(int weeklyAmount)
	{
		this.weeklyAmount = weeklyAmount;
	}
	

	// Method with 5 parameters type integer to increase number of each tickets by number indicated
	public void addTickets(int regular, int junior, int senior, int daily, int weekly)
	{

		this.regularAmount += regular;
		this.juniorAmount += junior;
		this.seniorAmount += senior;
		this.dailyAmount += daily;
		this.weeklyAmount += weekly;

	}

	// Method returning double with the total value of the tickets in the ticketbooth
	public double totalTickets() 
	{
		double total = regularAmount * tktRegular + 
				juniorAmount * tktJunior 
				+ seniorAmount * tktSenior 
				+ dailyAmount * tktDaily
				+ weeklyAmount * tktWeekly;
		return total;
	}

	// Method returning indicating clearly the count of each ticket in the ticketbooth
	public String toString() 
	{
		return regularAmount+" x $3.50 +" + " "+juniorAmount
				+" x $2.50 + "+seniorAmount+" x $1.0 + "+dailyAmount
				+" x $10 + "+weeklyAmount+" x $40";

	}

	// Method returning true when comparing two tickets and having the same breakdown 
	public boolean equals(Tickets another)
	{
		return (regularAmount == another.regularAmount && juniorAmount == another.juniorAmount && seniorAmount == another.seniorAmount && dailyAmount == another.dailyAmount
				&& weeklyAmount == another.weeklyAmount); 
		
	}

}

