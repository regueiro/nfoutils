package es.regueiro.nfoutils.model;

public class Resume {
	private Float position;
	private Float total;

	public Float getPosition() {
		return position;
	}

	public void setPosition(Float position) {
		this.position = position;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Resume [position=" + position + ", total=" + total + "]";
	}

}
