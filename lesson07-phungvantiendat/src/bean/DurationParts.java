package bean;

public class DurationParts {
	int years;
	int months;
	int days;
	int hours;
	int minutes;
	int seconds;
	
	public DurationParts(int y, int mo, int d, int h, int mi, int s) {
        years = y; 
        months = mo; 
        days = d; 
        hours = h; 
        minutes = mi; 
        seconds = s;
    }

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	
}
