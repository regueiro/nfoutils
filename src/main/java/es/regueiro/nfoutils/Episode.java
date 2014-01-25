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

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.regueiro.nfoutils.interfaces.Media;
import es.regueiro.nfoutils.internal.jaxb.Marshaller;
import es.regueiro.nfoutils.internal.util.TagCleaner;

@XmlRootElement(name = "episodedetails")
@XmlAccessorType(XmlAccessType.FIELD)
public class Episode extends NfoFile implements Media {

	private static final Logger logger = LoggerFactory.getLogger(Episode.class);

	@XmlElement(name = "id")
	private String id;
	@XmlElement(name = "title")
	private String title;
	@XmlElement(name = "showtitle")
	private String showtitle;
	@XmlElement(name = "outline")
	private String outline;
	@XmlElement(name = "plot")
	private String plot;
	@XmlElement(name = "tagline")
	private String tagline;
	@XmlElement(name = "studio", type = String.class)
	private List<String> studios;
	@XmlElement(name = "director", type = String.class)
	private List<String> directors;
	@XmlElement(name = "credits", type = String.class)
	private List<String> credits;
	@XmlElement(name = "actor", type = Actor.class)
	private List<Actor> actors;
	@XmlElement(name = "thumb", type = Thumb.class)
	private List<Thumb> thumbs;
	@XmlElement(name = "uniqueid")
	private String uniqueId;
	@XmlElement(name = "displayseason")
	private Integer displaySeason;
	@XmlElement(name = "displayepisode")
	private Integer displayEpisode;
	@XmlElement(name = "displayafterseason")
	private Integer displayAfterSeason;
	@XmlElement(name = "season")
	private Integer season;
	@XmlElement(name = "episode")
	private Integer episode;
	@XmlElement(name = "year")
	private Integer year;
	@XmlElement(name = "rating")
	private Double rating;
	@XmlElement(name = "votes")
	private String votes;
	@XmlElement(name = "top250")
	private Integer top250;
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

	@XmlElement(name = "fileinfo", type = FileInfo.class)
	private List<FileInfo> fileinfos;

	/*
	 * ###Extra tags###
	 * 
	 * Tags used by media managers or media center software other than XBMC.
	 * 
	 * Included only for compatibility reasons
	 */

	// Unknown Tags
	@XmlElement(name = "showid")
	private String showId;

	// Media Elch Tags
	// @XmlElement(name = "tvdbid")
	// private String tvdbID;
	// @XmlElement(name = "imdbid")
	// private String imdbID;
	// @XmlElement(name = "sorttitle")
	// private String sortTitle;

	// Media Companion tags
	// @XmlElement(name = "episodeactorsource")
	// private String episodeActorSource;
	// @XmlElement(name = "tvshowactorsource")
	// private String tvShowActorSource;
	// @XmlElement(name = "sortorder")
	// private String sortOrder;
	// @XmlElement(name = "language")
	// private String language;
	// @XmlElement(name = "state")
	// private String state;

	public static Episode fromFile(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, Episode.class);
	}

	public Episode() {
		this.studios = new ArrayList<>();
		this.directors = new ArrayList<>();
		this.credits = new ArrayList<>();
		this.actors = new ArrayList<>();
		this.thumbs = new ArrayList<>();
		this.fileinfos = new ArrayList<>();
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

	public String getShowtitle() {
		return showtitle;
	}

	public void setShowtitle(String showtitle) {
		this.showtitle = showtitle;
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

	public List<String> getStudios() {
		return studios;
	}

	public void setStudios(List<String> studios) {
		this.studios = studios;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public List<String> getCredits() {
		return credits;
	}

	public void setCredits(List<String> credits) {
		this.credits = credits;
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

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Integer getDisplaySeason() {
		return displaySeason;
	}

	public void setDisplaySeason(Integer displaySeason) {
		this.displaySeason = displaySeason;
	}

	public Integer getDisplayEpisode() {
		return displayEpisode;
	}

	public void setDisplayEpisode(Integer displayEpisode) {
		this.displayEpisode = displayEpisode;
	}

	public Integer getDisplayAfterSeason() {
		return displayAfterSeason;
	}

	public void setDisplayAfterSeason(Integer displayAfterSeason) {
		this.displayAfterSeason = displayAfterSeason;
	}

	public Integer getSeason() {
		return season;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
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

	public Integer getTop250() {
		return top250;
	}

	public void setTop250(Integer top250) {
		this.top250 = top250;
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

	public List<FileInfo> getFileinfos() {
		return fileinfos;
	}

	public void setFileinfos(List<FileInfo> fileinfos) {
		this.fileinfos = fileinfos;
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	@Override
	public void save() throws IOException, JAXBException {
		long start = 0;
		if (logger.isTraceEnabled()) {
			start = System.nanoTime();
		}
		cleanEmptyTags();
		Marshaller.marshall(this, Episode.class);
		if (logger.isTraceEnabled()) {
			long end = System.nanoTime();
			logger.trace("Marshalling took {} nanoseconds ({} seconds)", (end - start), (end - start) / 10e9);
		}
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, Episode.class);
	}

	@Override
	public String toString() {
		return "Episode:\nnfoFile=" + getNfoFile() + "\nid=" + id + "\ntitle=" + title + "\nshowtitle=" + showtitle
				+ "\noutline=" + outline + "\nplot=" + plot + "\ntagline=" + tagline + "\nstudios=" + studios
				+ "\ndirectors=" + directors + "\ncredits=" + credits + "\nactors=" + actors + "\nthumbs=" + thumbs
				+ "\nuniqueId=" + uniqueId + "\ndisplaySeason=" + displaySeason + "\ndisplayEpisode=" + displayEpisode
				+ "\ndisplayAfterSeason=" + displayAfterSeason + "\nseason=" + season + "\nepisode=" + episode
				+ "\nyear=" + year + "\nrating=" + rating + "\nvotes=" + votes + "\ntop250=" + top250 + "\nruntime="
				+ runtime + "\naired=" + aired + "\nplaycount=" + playcount + "\ntrailer=" + trailer + "\nmpaa=" + mpaa
				+ "\nset=" + set + "\npremiered=" + premiered + "\nlastplayed=" + lastplayed + "\nepbookmark="
				+ epbookmark + "\nfilenameandpath=" + filenameandpath + "\nfile=" + file + "\npath=" + path
				+ "\nbasepath=" + basepath + "\nstatus=" + status + "\ncode=" + code + "\nresume=" + resume
				+ "\ndateadded=" + dateadded + "\nart=" + art + "\nfileinfos=" + fileinfos + "\nshowId=" + showId;
	}

}
