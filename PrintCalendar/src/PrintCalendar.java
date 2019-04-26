import java.util.Scanner;

public class PrintCalendar
{
	public static void main(String[] args)
	{
		Scanner readInput = new Scanner(System.in);
		
		//Getting the input from the user
		try
		{
		System.out.print("Enter the number of year (e.g., 2018): ");
	    int year = readInput.nextInt();
	    //Below code will verify the user input
	    while (!isValidYear(year))
	    {
	    	System.out.println("Invalid Year!");
			System.out.print("Enter the number of year again... (e.g., 2018): ");
		    year = readInput.nextInt();
	    }
	     
	    System.out.print("Enter the number of month in between 1 and 12: ");
	    int month = readInput.nextInt();
	    
	    while(!isValidMonth(month))
	    {
	    	System.out.println("Invalid Month!");
		    System.out.print("Enter the number of month in between 1 and 12 again...: ");
		    month = readInput.nextInt();
	    }
	    //Below code will print the calendar
		System.out.println("末末末末末末末末末末末末末末�");
	    printMonth(year,month);
		System.out.println("末末末末末末末末末末末末末末�");
		}
		
		catch (Exception e)
		{
			System.out.println("Only numbers!");
			PrintCalendar.main(args);
		}
	}
	
	/*METHOD TO PRINT THE CALENDAR*/
	static void printMonth(int year, int month)
	{
		printMonthTitle(year, month); //to print the Title e.g., January 2018
		printMonthBody(year, month); //to print the calendar
	}
	
	/*METHOD 1/2 TO PRINT THE TITLE OF THE CALENDAR*/
	static void printMonthTitle(int year, int month)
	{
	    System.out.println( "         " + getmonthString(month) + "#" + year); 
		System.out.println("末末末末末末末末末末末末末末�");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}
	
	/*METHOD TO GET THE NAME OF THE MONTH BASED UPON THE USER INPUT*/
	static String getmonthString(int month)
	{
		String monthString = null;
		String[] months = {"January", "February", "March", "April", "May", "June",
				"July", "August", "Septemter", "October", "November", "December"};
		monthString = months[month-1];
		return monthString;
	}
	
	/*METHOD 2/2 TO FILL THE CALENDAR WITH THE DATES*/
	static void printMonthBody(int year, int month) 
	{
		int firstDay = getStartDay(year, month); //This method will return the first day of the month 
		int totalDaysInMonth = getNumberOfDaysInMonth(year, month); // This Method will return the total number of days in a given month
		
		int i = 0;
		for (i = 0; i < firstDay; i++)
		{
			System.out.print("    ");
		}

	    for (i = 1; i <= totalDaysInMonth; i++)
	    {
			if (i < 10) // TO format the output for number that have only only digit 
			{
				System.out.print("   " + i);
			}
			
			else // adding two space for number that have two digits
			{
				System.out.print("  " + i);
			}
			
			if ((i + firstDay) % 7 == 0) // if week is filled break to the next line
			{
				System.out.println();
			}
	    }
	    
	    System.out.println();
	}
	
	/*METHOD THAT RETURNS THE DATE TO START FILLING THE CALENDAR WITH*/
	static int getStartDay(int year, int month)
	{
		int firstDay = 1;
		int totalDaysInMonth = getTotalNumberOfDays(year, month); //get the total number if days in a month
		return (totalDaysInMonth + firstDay) % 7; // return the days to start the calendar.
	}
	
	/*METHOD TO GET THE TOTAL NUMBER OF DAYS IN A YEAR*/
	static int getTotalNumberOfDays(int year, int month)
	{
		int total = 0;
		for (int i = 1; i < year; i++)
		{
			if (isLeapYear(i))
			{
				total = total + 366;
			}
			else
			{
				total = total + 365;
			}
		}
		
		//Adding the number of the days with that of the months
		for (int i = 1; i < month; i++) 
		{
			total = total + getNumberOfDaysInMonth(year, i);
		}
		return total;
	}
	
	/*METHOD TO GET THE TOTAL NUMBER OF DAYS IN ANY GIVEN MONTH*/
	static int getNumberOfDaysInMonth(int year, int month)
	{
		int daysInMonth = 0;
		if (month == 1 || month == 3 || month == 5 || month == 7 ||month == 8 || month == 10 || month == 12) 
		{
			daysInMonth = 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11)
		{
			daysInMonth = 30;
		}
		if (month == 2)
		{
			if(isLeapYear(year))
			{
				daysInMonth = 29;
			}
			else
			{
				daysInMonth = 28;
			}
		}
		
		return daysInMonth;
	}
	
	/*METHOD TO CHECK WETHER THE GIVEN YEAR IS A LEAP YEAR OR NOT*/
	static boolean isLeapYear(int year) 
	{
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*METHOD TO CHECK THE CORRECT INPUT OF THE YEAR*/
	public static boolean isValidYear(int year)
	{
		return year > 0;
	}
	
	/*METHOD TO CHECK THE CORRECT INPUT OF THE MONTH*/
	public static boolean isValidMonth(int month)
	{
		return month > 0 && month <= 12;
	}
}
