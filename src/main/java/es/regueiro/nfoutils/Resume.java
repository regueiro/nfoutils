package es.regueiro.nfoutils;

public class Resume {
	private Double position;
	private Double total;

	public Double getPosition() {
		return position;
	}

	public void setPosition(Double position) {
		this.position = position;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Resume [position=" + position + ", total=" + total + "]";
	}

}
