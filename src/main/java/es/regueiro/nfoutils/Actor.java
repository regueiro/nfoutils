package es.regueiro.nfoutils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import es.regueiro.nfoutils.interfaces.Cleanable;
import es.regueiro.nfoutils.internal.util.TagCleaner;

@XmlAccessorType(XmlAccessType.FIELD)
public class Actor implements Cleanable {
	private String name;
	private String role;
	private Integer order;
	@XmlElement(name = "thumb")
	private List<Thumb> thumbs;

	public Actor() {
		this.thumbs = new ArrayList<>();
	}

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

	public List<Thumb> getThumbs() {
		return thumbs;
	}

	public void setThumbs(List<Thumb> thumbs) {
		this.thumbs = thumbs;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, Actor.class);
	}

	@Override
	public String toString() {
		return "Actor [name=" + name + ", role=" + role + ", order=" + order + ", thumbs=" + thumbs + "]";
	}
}
