package es.regueiro.nfoutils.model;

import java.net.MalformedURLException;
import java.net.URL;

public class ActorRole {
	private Actor actor;
	private Movie movie;
	private String role;
	private URL thumb;

	public ActorRole(Actor actor, Movie movie) {
		this.actor = actor;
		this.movie = movie;
	}

	/**
	 * @return the actor
	 */
	public Actor getActor() {
		return actor;
	}

	/**
	 * @param actor
	 *            the actor to set
	 */
	public void setActor(Actor actor) {
		this.actor = actor;
	}

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @param movie
	 *            the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the thumb
	 */
	public URL getThumb() {
		return thumb;
	}

	/**
	 * @param thumb
	 *            the thumb to set
	 */
	public void setThumb(URL thumb) {
		this.thumb = thumb;
	}
	
	public void setThumb(String thumb) {
		try {
			URL thumbURL = new URL(thumb);
			this.thumb = thumbURL;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Actor: "+actor+" as "+role+" | Thumb: "+thumb+"\n";
	}

}
