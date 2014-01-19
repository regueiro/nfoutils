package es.regueiro.nfoutils.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiEpisode extends NfoFile {

	private static final Logger logger = LoggerFactory.getLogger(MultiEpisode.class);

	private List<EpisodeDetails> episodes;

	public MultiEpisode() {
		this.episodes = new ArrayList<>();
	}

	public void addEpisode(EpisodeDetails episode) {
		this.episodes.add(episode);
	}

	public void removeEpisode(EpisodeDetails episode) {
		this.episodes.remove(episode);
	}

	public boolean hasEpisode(EpisodeDetails episode) {
		return this.episodes.contains(episode);
	}

	public List<EpisodeDetails> getEpisodes() {
		return Collections.unmodifiableList(episodes);
	}

	public void cleanEmptyTags() {
		for (EpisodeDetails episode : episodes) {
			episode.cleanEmptyTags();
		}
	}

	@Override
	public String toString() {
		return "Multiepisode [episodes=" + episodes + "]";
	}

}
