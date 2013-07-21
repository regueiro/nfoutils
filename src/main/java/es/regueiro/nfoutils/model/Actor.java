package es.regueiro.nfoutils.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Actor {
	private String name;
	private Collection<ActorRole> roles;

	public Actor() {
		this.roles = new ArrayList<>();
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the role
	 */
	public Collection<ActorRole> getRoles() {
		return Collections.unmodifiableCollection(roles);
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(ActorRole role) {
		// this.role = role;
	}

	public void addRole(ActorRole role) {
		this.roles.add(role);
	}

	public void removeRole(ActorRole role) {
		this.roles.remove(role);
	}

	public void removeRole(String movieTitle, String roleName) {
		Iterator<ActorRole> i = roles.iterator();
		while (i.hasNext()) {
			ActorRole role = i.next();
			if (role.getMovie().getTitle().equals(movieTitle)
					&& role.getRole().equals(roleName)) {
				i.remove();
			}
		}
	}
	
	public void clearRoles() {
		this.roles.clear();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}
}
