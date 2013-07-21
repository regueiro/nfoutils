package es.regueiro.nfoutils.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Movie {

	private static final Logger logger = LoggerFactory.getLogger(Movie.class);

	private MediaFolder mediaFolder;
	private Path folder;
	private Path nfo;
	private String imdbID;
	private String title;
	private String originalTitle;
	private String sortTitle;
	private String outline;
	private String plot;
	private String tagline;
	private Collection<Director> directors;
	private Collection<Writer> writers;
	private Collection<Genre> genres;
	private Collection<Country> countries;
	private Collection<Studio> studios;
	private Collection<ActorRole> cast;
	private int year;
	private LocalDate date;
	private String rating;
	private String votes;
	private String top250;
	private String runtime;
	private int playcount;
	private URL trailer;
	private String certification;
	private String mpaa;
	private Path poster;
	private Path banner;
	private Path fanart;
	private Collection<URL> thumbs;

	public Movie() {
		this.directors = new ArrayList<>();
		this.writers = new ArrayList<>();
		this.genres = new ArrayList<>();
		this.countries = new ArrayList<>();
		this.studios = new ArrayList<>();
		this.cast = new ArrayList<>();
		this.thumbs = new ArrayList<>();
	}

	/**
	 * @return the mediaFolder
	 */
	public MediaFolder getMediaFolder() {
		return mediaFolder;
	}

	/**
	 * @param mediaFolder
	 *            the mediaFolder to set
	 */
	public void setMediaFolder(MediaFolder mediaFolder) {
		this.mediaFolder = mediaFolder;
	}

	/**
	 * @return the folder
	 */
	public Path getFolder() {
		return folder;
	}

	/**
	 * @param folder
	 *            the folder to set
	 */
	public void setFolder(Path folder) {
		this.folder = folder;
	}

	/**
	 * @return the nfo
	 */
	public Path getNfo() {
		return nfo;
	}

	/**
	 * @param nfo
	 *            the nfo to set
	 */
	public void setNfo(Path nfo) {
		this.nfo = nfo;
	}

	/**
	 * @return the imdbID
	 */
	public String getImdbID() {
		return imdbID;
	}

	/**
	 * @param imdbID
	 *            the imdbID to set
	 */
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the originalTitle
	 */
	public String getOriginalTitle() {
		return originalTitle;
	}

	/**
	 * @param originalTitle
	 *            the originalTitle to set
	 */
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	/**
	 * @return the sortTitle
	 */
	public String getSortTitle() {
		return sortTitle;
	}

	/**
	 * @param sortTitle
	 *            the sortTitle to set
	 */
	public void setSortTitle(String sortTitle) {
		this.sortTitle = sortTitle;
	}

	/**
	 * @return the outline
	 */
	public String getOutline() {
		return outline;
	}

	/**
	 * @param outline
	 *            the outline to set
	 */
	public void setOutline(String outline) {
		this.outline = outline;
	}

	/**
	 * @return the plot
	 */
	public String getPlot() {
		return plot;
	}

	/**
	 * @param plot
	 *            the plot to set
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}

	/**
	 * @return the tagline
	 */
	public String getTagline() {
		return tagline;
	}

	/**
	 * @param tagline
	 *            the tagline to set
	 */
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	/**
	 * @return the directors
	 */
	public Collection<Director> getDirectors() {
		return Collections.unmodifiableCollection(directors);
	}

	/**
	 * @param directors
	 *            the directors to set
	 */
	public void setDirectors(Collection<Director> directors) {
		// this.directors = directors;
	}

	public void addDirector(Director director) {
		this.directors.add(director);
	}

	public void removeDirector(Director director) {
		this.directors.remove(director);
	}

	public void removeDirector(String name) {
		Iterator<Director> i = directors.iterator();
		while (i.hasNext()) {
			Director director = i.next();
			if (director.getName().equals(name)) {
				i.remove();
			}
		}
	}

	public void clearDirectors() {
		this.directors.clear();
	}

	/**
	 * @return the writers
	 */
	public Collection<Writer> getWriters() {
		return Collections.unmodifiableCollection(writers);
	}

	/**
	 * @param writers
	 *            the writers to set
	 */
	public void setWriters(Collection<Writer> writers) {
		// this.writers = writers;
	}

	public void addWriter(Writer writer) {
		this.writers.add(writer);
	}

	public void removeWriter(Writer writer) {
		this.writers.remove(writer);
	}

	public void removeWriter(String name) {
		Iterator<Writer> i = writers.iterator();
		while (i.hasNext()) {
			Writer writer = i.next();
			if (writer.getName().equals(name)) {
				i.remove();
			}
		}
	}

	public void clearWriters() {
		this.writers.clear();
	}

	/**
	 * @return the genres
	 */
	public Collection<Genre> getGenres() {
		return Collections.unmodifiableCollection(genres);
	}

	/**
	 * @param genres
	 *            the genres to set
	 */
	public void setGenres(Collection<Genre> genres) {
		// this.genres = genres;
	}

	public void addGenre(Genre genre) {
		this.genres.add(genre);
	}

	public void removeGenre(Genre genre) {
		this.genres.remove(genre);
	}

	public void removeGenre(String name) {
		Iterator<Genre> i = genres.iterator();
		while (i.hasNext()) {
			Genre genre = i.next();
			if (genre.getName().equals(name)) {
				i.remove();
			}
		}
	}

	public void clearGenres() {
		this.genres.clear();
	}

	/**
	 * @return the countries
	 */
	public Collection<Country> getCountries() {
		return Collections.unmodifiableCollection(countries);
	}

	/**
	 * @param countries
	 *            the countries to set
	 */
	public void setCountries(Collection<Country> countries) {
		// this.countries = countries;
	}

	public void addCountry(Country country) {
		this.countries.add(country);
	}

	public void removeCountry(Country country) {
		this.countries.remove(country);
	}

	public void removeCountry(String name) {
		Iterator<Country> i = countries.iterator();
		while (i.hasNext()) {
			Country country = i.next();
			if (country.getName().equals(name)) {
				i.remove();
			}
		}
	}

	public void clearCountry() {
		this.countries.clear();
	}

	/**
	 * @return the studios
	 */
	public Collection<Studio> getStudios() {
		return Collections.unmodifiableCollection(studios);
	}

	/**
	 * @param studios
	 *            the studios to set
	 */
	public void setStudios(Collection<Studio> studios) {
		// this.studios = studios;
	}

	public void addStudio(Studio studio) {
		this.studios.add(studio);
	}

	public void removeStudio(Studio studio) {
		this.studios.remove(studio);
	}

	public void removeStudio(String name) {
		Iterator<Studio> i = studios.iterator();
		while (i.hasNext()) {
			Studio studio = i.next();
			if (studio.getName().equals(name)) {
				i.remove();
			}
		}
	}

	public void clearStudios() {
		this.studios.clear();
	}

	/**
	 * @return the cast
	 */
	public Collection<ActorRole> getCast() {
		return Collections.unmodifiableCollection(cast);
	}

	/**
	 * @param cast
	 *            the cast to set
	 */
	public void setCast(Collection<ActorRole> cast) {
		// this.cast = cast;
	}

	public void addCast(ActorRole actor) {
		this.cast.add(actor);
	}

	public void removeCast(ActorRole actor) {
		this.cast.remove(actor);
	}

	public void removeCast(String actorName, String roleName) {
		Iterator<ActorRole> i = cast.iterator();
		while (i.hasNext()) {
			ActorRole actorRole = i.next();
			if (actorRole.getActor().getName().equals(actorName)
					&& actorRole.getRole().equals(roleName)) {
				i.remove();
			}
		}
	}

	public void clearCast() {
		this.cast.clear();
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the votes
	 */
	public String getVotes() {
		return votes;
	}

	/**
	 * @param votes
	 *            the votes to set
	 */
	public void setVotes(String votes) {
		this.votes = votes;
	}

	/**
	 * @return the top250
	 */
	public String getTop250() {
		return top250;
	}

	/**
	 * @param top250
	 *            the top250 to set
	 */
	public void setTop250(String top250) {
		this.top250 = top250;
	}

	/**
	 * @return the runtime
	 */
	public String getRuntime() {
		return runtime;
	}

	/**
	 * @param runtime
	 *            the runtime to set
	 */
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	/**
	 * @return the playcount
	 */
	public int getPlaycount() {
		return playcount;
	}

	/**
	 * @param playcount
	 *            the playcount to set
	 */
	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}

	/**
	 * @return the trailer
	 */
	public URL getTrailer() {
		return trailer;
	}

	/**
	 * @param trailer
	 *            the trailer to set
	 */
	public void setTrailer(URL trailer) {
		this.trailer = trailer;
	}

	public void setTrailer(String trailer) {
		try {
			URL trailerURL = new URL(trailer);
			this.trailer = trailerURL;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.debug("Malformed URL: " + trailer);
		}
	}

	/**
	 * @return the certification
	 */
	public String getCertification() {
		return certification;
	}

	/**
	 * @param certification
	 *            the certification to set
	 */
	public void setCertification(String certification) {
		this.certification = certification;
	}

	/**
	 * @return the mpaa
	 */
	public String getMpaa() {
		return mpaa;
	}

	/**
	 * @param mpaa
	 *            the mpaa to set
	 */
	public void setMpaa(String mpaa) {
		this.mpaa = mpaa;
	}

	/**
	 * @return the poster
	 */
	public Path getPoster() {
		return poster;
	}

	/**
	 * @param poster
	 *            the poster to set
	 */
	public void setPoster(Path poster) {
		this.poster = poster;
	}

	/**
	 * @return the banner
	 */
	public Path getBanner() {
		return banner;
	}

	/**
	 * @param banner
	 *            the banner to set
	 */
	public void setBanner(Path banner) {
		this.banner = banner;
	}

	/**
	 * @return the fanart
	 */
	public Path getFanart() {
		return fanart;
	}

	/**
	 * @param fanart
	 *            the fanart to set
	 */
	public void setFanart(Path fanart) {
		this.fanart = fanart;
	}

	public Collection<URL> getThumbs() {
		return Collections.unmodifiableCollection(thumbs);
	}

	public void setThumbs(Collection<URL> thumbs) {
		// this.directors = directors;
	}

	public void addThumb(URL thumb) {
		this.thumbs.add(thumb);
	}

	public void addThumb(String thumb) {
		try {
			URL inputThumbURL = new URL(thumb);
			this.thumbs.add(inputThumbURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.debug("Malformed thumb: " + thumb);
		}
	}

	public void removeThumb(URL thumb) {
		this.thumbs.remove(thumb);
	}

	public void removeThumb(String thumb) {
		Iterator<URL> i = thumbs.iterator();
		try {
			URL inputThumbURL = new URL(thumb);

			while (i.hasNext()) {
				URL existingThumbURL = i.next();
				if (existingThumbURL.equals(inputThumbURL)) {
					i.remove();
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clearThumbs() {
		this.thumbs.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie:\n" + "mediaFolder=" + mediaFolder + "\nfolder=" + folder
				+ "\nnfo=" + nfo + "\nimdbID=" + imdbID + "\ntitle=" + title
				+ "\noriginalTitle=" + originalTitle + "\nsortTitle="
				+ sortTitle + "\noutline=" + outline + "\nplot=" + plot
				+ "\ntagline=" + tagline + "\ndirectors=" + directors
				+ "\nwriters=" + writers + "\ngenres=" + genres
				+ "\ncountries=" + countries + "\nstudios=" + studios
				+ "\ncast=" + cast + "\nyear=" + year + "\ndate=" + date
				+ "\nrating=" + rating + "\nvotes=" + votes + "\ntop250="
				+ top250 + "\nruntime=" + runtime + "\nplaycount=" + playcount
				+ "\ntrailer=" + trailer + "\ncertification=" + certification
				+ "\nmpaa=" + mpaa + "\nposter=" + poster + "\nbanner="
				+ banner + "\nfanart=" + fanart + "\nthumbs=" + thumbs + "]";
	}

	// set
	// tags
	// fileinfo
	// thumb

}
