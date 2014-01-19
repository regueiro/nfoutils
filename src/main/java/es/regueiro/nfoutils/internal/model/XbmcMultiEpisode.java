package es.regueiro.nfoutils.internal.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.regueiro.nfoutils.internal.jaxb.Marshaller;
import es.regueiro.nfoutils.media.MultiEpisode;

public class XbmcMultiEpisode extends XbmcNfoFile implements MultiEpisode {

	private static final Logger logger = LoggerFactory.getLogger(XbmcMultiEpisode.class);

	private List<XbmcEpisodeDetails> episodes;

	public XbmcMultiEpisode() {
		this.episodes = new ArrayList<>();
	}

	public void addEpisode(XbmcEpisodeDetails episode) {
		this.episodes.add(episode);
	}

	public void removeEpisode(XbmcEpisodeDetails episode) {
		this.episodes.remove(episode);
	}

	public boolean hasEpisode(XbmcEpisodeDetails episode) {
		return this.episodes.contains(episode);
	}

	public List<XbmcEpisodeDetails> getEpisodes() {
		return Collections.unmodifiableList(episodes);
	}

	public void cleanEmptyTags() {
		for (XbmcEpisodeDetails episode : episodes) {
			episode.cleanEmptyTags();
		}
	}

	@Override
	public String toString() {
		return "Multiepisode [episodes=" + episodes + "]";
	}

	@Override
	public void save() throws IOException, JAXBException {
		long start = 0;
		if (logger.isTraceEnabled()) {
			start = System.nanoTime();
		}
		cleanEmptyTags();
		Marshaller.marshall(this, XbmcMultiEpisode.class);
		if (logger.isTraceEnabled()) {
			long end = System.nanoTime();
			logger.trace("Marshalling took {} nanoseconds ({} seconds)", (end - start), (end - start) / 10e9);
		}
	}

}
