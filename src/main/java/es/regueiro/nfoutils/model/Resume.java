package es.regueiro.nfoutils.model;

public class Resume {
	private String position;
	private String total;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Resume [position=" + position + ", total=" + total + "]";
	}

}
