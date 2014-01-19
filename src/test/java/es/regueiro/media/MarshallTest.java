package es.regueiro.media;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import es.regueiro.nfoutils.internal.files.MediaFolderManager;
import es.regueiro.nfoutils.internal.jaxb.Marshaller;
import es.regueiro.nfoutils.internal.model.XbmcEpisodeDetails;
import es.regueiro.nfoutils.internal.model.XbmcMovie;
import es.regueiro.nfoutils.internal.model.XbmcMultiEpisode;
import es.regueiro.nfoutils.internal.model.XbmcTvShow;
import es.regueiro.nfoutils.media.Episode;
import es.regueiro.nfoutils.media.Movie;
import es.regueiro.nfoutils.media.MultiEpisode;
import es.regueiro.nfoutils.media.NfoFileLoader;
import es.regueiro.nfoutils.media.TvShow;

public class MarshallTest {

//	MediaFolderManager manager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
//		manager = new MediaFolderManager();

		// manager.addMediaFolder("P:/Peliculas");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMovieMarshalling() throws IOException, JAXBException {

		Movie movie = NfoFileLoader.loadMovie(Paths
				.get("P:/Peliculas/1080p/2001 - A Space Odyssey (Commentary) (1968) [1080p]/movie.nfo"));

//		System.out.println(movie.toString());
		movie.save();

	}

	@Test
	public void testTvShowMarshalling() throws IOException, JAXBException {

		 TvShow show = Marshaller.unMarshall(Paths.get("T:/Series/Justified/tvshow.nfo"), XbmcTvShow.class);
		 show.save();
		// TvShow show = Marshaller.unMarshall(Paths.get("N:/test/tvshow.nfo"), TvShow.class);
		// MultiEpisode multiEpisode =
		// Marshaller.unMarshall(Paths.get("N:/test/How I Met Your Mother 8x11-E12 - The Final Page.nfo"),
		// MultiEpisode.class);
		// TvShow multiEpisode =
		// Marshaller.unMarshall(Paths.get("N:/test/How I Met Your Mother 8x11-E12 - The Final Page.nfo"),
		// TvShow.class);
//		 Movie multiEpisode = Marshaller.unMarshall(Paths.get("N:/test/tvshow.nfo"), XbmcMovie.class);

		// multiEpisode.cleanEmptyTags();
		// multiEpisode.setNfoFile(Paths.get("N:/test/out.nfo"));
		// System.out.println(multiEpisode.toString());
		// Marshaller.marshall(multiEpisode, Movie.class);

	}

	@Test
	public void testDetectFileType() throws IOException, JAXBException, ParserConfigurationException, SAXException,
			URISyntaxException {

		Path movie = Paths.get(Thread.currentThread().getContextClassLoader().getResource("movie.nfo").toURI());
		Path tvshow = Paths.get(Thread.currentThread().getContextClassLoader().getResource("tvshow.nfo").toURI());
		Path episode = Paths.get(Thread.currentThread().getContextClassLoader().getResource("episode.nfo").toURI());
		Path multiEpisode = Paths.get(Thread.currentThread().getContextClassLoader().getResource("multiepisode.nfo")
				.toURI());

		assertEquals(XbmcMovie.class, Marshaller.detectFileType(movie));
		assertEquals(XbmcTvShow.class, Marshaller.detectFileType(tvshow));
		assertEquals(XbmcEpisodeDetails.class, Marshaller.detectFileType(episode));
		assertEquals(XbmcMultiEpisode.class, Marshaller.detectFileType(multiEpisode));

	}
	
	@Test
	public void testMarshalling() throws IOException, JAXBException, ParserConfigurationException, SAXException,
			URISyntaxException {

		Path movie = Paths.get(Thread.currentThread().getContextClassLoader().getResource("movie.nfo").toURI());
		Path tvshow = Paths.get(Thread.currentThread().getContextClassLoader().getResource("tvshow.nfo").toURI());
		Path episode = Paths.get(Thread.currentThread().getContextClassLoader().getResource("episode.nfo").toURI());
		Path multiEpisode = Paths.get(Thread.currentThread().getContextClassLoader().getResource("multiepisode.nfo")
				.toURI());

		Episode loadEpisode = NfoFileLoader.loadEpisode(episode);
		Movie loadMovie = NfoFileLoader.loadMovie(movie);
		MultiEpisode loadMultiEpisode = NfoFileLoader.loadMultiEpisode(multiEpisode);
//		NfoFileLoader.loadMusicVideo(file)
		TvShow loadTvShow = NfoFileLoader.loadTvShow(tvshow);
		
		loadEpisode.save();
		loadMovie.save();
		loadMultiEpisode.save();
		loadTvShow.save();
	}
}
