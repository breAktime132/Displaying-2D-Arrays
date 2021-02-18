/* [redacted], [redacted], and Peter.
(Names removed due to the abscence of developers' permissions).
   12/11/18 
   Java program that takes the userinput of a month year and day and prints out a calendar based on the input.
   Original Version - 12/11/18
*/
import java.util.Scanner;                                                                                                               // Allows for scanners to be used.
public class calendarDisplay2{                                                                                                          // File name.
   public static void main (String [] args){                                                                                            // Main method.
     Scanner input = new Scanner (System.in);                                                                                           // Creates a scanner that will be used within this method only.
     int Year = 0;                                                                                                                      //for century method
     int Month = 0;                                                                                                                     //for century method
     int monthKeyValue = 0;                                                                                                             // Needs to be changed
     int yearCode = 0;                                                                                                                  // Year code integer
     int Day = 0;                                                                                                                       // Userinput day 
     int dayCode = 0;                                                                                                                   // Day code integer
     // boolean isLeapYear = false;                                                                                                     // isLeapYear boolean for telling about leap year
     int monthnum = 0;                                                                                                                  // Month Number int
     int centurynum = 0;                                                                                                                // Integer for centuries
     String MonthTEXT = "";                                                                                                             // Creates a string for months
     String dayCodeString = "";                                                                                                         // New day Code String
     // boolean LeapYear =  false;                                                                                                      // Leap Year boolean for determining leap year
     int LCV = 0;                                                                                                                       // LCV for looping
     int LCV2 = 0;                                                                                                                      // LCV2 for looping
     System.out.println("Enter in a month (Number 1-12)");                                                                              // Tells user to enter a month
     Month = input.nextInt();                                                                                                           // Prompts userinput
     while(Month < 1 || Month > 12){                                                                                                    // Checks if the userinput is less than 1 or greater than 12
        System.out.println("ENTER A NUMBER FROM 1-12");                                                                                 // Tells user to re-enter
        Month = input.nextInt();                                                                                                        // Prompts userinput
     }
     System.out.println("Enter in a year (Number 1775-2100)");                                                                          // Tells user to enter a year
     Year = input.nextInt();                                                                                                            // Prompts userinput
     while(Year < 1775 || Year > 2100){                                                                                                 // Checks if the userinput is less than 1775 or greater than 2100
        System.out.println("ENTER A NUMBER FROM 1775-2100");                                                                            // Tells user to re-enter
        Year = input.nextInt();                                                                                                         // Prompts userinput
     }
     int[][] DaysOfTheMonthArray = new int [7][6];                                                                                      // Creates the Array
     // isLeapYear = findLeapYear(Year);                                                                                                // Gets isLeapYear from findleapyear method
     MonthTEXT = MonthIdentifier(Month);                                                                                                // Gets the month validation from method
     monthnum = months(Month);                                                                                                          // Gets monthnum from months method
     yearCode = centurys(Year);                                                                                                         // Gets yearcode from century method
     monthKeyValue = months(Month);                                                                                                     // Gets monthkeyvalue from months method
     centurynum = centurys(Year);                                                                                                       // Gets centurynum from century method          
     System.out.println(MonthTEXT + Year);                                                                                              // Prints out the Month and Year
     System.out.println("-------------------");                                                                                         // Prints out a seperation line
     System.out.println(" Su Mo Tu We Th Fr Sa");                                                                                       // Prints out the days
     dayCodeString = getStartDay(Year, Month);                                                                                          // Gets daycodestring from getStartDay method
}
public static String MonthIdentifier (int Month){                                                                                       // New MonthIdentifier method
   String MonthTEXT = "";                                                                                                               // Creates a new string called MonthTEXT
   switch (Month){                                                                                                                      // Begins case statements
      case 1: MonthTEXT = "   January ";                                                                                                // If the input is 1 the String is January
         break;                                                                                                                         // Breaks from switch.
      case 2: MonthTEXT = "   Feburary ";                                                                                               // If the input is 2 the String is Feburary
         break;                                                                                                                         // Breaks from switch.
      case 3: MonthTEXT = "    March ";                                                                                                 // If the input is 3 the String is March
         break;                                                                                                                         // Breaks from switch.
      case 4: MonthTEXT = "    April ";                                                                                                 // If the input is 4 the String is April
         break;                                                                                                                         // Breaks from switch.
      case 5: MonthTEXT = "     May ";                                                                                                  // If the input is 5 the String is May
         break;                                                                                                                         // Breaks from switch.
      case 6: MonthTEXT = "     June ";                                                                                                 // If the input is 6 the String is June
         break;                                                                                                                         // Breaks from switch.
      case 7: MonthTEXT = "     July ";                                                                                                 // If the input is 7 the String is July
         break;                                                                                                                         // Breaks from switch.
      case 8: MonthTEXT = "    August ";                                                                                                // If the input is 8 the String is August
         break;                                                                                                                         // Breaks from switch.
      case 9: MonthTEXT = "  September ";                                                                                               // If the input is 9 the String is September
         break;                                                                                                                         // Breaks from switch.
      case 10: MonthTEXT = "   October ";                                                                                               // If the input is 10 the String is October
         break;                                                                                                                         // Breaks from switch.
      case 11: MonthTEXT = "   November ";                                                                                              // If the input is 11 the String is November
         break;                                                                                                                         // Breaks from switch.
      case 12: MonthTEXT = "   December ";                                                                                              // If the input is 12 the String is December
         break;                                                                                                                         // Breaks from switch.
     }
   return MonthTEXT;                                                                                                                    // Returns the String
}
public static String getStartDay(int year, int month){                                                                                  // Determines the day the month entered by the user starts on.
   Scanner input = new Scanner (System.in);                                                                                             // Creates a scanner to receive user input for only this method.                                               
      int temp = 0;                                                                                                                     // Used to store the original value of year before it is divided by 4.
      int dayOfMonth = 1;                                                                                                               // The day of the month is always 1, as the month begins on day 1.
      int dayCode = 0;                                                                                                                  // Stores the code found after getStartDay is finished, which is the remainder of the equation that translates into a day of the week.
      int k = 0;                                                                                                                        // Last two digits of the year.
      int j = 0;                                                                                                                        // First two digits of the year.
      String dayCodeString = "";                                                                                                        // Stores the string that correlates with the weekday that the number represents.
      if(month == 1){                                                                                                                   // If it is the first month of the year...
         month = 13;                                                                                                                    // The variable month becomes equal to 13.
         year--;                                                                                                                        // The year input decreases by 1.
      }else if(month == 2){                                                                                                             // If it is the second month of the year...
         month = 14;                                                                                                                    // The variable month becomes equal to 14.
         year--;                                                                                                                        // The year input decreases by 1.
      }
      k = year % 100;                                                                                                                   // The variable k stores the last two digits of the year.
      j = (int)(year / 100);                                                                                                            // The variable j stores the first two digits of the year.
      int dayOfWeek = (int)(dayOfMonth + (int) ((month + 1) * 26.0 / 10) + k + (int)(k / 4.0) + (int)(j / 4.0) + 5 * j) % 7;            // Gets the day of the week the month starts on.
      if(dayOfWeek == 1){                                                                                                               // If the day code passed is 1...
         dayCodeString = "Sunday";                                                                                                      // The string variable dayCodeString is "Sunday".
      }else if(dayOfWeek == 2){                                                                                                         // If the code passed is 2...
         dayCodeString = "Monday";                                                                                                      // The variable is "Monday."
      }else if(dayOfWeek == 3){                                                                                                         // If the code passed is 3...
         dayCodeString = "Tuesday";                                                                                                     // The variable is "Tuesday."
      }else if(dayOfWeek == 4){                                                                                                         // If the code passed is 4.
         dayCodeString = "Wednesday";                                                                                                   // The variable is "Wednesday."
      }else if(dayOfWeek == 5){                                                                                                         // If the code passed is 5...
         dayCodeString = "Thursday";                                                                                                    // The variable is "Thursday."
      }else if(dayOfWeek == 6){                                                                                                         // If the code passed is 6...
         dayCodeString = "Friday";                                                                                                      // The variable is "Friday."
      }else if(dayOfWeek == 0){                                                                                                         // If the code passed is 0...
         dayCodeString = "Saturday";                                                                                                    // The variable is "Saturday."
      }
      fillCalendar(dayCodeString, month);                                                                                               // Passes the month key value and the string determined by the comparison above.
      return dayCodeString;                                                                                                             // Returns the string to the main method.
   }
   public static void fillCalendar(String dayCodeString, int monthnum){                                                                 // Takes the day of the week and counts backwards. Example: The day is Wednesday. The array starts filling from Wednesday forward.
      int[][] array = new int[6][7];                                                                                                    // Creates an array with 6 rows and 7 columns.
      int LCV = 0;                                                                                                                      // Loop Control Variable for columns within the array passed.
      int LCV2 = 0;                                                                                                                     // Loop Control Variable for rows within the array passed.
      int count2 = 1;                                                                                                                   // Value that increases by one for every column and each column is set equall to, making the days of the calendar 1-31.
      int numberOfDays = 0;                                                                                                             // Stores the number of days for the month passed.
      int dayCode = 0;                                                                                                                  // Stores the integer for the day of the week according to the Key Value Method.
      if(dayCodeString == "Sunday"){                                                                                                    // Takes the string return value, passed as dayCodeString, and asks if the string returned is "Sunday".
         dayCode = 0;                                                                                                                   // If the string return value is "Sunday," then the code for that day zero.
      }else if(dayCodeString == "Monday"){                                                                                              // If the string return value is "Monday"...
         dayCode = 1;                                                                                                                   // The variable dayCode is equal to 1.
      }else if(dayCodeString == "Tuesday"){                                                                                             // If the string return value is "Tuesday"...
         dayCode = 2;                                                                                                                   // The variable dayCode is equal to 2.
      }else if(dayCodeString == "Wednesday"){                                                                                           // If the string return value is "Wednesday"...
         dayCode = 3;                                                                                                                   // The variable dayCode is equal to 3.
      }else if(dayCodeString == "Thursday"){                                                                                            // If the string return value is "Thursday"...
         dayCode = 4;                                                                                                                   // The variable dayCode is equal to 4.
      }else if(dayCodeString == "Friday"){                                                                                              // If the string return value is "Friday"...
         dayCode = 5;                                                                                                                   // The variable dayCode is equal to 5.
      }else if(dayCodeString == "Saturday"){                                                                                            // If the string return value is "Saturday"...
         dayCode = 6;                                                                                                                   // The variable dayCode is equal to 6.
      }
      if(monthnum == 12){                                                                                                               // If the month passed is 12...
         numberOfDays = 32;                                                                                                             // The number of days in that month is 32 (see asterisk).
      }else if(monthnum == 13){                                                                                                         // If the month passed is 13...
         numberOfDays = 32;                                                                                                             // The number of days in that month is 32 (see asterisk).
      }else if(monthnum == 14){                                                                                                         // If the month passed is 14...
         numberOfDays = 31;                                                                                                             // The number of days in that month is 31 (see asterisk).
      }else if(monthnum == 3){                                                                                                          // If the month passed is 3...
         numberOfDays = 32;                                                                                                             // The number of days in that month is 32 (see asterisk).
      }else if(monthnum == 4){                                                                                                          // If the month passed is 4...
         numberOfDays = 31;                                                                                                             // The number of days in that month is 31 (see asterisk).
      }else if(monthnum == 5){                                                                                                          // If the month passed is 5...
         numberOfDays = 32;                                                                                                             // The number of days in that month is 32 (see asterisk).
      }else if(monthnum == 6){                                                                                                          // If the month passed is 6...
         numberOfDays = 31;                                                                                                             // The number of days in that month is 31 (see asterisk).
      }else if(monthnum == 7){                                                                                                          // If the month passed is 7...
         numberOfDays = 32;                                                                                                             // The number of days in that month is 32 (see asterisk).
      }else if(monthnum == 8){                                                                                                          // If the month passed is 8...
         numberOfDays = 32;                                                                                                             // The number of days in that month is 32 (see asterisk).
      }else if(monthnum == 9){                                                                                                          // If the month passed is 9...
         numberOfDays = 31;                                                                                                             // The number of days in that month is 31 (see asterisk).
      }else if(monthnum == 10){                                                                                                         // If the month passed is 10...
         numberOfDays = 32;                                                                                                             // The number of days in that month is 32 (see asterisk).
      }else if(monthnum == 11){                                                                                                         // If the month passed is 11...
         numberOfDays = 31;                                                                                                             // The number of days in that month is 31 (see asterisk).
      }
      // * The variable numberOfDays is increased by 1 because the if statement in the column loop checks to see if the values being filled in have reached the number of days in the month. The last value (the day of the month) will not be printed out because the != will not allow that final value to be filled into the column
      for(LCV2 = 0; LCV2 < 6; LCV2++){                                                                                                  // 2D row loop.
         if(LCV2 == 1){                                                                                                                 // If the first loop is done, there should be no offset.
            dayCode = 0;                                                                                                                // Therefore, dayCode becomes equal to zero.
         }
         for(LCV = dayCode; LCV < 7; LCV++){                                                                                            // 2D column loop.
            if(count2 != numberOfDays){                                                                                                 // If the value inside each column is not equal to the number of days (to fill the number of days for the month)...
               array[LCV2][LCV] = count2;                                                                                               // Places count in the column selected.
               count2++;                                                                                                                // The variable count increments by 1.
            }
         }
      }
      for(LCV2 = 0; LCV2 < 6; LCV2++){                                                                                                  // 2D row loop.
         for(LCV = 0; LCV < 7; LCV++){                                                                                                  // 2D column loop.
            if(array[LCV2][LCV] == 0){                                                                                                  // If the element in a column will be zero...
               System.out.print("   ");                                                                                                 // Three spaces are printed.
            }else if(array[LCV2][LCV] / 10 == 0 && array[LCV2][LCV] != 0){                                                              // If the element has a single digit number other than zero.
               System.out.print("  " + array[LCV2][LCV]);                                                                               // Two spaces followed by the number is printed.
            }else if(array[LCV2][LCV] / 10 != 0 && array[LCV2][LCV] != 0){                                                              // If the element is a two digit number and is not zero...
               System.out.print(" " + array[LCV2][LCV]);                                                                                // One space followed by the number is printed.
            }
         }
         System.out.println();                                                                                                          // Creates a seperate line for each row.
      }
   }    
   public static int months(int Month) {                                                                                                //method block
      int monthnum = 0;                                                                                                                 //int variable
      switch(Month){                                                                                                                    //switch statement11
         case 1: if(Month == 1){                                                                                                        //case statement
                    monthnum = 1;                                                                                                       //keyvalue for month
                 }
                 break;                                                                                                                 //breaks the case statement to go to the next one
         case 2: if(Month == 2){                                                                                                        //case statement
                    monthnum = 4;                                                                                                       //keyvalue for month
                 }
                 break;                                                                                                                 //breaks the case statement to go to the next one
         case 3: if(Month == 3){                                                                                                        //case statement
                    monthnum = 4;                                                                                                       //keyvalue for month
                 }
                 break;                                                                                                                 //breaks the case statement to go to the next one
         case 4: if(Month == 4){                                                                                                        //case statement
                    monthnum = 0;                                                                                                       //keyvalue for month
                 }
                 break;                                                                                                                 //breaks the case statement to go to the next one
         case 5: if(Month == 5){                                                                                                        //case statement
                    monthnum = 2;                                                                                                       //keyvalue for month
                 }
                 break;                                                                                                                 //breaks the case statement to go to the next one
         case 6: if(Month == 6){                                                                                                        //case statement
                    monthnum = 5;                                                                                                       //keyvalue for month
                 }
                 break;                                                                                                                 //breaks the case statement to go to the next one
         case 7: if(Month == 7){                                                                                                        //case statement
                    monthnum = 0;                                                                                                       //keyvalue for month
                 }
                 break;                                                                                                                 //breaks the case statement to go to the next one
         case 8: if(Month == 8){                                                                                                        //case statement
                    monthnum = 3;                                                                                                       //keyvalue for month
                 }
                 break;                                                                                                                 //breaks the case statement to go to the next one
         case 9: if(Month == 9){                                                                                                        //case statement
                    monthnum = 6;                                                                                                       //keyvalue for month
                 }
                 break;                                                                                                                 //breaks the case statement to go to the next one
         case 10:if(Month == 10){                                                                                                       //case statement
                    monthnum = 1;                                                                                                       //keyvalue for month
                 }
                 break;                                                                                                                 //breaks the case statement to go to the next one
         case 11:if(Month == 11){                                                                                                       //case statement
                    monthnum = 4;                                                                                                       //keyvalue for month
                 }
                 break;                                                                                                                 //breaks the case statement to go to the next one
         case 12:if(Month == 12){                                                                                                       //case statement
                    monthnum = 6;                                                                                                       //keyvalue for month
                 }
      }
      return monthnum;                                                                                                                  //returns keyvalue to main string
   }
   // public static boolean findLeapYear(int year){                                                                                     // Determines whether the year passed is a leap year.
      // boolean isLeapYear = false;                                                                                                    // Starts as false to be proven true.
      // if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){                                                                     // If the year is divisible by 400 or it is divisible by 4 and not 100.
         // isLeapYear = true;                                                                                                          // The year is a leap year.
      // }
      // return isLeapYear;                                                                                                             // The boolean isLeapYear is returned to the main method.
   // }
public static int centurys(int Year) {                                                                                                  //method block
   int centurynum = 0;
   int lcv = 0;
   switch(Year){                                                                                                                        //switch statement
      case 1: lcv = 0;
      while(Year < 1700){                                                                                                               //while statement
         Year = Year + 400;                                                                                                             //used to get within year limit
         if(Year > 1700){                                                                                                               //if statement
            centurynum = 4;                                                                                                             //keyvalue
         }
         lcv++;                                                                                                                         //lcv for while loop
      }
      break;                                                                                                                            //breaks the case statement to go to the next one
      case 2: if((Year > 1699)&&(Year < 1800)){                                                                                         //case statement
                 centurynum = 4;                                                                                                        //keyvalue
              }
              break;                                                                                                                    //breaks the case statement to go to the next one
      case 3: if((Year > 1799)&&(Year < 1900)){                                                                                         //case statement
                 centurynum = 2;                                                                                                        //keyvalue
              }
              break;                                                                                                                    //breaks the case statement to go to the next one
      case 4: if((Year > 1899)&&(Year < 2000)){                                                                                         //case statement
                 centurynum = 0;                                                                                                        //keyvalue
              }
              break;                                                                                                                    //breaks the case statement to go to the next one
      case 5: if((Year > 1999)&&(Year < 3000)){                                                                                         //case statement
                 centurynum = 6;                                                                                                        //keyvalue
              }
              break;                                                                                                                    //breaks the case statement to go to the next one
      case 6: lcv = 0;
              while(Year > 3000){                                                                                                       //case statement
                 Year = Year - 400;                                                                                                     //used to get within year limit
                 if(Year < 3000){                                                                                                       //if statement
                    centurynum = 6;                                                                                                     //keyvalue
                 }
                 lcv++;                                                                                                                 //lcv for while loop
              }
   }
   return centurynum;                                                                                                                   //returns key value to main string
}
}
