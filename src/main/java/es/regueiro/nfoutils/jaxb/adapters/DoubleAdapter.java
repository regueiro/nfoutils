package es.regueiro.nfoutils.jaxb.adapters;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DoubleAdapter extends XmlAdapter<String, Double> {
	private static DecimalFormatSymbols separators = new DecimalFormatSymbols();
	private static NumberFormat formatter;
	static {
		separators.setDecimalSeparator('.');
		formatter = new DecimalFormat("0.000000", separators);
		formatter.setGroupingUsed(false);
	}

	@Override
	public Double unmarshal(String s) throws Exception {
		return Double.parseDouble(s);
	}

	@Override
	public String marshal(Double d) throws Exception {
		return formatter.format(d);
	}

}