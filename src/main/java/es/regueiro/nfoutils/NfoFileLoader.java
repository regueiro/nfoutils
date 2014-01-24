package es.regueiro.nfoutils;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.bind.JAXBException;

import es.regueiro.nfoutils.Episode;
import es.regueiro.nfoutils.Movie;
import es.regueiro.nfoutils.MultiEpisode;
import es.regueiro.nfoutils.TvShow;
import es.regueiro.nfoutils.internal.jaxb.Marshaller;

public class NfoFileLoader {

	public static MusicVideo loadMusicVideo(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, MusicVideo.class);
	}

	public static Movie loadMovie(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, Movie.class);
	}

	public static TvShow loadTvShow(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, TvShow.class);
	}

	public static Episode loadEpisode(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, Episode.class);
	}

	public static MultiEpisode loadMultiEpisode(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, MultiEpisode.class);
	}

	public static Artist loadArtist(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, Artist.class);
	}

	public static Album loadAlbum(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, Album.class);
	}

}
