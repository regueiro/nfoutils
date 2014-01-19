package es.regueiro.nfoutils.internal.model;

import java.net.URL;

public class XbmcActor {
	private String name;
	private String role;
	private Integer order;
	private URL thumb;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public URL getThumb() {
		return thumb;
	}

	public void setThumb(URL thumb) {
		this.thumb = thumb;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Actor [name=" + name + ", role=" + role + ", order=" + order + ", thumb=" + thumb + "]";
	}

}
