package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HourContract {

	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	public HourContract(){
		
	}


	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getValuePerHour() {
		return valuePerHour;
	}


	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}


	public Integer getHours() {
		return hours;
	}


	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public double totalValue() {
		return valuePerHour * hours;
	}


	@Override
	public String toString() {
		return "Date= " + sdf.format(date) 
				+ ", valuePerHour= " + valuePerHour 
				+ ", hours=" + hours;
				
	}
	
	
}
