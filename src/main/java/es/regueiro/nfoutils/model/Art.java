package es.regueiro.nfoutils.model;

public class Art {

	private String fanart;
	private String poster;

	public String getFanart() {
		return fanart;
	}

	public void setFanart(String fanart) {
		this.fanart = fanart;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Override
	public String toString() {
		return "Art [fanart=" + fanart + ", poster=" + poster + "]";
	}

}
