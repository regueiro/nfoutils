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
	}

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

}
