package es.regueiro.nfoutils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.regueiro.nfoutils.interfaces.Media;
import es.regueiro.nfoutils.internal.jaxb.Marshaller;

public class MultiEpisode extends NfoFile implements Media {

	private static final Logger logger = LoggerFactory.getLogger(MultiEpisode.class);

	private List<Episode> episodes;

	public static MultiEpisode fromFile(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, MultiEpisode.class);
	}

	public MultiEpisode() {
		this.episodes = new ArrayList<>();
	}

	public void addEpisode(Episode episode) {
		this.episodes.add(episode);
	}

	public void removeEpisode(Episode episode) {
		this.episodes.remove(episode);
	}

	public boolean hasEpisode(Episode episode) {
		return this.episodes.contains(episode);
	}

	public List<Episode> getEpisodes() {
		return Collections.unmodifiableList(episodes);
	}

	@Override
	public void save() throws IOException, JAXBException {
		long start = 0;
		if (logger.isTraceEnabled()) {
			start = System.nanoTime();
		}
		cleanEmptyTags();
		Marshaller.marshall(this, MultiEpisode.class);
		if (logger.isTraceEnabled()) {
			long end = System.nanoTime();
			logger.trace("Marshalling took {} nanoseconds ({} seconds)", (end - start), (end - start) / 10e9);
		}
	}

	@Override
	public void cleanEmptyTags() {
		for (Episode episode : episodes) {
			episode.cleanEmptyTags();
		}
	}

	@Override
	public String toString() {
		return "Multiepisode [episodes=" + episodes + "]";
	}

}
