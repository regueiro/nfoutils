package es.regueiro.nfoutils.internal.jaxb

import es.regueiro.nfoutils.Episode
import es.regueiro.nfoutils.Movie
import es.regueiro.nfoutils.MultiEpisode
import es.regueiro.nfoutils.TvShow


class MarshallerTest extends GroovyTestCase {
	BufferedReader movieReader
	BufferedReader tvShowReader
	BufferedReader episodeReader
	BufferedReader multiEpisodeReader
	BufferedReader invalidReader

	void setUp() {
		movieReader = Thread.currentThread().getContextClassLoader().getResource("movie.nfo").newReader()
		tvShowReader = Thread.currentThread().getContextClassLoader().getResource("tvshow.nfo").newReader()
		episodeReader = Thread.currentThread().getContextClassLoader().getResource("episode.nfo").newReader()
		multiEpisodeReader = Thread.currentThread().getContextClassLoader().getResource("multiepisode.nfo").newReader()
		invalidReader = Thread.currentThread().getContextClassLoader().getResource("invalid.nfo").newReader()
	}

	void tearDown() {
		movieReader.close()
		tvShowReader.close()
		episodeReader.close()
		multiEpisodeReader.close()
	}

	void testToFile() {
		def movie = Movie.fromReader(movieReader)

		assert movie instanceof Movie

		def file = File.createTempFile('movie','.nfo')

		assert file.text.isEmpty()

		movie.toFile(file.absolutePath)

		assert !file.text.isEmpty()

		assert file.text == movie.toXml()

	}

	void testToXml() {
		def movie = Movie.fromReader(movieReader)

		def xml = movie.toXml()

		assert !xml.isEmpty()

		//movieReader = Thread.currentThread().getContextClassLoader().getResource("movie.nfo").newReader()

		//assert xml == movieReader.text

	}

	void testMarshallMovie() {
//		def movieReader = Movie.fromFile("P:/Peliculas/1080p/2001 - A Space Odyssey (Commentary) (1968) [1080p]/movieReader.nfo")


		def movie = Movie.fromReader(movieReader)

		assert movie instanceof Movie

		println movie


		println movie.toXml()
	}

	void testMarshallShow() {
//		def movieReader = Movie.fromFile("P:/Peliculas/1080p/2001 - A Space Odyssey (Commentary) (1968) [1080p]/movieReader.nfo")


		def show = TvShow.fromReader(tvShowReader)

		assert show instanceof TvShow

		println show


		println show.toXml()
	}

	void testMarshallEpisode() {
//		def movieReader = Movie.fromFile("P:/Peliculas/1080p/2001 - A Space Odyssey (Commentary) (1968) [1080p]/movieReader.nfo")


		def episode = Episode.fromReader(episodeReader)

		assert episode instanceof Episode

		println episode


		println episode.toXml()
	}

	void testMarshallMultiEpisode() {
//		def movieReader = Movie.fromFile("P:/Peliculas/1080p/2001 - A Space Odyssey (Commentary) (1968) [1080p]/movieReader.nfo")


		def multiEpisode = MultiEpisode.fromReader(multiEpisodeReader)

		assert multiEpisode instanceof MultiEpisode

		println multiEpisode


		println multiEpisode.toXml()
	}


	void testUnMarshall() {

	}

	void testDetectFileType() {
		assert Movie == Marshaller.detectFileType(movieReader)
		assert TvShow == Marshaller.detectFileType(tvShowReader)
		assert Episode == Marshaller.detectFileType(episodeReader)
		assert MultiEpisode == Marshaller.detectFileType(multiEpisodeReader)

		assert null == Marshaller.detectFileType(invalidReader)
	}
}
