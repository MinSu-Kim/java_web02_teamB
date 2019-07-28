package kr.or.yi.food_mgm_program.ui.content.statistics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

@SuppressWarnings("serial")
public class DateLabelFormatter extends AbstractFormatter {
	 private String datePattern = "yyyy-MM-dd";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
	@Override
	public Object stringToValue(String text) throws ParseException {
		// TODO Auto-generated method stub
		 return dateFormatter.parseObject(text);
	}

	@Override
	public String valueToString(Object value) throws ParseException {
		 if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

}
