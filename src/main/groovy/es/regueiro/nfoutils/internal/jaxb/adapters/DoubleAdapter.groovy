package es.regueiro.nfoutils.internal.jaxb.adapters

import javax.xml.bind.annotation.adapters.XmlAdapter
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class DoubleAdapter extends XmlAdapter<String, Double> {
	private static final separators = new DecimalFormatSymbols()
	private static formatter


	static {
		separators.decimalSeparator = '.' as char
		formatter = new DecimalFormat('0.000000', separators)
		formatter.groupingUsed = false
	}

	@Override
	Double unmarshal(String s) {
		Double.parseDouble s
	}

	@Override
	String marshal(Double d) {
		formatter.format d
	}
}
