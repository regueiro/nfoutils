package es.regueiro.nfoutils.model;

import java.net.URL;

public class Actor {
	private String name;
	private String role;
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

	@Override
	public String toString() {
		return "Actor [name=" + name + ", role=" + role + ", thumb=" + thumb + "]";
	}

}
