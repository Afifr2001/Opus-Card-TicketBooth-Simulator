public class OPUSCard 
{

	// initialize variables for the type of card type, the name of the holder, and the expiry month and year
	private String cardType;
	private String name;
	private int monthExp, yearExp;

	// Default void constructor
	public OPUSCard() 
	{
	}

	public OPUSCard(String cardType, String name, int monthExp, int yearExp) 
	{

		this.cardType = cardType;
		this.name = name;
		this.monthExp = monthExp;
		this.yearExp = yearExp;
	}

	// Copy constructor
	public OPUSCard(OPUSCard card)
	{

		cardType = card.cardType;
		name = card.name;
		monthExp = card.monthExp;
		yearExp = card.yearExp;

	}

	// Accessor methods for all fo the atttributes 
	public String getCardType()
	{
		return cardType;
	}

	public String getName() 
	{
		return name;
	}

	public int getMonthExpiration()
	{
		return monthExp;
	}

	public int getYearExpiration() 
	{
		return yearExp;
	}

	// Mutator methods only for the expiry month and year
	public void setMonthExpiration(int newMonth)
	{

		this.monthExp = newMonth;

		if (monthExp < 1 || monthExp > 12)
		{
			this.monthExp = 0;
		}

	}

	public void setYearExpiration(int newYear) 
	{

		this.yearExp = newYear;
	}

	// Method returning a string with the type of OPUS card, name of the holder and the expiration date
	public String toString() 
	{
		if (monthExp < 10)
		{
			return cardType + ". " + name + "-0" + monthExp + "/" + yearExp;
			
		} else 
		{
			return cardType + ". " + name + "-" + monthExp + "/" + yearExp;
		}
	}

	// Method return true if two OPUS card have the same information
	public boolean equals(OPUSCard card) 
	{
		return (card==this);
	}
}
