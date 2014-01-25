package es.regueiro.nfoutils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.regueiro.nfoutils.interfaces.Media;
import es.regueiro.nfoutils.internal.jaxb.Marshaller;
import es.regueiro.nfoutils.internal.util.TagCleaner;

@XmlRootElement(name = "musicvideo")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicVideo extends NfoFile implements Media {

	private static final Logger logger = LoggerFactory.getLogger(MusicVideo.class);

	@XmlElement(name = "id")
	private String id;
	@XmlElement(name = "title")
	private String title;
	@XmlElement(name = "album")
	private String album;
	@XmlElement(name = "track")
	private String track;
	@XmlElement(name = "outline")
	private String outline;
	@XmlElement(name = "plot")
	private String plot;
	@XmlElement(name = "tagline")
	private String tagline;
	@XmlElement(name = "artist", type = String.class)
	private List<String> artists;
	@XmlElement(name = "genre", type = String.class)
	private List<String> genres;
	@XmlElement(name = "studio", type = String.class)
	private List<String> studios;
	@XmlElement(name = "actor", type = Actor.class)
	private List<Actor> actors;
	@XmlElement(name = "thumb", type = Thumb.class)
	private List<Thumb> thumbs;
	@XmlElement(name = "fanart", type = Fanart.class)
	private List<Fanart> fanarts;
	@XmlElement(name = "episodeguide", type = EpisodeGuide.class)
	private EpisodeGuide episodeGuide;
	@XmlElement(name = "uniqueid")
	private String uniqueId;
	@XmlElement(name = "year")
	private Integer year;
	@XmlElement(name = "rating")
	private Double rating;
	@XmlElement(name = "votes")
	private String votes;
	@XmlElement(name = "runtime")
	private Integer runtime;
	@XmlElement(name = "aired")
	private LocalDate aired;
	@XmlElement(name = "playcount")
	private Integer playcount;
	@XmlElement(name = "trailer")
	private String trailer;
	@XmlElement(name = "mpaa")
	private String mpaa;
	@XmlElement(name = "set")
	private String set;
	@XmlElement(name = "premiered")
	private LocalDate premiered;
	@XmlElement(name = "tag")
	private Collection<String> tags;
	@XmlElement(name = "lastplayed")
	private LocalDate lastplayed;
	@XmlElement(name = "epbookmark")
	private Double epbookmark;
	@XmlElement(name = "filenameandpath")
	private String filenameandpath;
	@XmlElement(name = "file")
	private String file;
	@XmlElement(name = "path")
	private String path;
	@XmlElement(name = "basepath")
	private String basepath;
	@XmlElement(name = "status")
	private String status;
	@XmlElement(name = "code")
	private String code;
	@XmlElement(name = "resume")
	private Resume resume;
	@XmlElement(name = "dateadded")
	private LocalDateTime dateadded;
	@XmlElement(name = "art")
	private Art art;

	public static MusicVideo fromFile(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, MusicVideo.class);
	}

	public MusicVideo() {
		this.artists = new ArrayList<>();
		this.genres = new ArrayList<>();
		this.studios = new ArrayList<>();
		this.actors = new ArrayList<>();
		this.thumbs = new ArrayList<>();
		this.fanarts = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
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

	public List<String> getStudios() {
		return studios;
	}

	public void setStudios(List<String> studios) {
		this.studios = studios;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
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

	public EpisodeGuide getEpisodeGuide() {
		return episodeGuide;
	}

	public void setEpisodeGuide(EpisodeGuide episodeGuide) {
		this.episodeGuide = episodeGuide;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
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

	public String getVotes() {
		return votes;
	}

	public void setVotes(String votes) {
		this.votes = votes;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public LocalDate getAired() {
		return aired;
	}

	public void setAired(LocalDate aired) {
		this.aired = aired;
	}

	public Integer getPlaycount() {
		return playcount;
	}

	public void setPlaycount(Integer playcount) {
		this.playcount = playcount;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getMpaa() {
		return mpaa;
	}

	public void setMpaa(String mpaa) {
		this.mpaa = mpaa;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public LocalDate getPremiered() {
		return premiered;
	}

	public void setPremiered(LocalDate premiered) {
		this.premiered = premiered;
	}

	public Collection<String> getTags() {
		return tags;
	}

	public void setTags(Collection<String> tags) {
		this.tags = tags;
	}

	public LocalDate getLastplayed() {
		return lastplayed;
	}

	public void setLastplayed(LocalDate lastplayed) {
		this.lastplayed = lastplayed;
	}

	public Double getEpbookmark() {
		return epbookmark;
	}

	public void setEpbookmark(Double epbookmark) {
		this.epbookmark = epbookmark;
	}

	public String getFilenameandpath() {
		return filenameandpath;
	}

	public void setFilenameandpath(String filenameandpath) {
		this.filenameandpath = filenameandpath;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public LocalDateTime getDateadded() {
		return dateadded;
	}

	public void setDateadded(LocalDateTime dateadded) {
		this.dateadded = dateadded;
	}

	public Art getArt() {
		return art;
	}

	public void setArt(Art art) {
		this.art = art;
	}

	@Override
	public void save() throws IOException, JAXBException {
		long start = 0;
		if (logger.isTraceEnabled()) {
			start = System.nanoTime();
		}
		cleanEmptyTags();
		Marshaller.marshall(this, MusicVideo.class);
		if (logger.isTraceEnabled()) {
			long end = System.nanoTime();
			logger.trace("Marshalling took {} nanoseconds ({} seconds)", (end - start), (end - start) / 10e9);
		}
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, MusicVideo.class);
	}

	@Override
	public String toString() {
		return "MusicVideo:\nnfoFile=" + getNfoFile() + "\nid=" + id + "\ntitle=" + title + "\nalbum=" + album
				+ "\ntrack=" + track + "\noutline=" + outline + "\nplot=" + plot + "\ntagline=" + tagline
				+ "\nartists=" + artists + "\ngenres=" + genres + "\nstudios=" + studios + "\nactors=" + actors
				+ "\nthumbs=" + thumbs + "\nfanarts=" + fanarts + "\nepisodeGuide=" + episodeGuide + "\nuniqueId="
				+ uniqueId + "\nyear=" + year + "\nrating=" + rating + "\nvotes=" + votes + "\nruntime=" + runtime
				+ "\naired=" + aired + "\nplaycount=" + playcount + "\ntrailer=" + trailer + "\nmpaa=" + mpaa
				+ "\nset=" + set + "\npremiered=" + premiered + "\ntags=" + tags + "\nlastplayed=" + lastplayed
				+ "\nepbookmark=" + epbookmark + "\nfilenameandpath=" + filenameandpath + "\nfile=" + file + "\npath="
				+ path + "\nbasepath=" + basepath + "\nstatus=" + status + "\ncode=" + code + "\nresume=" + resume
				+ "\ndateadded=" + dateadded + "\nart=" + art;
	}

}
