package es.regueiro.nfoutils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.regueiro.nfoutils.interfaces.Media;
import es.regueiro.nfoutils.internal.jaxb.Marshaller;
import es.regueiro.nfoutils.internal.util.TagCleaner;

@XmlRootElement(name = "artist")
@XmlAccessorType(XmlAccessType.FIELD)
public class Artist extends NfoFile implements Media {

	private static final Logger logger = LoggerFactory.getLogger(Artist.class);

	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "musicBrainzArtistID")
	private String musicBrainzArtistID;

	@XmlElement(name = "genre", type = String.class)
	private List<String> genres;
	@XmlElement(name = "style", type = String.class)
	private List<String> styles;
	@XmlElement(name = "mood", type = String.class)
	private List<String> moods;
	@XmlElement(name = "yearsactive", type = String.class)
	private List<String> yearsActive;
	@XmlElement(name = "instruments", type = String.class)
	private List<String> instruments;
	@XmlElement(name = "album", type = EmbeddedAlbum.class)
	private List<EmbeddedAlbum> albums;
	@XmlElement(name = "thumb", type = Thumb.class)
	private List<Thumb> thumbs;
	@XmlElement(name = "fanart", type = Fanart.class)
	private List<Fanart> fanarts;

	@XmlElement(name = "born")
	private String born;
	@XmlElement(name = "formed")
	private String formed;
	@XmlElement(name = "biography")
	private String biography;
	@XmlElement(name = "died")
	private String died;
	@XmlElement(name = "disbanded")
	private String disbanded;

	@XmlElement(name = "path")
	private String path;

	public static Artist fromFile(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, Artist.class);
	}

	public Artist() {
		this.genres = new ArrayList<>();
		this.styles = new ArrayList<>();
		this.moods = new ArrayList<>();
		this.yearsActive = new ArrayList<>();
		this.instruments = new ArrayList<>();
		this.albums = new ArrayList<>();
		this.thumbs = new ArrayList<>();
		this.fanarts = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMusicBrainzArtistID() {
		return musicBrainzArtistID;
	}

	public void setMusicBrainzArtistID(String musicBrainzArtistID) {
		this.musicBrainzArtistID = musicBrainzArtistID;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getStyles() {
		return styles;
	}

	public void setStyles(List<String> styles) {
		this.styles = styles;
	}

	public List<String> getMoods() {
		return moods;
	}

	public void setMoods(List<String> moods) {
		this.moods = moods;
	}

	public List<String> getYearsActive() {
		return yearsActive;
	}

	public void setYearsActive(List<String> yearsActive) {
		this.yearsActive = yearsActive;
	}

	public List<String> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<String> instruments) {
		this.instruments = instruments;
	}

	public List<EmbeddedAlbum> getAlbums() {
		return albums;
	}

	public void setAlbums(List<EmbeddedAlbum> albums) {
		this.albums = albums;
	}

	public List<Thumb> getThumbs() {
		return thumbs;
	}

	public void setThumbs(List<Thumb> thumbs) {
		this.thumbs = thumbs;
	}

	public List<Fanart> getFanarts() {
		return fanarts;
	}

	public void setFanarts(List<Fanart> fanarts) {
		this.fanarts = fanarts;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public String getFormed() {
		return formed;
	}

	public void setFormed(String formed) {
		this.formed = formed;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getDied() {
		return died;
	}

	public void setDied(String died) {
		this.died = died;
	}

	public String getDisbanded() {
		return disbanded;
	}

	public void setDisbanded(String disbanded) {
		this.disbanded = disbanded;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, Artist.class);
	}

	@Override
	public void save() throws IOException, JAXBException {
		long start = 0;
		if (logger.isTraceEnabled()) {
			start = System.nanoTime();
		}
		cleanEmptyTags();
		Marshaller.marshall(this, Artist.class);
		if (logger.isTraceEnabled()) {
			long end = System.nanoTime();
			logger.trace("Marshalling took {} nanoseconds ({} seconds)", (end - start), (end - start) / 10e9);
		}
	}

	@Override
	public String toString() {
		return "Artist:\nnfoFile=" + getNfoFile() + "\nname=" + name + "\nmusicBrainzArtistID=" + musicBrainzArtistID
				+ "\ngenres=" + genres + "\nstyles=" + styles + "\nmoods=" + moods + "\nyearsActive=" + yearsActive
				+ "\ninstruments=" + instruments + "\nalbums=" + albums + "\nthumbs=" + thumbs + "\nfanarts=" + fanarts
				+ "\nborn=" + born + "\nformed=" + formed + "\nbiography=" + biography + "\ndied=" + died
				+ "\ndisbanded=" + disbanded + "\npath=" + path;
	}

}
