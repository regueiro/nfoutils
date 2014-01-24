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

}
