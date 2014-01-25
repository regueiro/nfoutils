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

@XmlRootElement(name = "album")
@XmlAccessorType(XmlAccessType.FIELD)
public class Album extends NfoFile implements Media {

	private static final Logger logger = LoggerFactory.getLogger(Album.class);

	@XmlElement(name = "title")
	private String title;
	@XmlElement(name = "musicBrainzAlbumID")
	private String musicBrainzAlbumID;

	@XmlElement(name = "artist", type = String.class)
	private List<String> artists;
	@XmlElement(name = "genre", type = String.class)
	private List<String> genres;
	@XmlElement(name = "style", type = String.class)
	private List<String> styles;
	@XmlElement(name = "mood", type = String.class)
	private List<String> moods;
	@XmlElement(name = "theme", type = String.class)
	private List<String> themes;
	@XmlElement(name = "thumb", type = Thumb.class)
	private List<Thumb> thumbs;
	@XmlElement(name = "albumArtistCredits", type = ArtistCredits.class)
	private List<ArtistCredits> albumArtistCredits;
	@XmlElement(name = "track", type = Track.class)
	private List<ArtistCredits> tracks;

	@XmlElement(name = "compilation")
	private Boolean compilation;
	@XmlElement(name = "review")
	private String review;
	@XmlElement(name = "releasedate")
	private String releaseDate;
	@XmlElement(name = "label")
	private String label;
	@XmlElement(name = "type")
	private String type;
	@XmlElement(name = "year")
	private Integer year;
	@XmlElement(name = "rating")
	private Double rating;

	public static Album fromFile(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, Album.class);
	}

	public Album() {
		this.artists = new ArrayList<>();
		this.genres = new ArrayList<>();
		this.styles = new ArrayList<>();
		this.moods = new ArrayList<>();
		this.themes = new ArrayList<>();
		this.thumbs = new ArrayList<>();
		this.albumArtistCredits = new ArrayList<>();
		this.tracks = new ArrayList<>();

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMusicBrainzAlbumID() {
		return musicBrainzAlbumID;
	}

	public void setMusicBrainzAlbumID(String musicBrainzAlbumID) {
		this.musicBrainzAlbumID = musicBrainzAlbumID;
	}

	public List<String> getArtists() {
		return artists;
	}

	public void setArtists(List<String> artists) {
		this.artists = artists;
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

	public List<String> getThemes() {
		return themes;
	}

	public void setThemes(List<String> themes) {
		this.themes = themes;
	}

	public List<Thumb> getThumbs() {
		return thumbs;
	}

	public void setThumbs(List<Thumb> thumbs) {
		this.thumbs = thumbs;
	}

	public List<ArtistCredits> getAlbumArtistCredits() {
		return albumArtistCredits;
	}

	public void setAlbumArtistCredits(List<ArtistCredits> albumArtistCredits) {
		this.albumArtistCredits = albumArtistCredits;
	}

	public List<ArtistCredits> getTracks() {
		return tracks;
	}

	public void setTracks(List<ArtistCredits> tracks) {
		this.tracks = tracks;
	}

	public Boolean getCompilation() {
		return compilation;
	}

	public void setCompilation(Boolean compilation) {
		this.compilation = compilation;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, Album.class);
	}

	@Override
	public void save() throws IOException, JAXBException {
		long start = 0;
		if (logger.isTraceEnabled()) {
			start = System.nanoTime();
		}
		cleanEmptyTags();
		Marshaller.marshall(this, Album.class);
		if (logger.isTraceEnabled()) {
			long end = System.nanoTime();
			logger.trace("Marshalling took {} nanoseconds ({} seconds)", (end - start), (end - start) / 10e9);
		}
	}

	@Override
	public String toString() {
		return "Album:\nnfoFile=" + getNfoFile() + "\ntitle=" + title + "\nmusicBrainzAlbumID=" + musicBrainzAlbumID
				+ "\nartists=" + artists + "\ngenres=" + genres + "\nstyles=" + styles + "\nmoods=" + moods
				+ "\nthemes=" + themes + "\nthumbs=" + thumbs + "\nalbumArtistCredits=" + albumArtistCredits
				+ "\ntracks=" + tracks + "\ncompilation=" + compilation + "\nreview=" + review + "\nreleaseDate="
				+ releaseDate + "\nlabel=" + label + "\ntype=" + type + "\nyear=" + year + "\nrating=" + rating;
	}

}
