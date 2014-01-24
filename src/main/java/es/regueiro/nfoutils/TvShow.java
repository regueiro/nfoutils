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

@XmlRootElement(name = "tvshow")
@XmlAccessorType(XmlAccessType.FIELD)
public class TvShow extends NfoFile implements Media {

	private static final Logger logger = LoggerFactory.getLogger(TvShow.class);

	@XmlElement(name = "id")
	private String id;
	@XmlElement(name = "title")
	private String title;
	@XmlElement(name = "showtitle")
	private String showtitle;
	@XmlElement(name = "sorttitle")
	private String sortTitle;
	@XmlElement(name = "outline")
	private String outline;
	@XmlElement(name = "plot")
	private String plot;
	@XmlElement(name = "tagline")
	private String tagline;

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
	@XmlElement(name = "showlink", type = String.class)
	private List<String> showlinks;
	@XmlElement(name = "tag", type = String.class)
	private List<String> tags;

	@XmlElement(name = "episodeguide", type = EpisodeGuide.class)
	private EpisodeGuide episodeGuide;
	@XmlElement(name = "uniqueid")
	private String uniqueId;
	@XmlElement(name = "displayseason")
	private Integer displaySeason;
	@XmlElement(name = "displayepisode")
	private Integer displayEpisode;
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

	/*
	 * ###Extra tags###
	 * 
	 * Tags used by media managers or media center software other than XBMC.
	 * 
	 * Included only for compatibility reasons
	 */

	// Media Elch Tags
	@XmlElement(name = "tvdbid")
	private String tvdbID;
	@XmlElement(name = "imdbid")
	private String imdbID;

	// Media Companion tags
	@XmlElement(name = "episodeactorsource")
	private String episodeActorSource;
	@XmlElement(name = "tvshowactorsource")
	private String tvShowActorSource;
	@XmlElement(name = "sortorder")
	private String sortOrder;
	@XmlElement(name = "language")
	private String language;
	@XmlElement(name = "state")
	private String state;

	// End extra tags

	@XmlElement(name = "episodedetails", type = Episode.class)
	private List<Episode> episodeDetails;

	public static TvShow fromFile(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, TvShow.class);
	}

	public TvShow() {
		this.actors = new ArrayList<>();
		this.episodeDetails = new ArrayList<>();
		this.fanarts = new ArrayList<>();
		this.genres = new ArrayList<>();
		this.showlinks = new ArrayList<>();
		this.studios = new ArrayList<>();
		this.thumbs = new ArrayList<>();
	}

	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, TvShow.class);
	}

	@Override
	public void save() throws IOException, JAXBException {
		long start = 0;
		if (logger.isTraceEnabled()) {
			start = System.nanoTime();
		}
		cleanEmptyTags();
		Marshaller.marshall(this, TvShow.class);
		if (logger.isTraceEnabled()) {
			long end = System.nanoTime();
			logger.trace("Marshalling took {} nanoseconds ({} seconds)", (end - start), (end - start) / 10e9);
		}
	}

	@Override
	public String toString() {
		return "XbmcTvShow:\ngetNfoFile()=" + getNfoFile() + "\nid=" + id + "\ntitle=" + title + "\nshowtitle="
				+ showtitle + "\nsortTitle=" + sortTitle + "\noutline=" + outline + "\nplot=" + plot + "\ntagline="
				+ tagline + "\ngenres=" + genres + "\nstudios=" + studios + "\nactors=" + actors + "\nthumbs=" + thumbs
				+ "\nfanarts=" + fanarts + "\nshowlinks=" + showlinks + "\ntags=" + tags + "\nepisodeGuide="
				+ episodeGuide + "\nuniqueId=" + uniqueId + "\ndisplaySeason=" + displaySeason + "\ndisplayEpisode="
				+ displayEpisode + "\nseason=" + season + "\nepisode=" + episode + "\nyear=" + year + "\nrating="
				+ rating + "\nvotes=" + votes + "\ntop250=" + top250 + "\nruntime=" + runtime + "\naired=" + aired
				+ "\nplaycount=" + playcount + "\ntrailer=" + trailer + "\nmpaa=" + mpaa + "\nset=" + set
				+ "\npremiered=" + premiered + "\nlastplayed=" + lastplayed + "\nepbookmark=" + epbookmark
				+ "\nfilenameandpath=" + filenameandpath + "\nfile=" + file + "\npath=" + path + "\nbasepath="
				+ basepath + "\nstatus=" + status + "\ncode=" + code + "\nresume=" + resume + "\ndateadded="
				+ dateadded + "\nart=" + art + "\ntvdbID=" + tvdbID + "\nimdbID=" + imdbID + "\nepisodeActorSource="
				+ episodeActorSource + "\ntvShowActorSource=" + tvShowActorSource + "\nsortOrder=" + sortOrder
				+ "\nlanguage=" + language + "\nstate=" + state + "\nepisodeDetails=" + episodeDetails;
	}

}
