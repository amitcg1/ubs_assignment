package com.ubs.opsit.interviews;

public class TimeConverterImpl implements TimeConverter {

	// converting time
	String convertTime(String aTime){
    	int hour = 00;
    	int min= 00;
    	int sec= 00;
    	
    	// Call to a method for setting hour, min and sec from given time string
    	setTime(aTime, hour, min, sec)

    	// Calls for setting individual rows in berlin clock
    	String firstRow = getFirstRow(sec);
    	String secondRow = getSecondRow(hour);
    	String thirdRow = getThirdRow(hour);
    	String forthRow = getFourthRow(min);
    	String fifthRow = getFifthRow(min);
    	
    	// setting final string value to berlin clock
    	String berlinClockOutut = firstRow + secondRow + thirdRow + forthRow + fifthRow;
    	
    	return berlinClockOutut;
    			
    }

	/**
	 * This method accepts input in string format and sets value for hour, minute and seconds
	 */
	public setTime(String aTime, int hour, int min, int sec){
    	String inputTime=aTime;
  		String[] time=inputTime.split(":");
  		hour=Integer.parseInt(time[0].trim());
  		min=Integer.parseInt(time[1].trim());
  		sec=Integer.parseInt(time[2].trim());
    }

	/**
	 * Setting value for first row
	 */
	public String getFirstRow(int sec) {
		if (sec%2==0) {
			return "Y\n";
		} else {
			return "O\n";
		}
	}

	/**
	 *  Setting value for second row
	 */
	public String getSecondRow(Integer hour) {
		Integer bulbToGlow=hour/5;
		StringBuilder secondRow=new StringBuilder("0000\n");
		for (int i=0;i<bulbToGlow;i++) {
			secondRow.setCharAt(i,'R');
		}
		return secondRow.toString();
	}

	/**
	 *  Setting value for third row
	 */
	public String getThirdRow(Integer hour) {
		Integer bulbToGlow=hour%5;
		StringBuilder thirdRow=new StringBuilder("0000\n");
		for (int i=0;i<bulbToGlow;i++) {
			thirdRow.setCharAt(i,'R');
		}
		return thirdRow.toString();
	}

	/**
	 *  Setting value for forth row
	 */
	public String getFourthRow(int minute) {
		Integer bulbToGlow=minute/5;
		StringBuilder forthRow=new StringBuilder("00000000000\n");
		for (int i=0;i<bulbToGlow;i++) {
			forthRow.setCharAt(i,'Y');
			if (i>0&&i%3==0) {
				forthRow.setCharAt(i-1,'R');
			}
		}
		return forthRow.toString();
	}

	/**
	 *  Setting value for fifth row
	 */
	public String getFifthRow(int minute) {
		Integer bulbToGlow=minute%5;
		StringBuilder fifthRow=new StringBuilder("0000\n");
		for (int i=0;i<bulbToGlow;i++) {
			fifthRow.setCharAt(i,'Y');
		}
		return fifthRow.toString();
	}

}
