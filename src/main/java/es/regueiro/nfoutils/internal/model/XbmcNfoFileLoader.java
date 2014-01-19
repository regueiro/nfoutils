package es.regueiro.nfoutils.internal.model;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.bind.JAXBException;

import es.regueiro.nfoutils.internal.jaxb.Marshaller;
import es.regueiro.nfoutils.internal.model.XbmcEpisodeDetails;
import es.regueiro.nfoutils.internal.model.XbmcMovie;
import es.regueiro.nfoutils.internal.model.XbmcMultiEpisode;
import es.regueiro.nfoutils.internal.model.XbmcTvShow;
import es.regueiro.nfoutils.media.Album;
import es.regueiro.nfoutils.media.Artist;
import es.regueiro.nfoutils.media.Episode;
import es.regueiro.nfoutils.media.Movie;
import es.regueiro.nfoutils.media.MultiEpisode;
import es.regueiro.nfoutils.media.MusicVideo;
import es.regueiro.nfoutils.media.TvShow;

public class XbmcNfoFileLoader {

	public static MusicVideo loadMusicVideo(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, MusicVideo.class);
	}

	public static Movie loadMovie(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, XbmcMovie.class);
	}

	public static TvShow loadTvShow(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, XbmcTvShow.class);
	}

	public static Episode loadEpisode(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, XbmcEpisodeDetails.class);
	}

	public static MultiEpisode loadMultiEpisode(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, XbmcMultiEpisode.class);
	}

	public static Artist loadArtist(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, XbmcArtist.class);
	}

	public static Album loadAlbum(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, XbmcAlbum.class);
	}

}
