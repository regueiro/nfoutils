package es.regueiro.nfoutils.media;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.bind.JAXBException;

import es.regueiro.nfoutils.internal.model.XbmcNfoFileLoader;

public class NfoFileLoader {

	public static MusicVideo loadMusicVideo(Path file) throws JAXBException, IOException {
		return XbmcNfoFileLoader.loadMusicVideo(file);
	}

	public static Movie loadMovie(Path file) throws JAXBException, IOException {
		return XbmcNfoFileLoader.loadMovie(file);
	}

	public static TvShow loadTvShow(Path file) throws JAXBException, IOException {
		return XbmcNfoFileLoader.loadTvShow(file);
	}

	public static Episode loadEpisode(Path file) throws JAXBException, IOException {
		return XbmcNfoFileLoader.loadEpisode(file);
	}

	public static MultiEpisode loadMultiEpisode(Path file) throws JAXBException, IOException {
		return XbmcNfoFileLoader.loadMultiEpisode(file);
	}
}