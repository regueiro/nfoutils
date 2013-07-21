package es.regueiro.nfoutils.parser.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import es.regueiro.nfoutils.model.Actor;
import es.regueiro.nfoutils.model.ActorRole;
import es.regueiro.nfoutils.model.Country;
import es.regueiro.nfoutils.model.Director;
import es.regueiro.nfoutils.model.Genre;
import es.regueiro.nfoutils.model.Movie;
import es.regueiro.nfoutils.model.Studio;
import es.regueiro.nfoutils.model.Writer;
import es.regueiro.nfoutils.parser.NfoParser;

public class SaxNfoParser implements NfoParser {
	/** The logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(SaxNfoParser.class);

	SAXParser saxParser;

	public SaxNfoParser() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			logger.error("Error trying to instantiate SAXParser");
			logger.error(e.getStackTrace().toString());
		}
	}

	@Override
	public Movie parseMovie(Path nfoFile) {
		Movie movie = null;
		MovieHandler handler = new MovieHandler();

		try {
			InputStream in = Files.newInputStream(nfoFile);
			Reader reader = new InputStreamReader(in, "UTF-8");
			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");

			saxParser.parse(is, handler);
			movie = handler.getMovie();

		} catch (SAXException | IOException e) {
			logger.error("Error trying to parse: " + nfoFile.toString());
			logger.error(e.getStackTrace().toString());
		}
		return movie;
	}

	private class MovieHandler extends DefaultHandler {

		private Movie movie;
		private Actor currentActor = null;
		ActorRole currentRole = null;
	
		private boolean isMovie;
		private boolean isId;
		private boolean isTitle;
		private boolean isOriginalTitle;
		private boolean isSortTitle;
		private boolean isTagline;
		private boolean isOutline;
		private boolean isPlot;
		private boolean isDirector;
		private boolean isCredits;
		private boolean isYear;
		private boolean isReleaseDate;
		private boolean isCountry;
		private boolean isRating;
		private boolean isVotes;
		private boolean isMpaa;
		private boolean isCertification;
		private boolean isGenre;
		private boolean isStudio;
		private boolean isRuntime;
		private boolean isActor;
		private boolean isActorName;
		private boolean isActorRole;
		private boolean isActorThumb;
		private boolean isMovieThumb;
		private boolean isTop250;
		private boolean isPlayCount;
		private boolean isTrailer;
		private boolean isFileInfo;
		private boolean isFanart;
		private boolean isFanartThumb;

		private String value;
		
		public Movie getMovie() {
			return movie;
		}
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
		 */
		@Override
		public void startDocument() throws SAXException {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
		 */
		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.endDocument();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
		 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
		 */
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
//
//			logger.debug(qName.toString());
//			logger.debug(attributes.toString());
//			logger.debug(attributes.getType(qName));
//			logger.debug(attributes.getValue(qName));

			value = "";
			
			if (qName.equalsIgnoreCase("movie")) {
				isMovie = true;
				movie = new Movie();
			} else if (qName.equalsIgnoreCase("id")) {
				isId = true;
			} else if (qName.equalsIgnoreCase("title")) {
				isTitle = true;
			} else if (qName.equalsIgnoreCase("originaltitle")) {
				isOriginalTitle = true;
			} else if (qName.equalsIgnoreCase("sorttitle")) {
				isSortTitle = true;
			} else if (qName.equalsIgnoreCase("tagline")) {
				isTagline = true;
			} else if (qName.equalsIgnoreCase("outline")) {
				isOutline = true;
			} else if (qName.equalsIgnoreCase("plot")) {
				isPlot = true;
			} else if (qName.equalsIgnoreCase("director")) {
				isDirector = true;
			} else if (qName.equalsIgnoreCase("credits")) {
				isCredits = true;
			} else if (qName.equalsIgnoreCase("year")) {
				isYear = true;
			} else if (qName.equalsIgnoreCase("releasedate")) {
				isReleaseDate = true;
			} else if (qName.equalsIgnoreCase("country")) {
				isCountry = true;
			} else if (qName.equalsIgnoreCase("rating")) {
				isRating = true;
			} else if (qName.equalsIgnoreCase("votes")) {
				isVotes = true;
			} else if (qName.equalsIgnoreCase("mpaa")) {
				isMpaa = true;
			} else if (qName.equalsIgnoreCase("certification")) {
				isCertification = true;
			} else if (qName.equalsIgnoreCase("genre")) {
				isGenre = true;
			} else if (qName.equalsIgnoreCase("studio")) {
				isStudio = true;
			} else if (qName.equalsIgnoreCase("runtime")) {
				isRuntime = true;
			} else if (qName.equalsIgnoreCase("actor")) {
				isActor = true;
				currentActor = new Actor();
				currentRole = new ActorRole(currentActor, movie);
			} else if (qName.equalsIgnoreCase("name")) {
				isActorName = true;
			} else if (qName.equalsIgnoreCase("role")) {
				isActorRole = true;
			} else if (qName.equalsIgnoreCase("thumb")) {
				if (isActor) {
					isActorThumb = true;
				} else if (isFanart){
					isFanartThumb = true;
				} else {
					isMovieThumb = true;
				}
			} else if (qName.equalsIgnoreCase("top250")) {
				isTop250 = true;
			} else if (qName.equalsIgnoreCase("playcount")) {
				isPlayCount = true;
			} else if (qName.equalsIgnoreCase("trailer")) {
				isTrailer = true;
			} else if (qName.equalsIgnoreCase("fileinfo")) {
				isFileInfo = true;
			} else if (qName.equalsIgnoreCase("fanart")) {
				isFanart = true;
			} else {
				if (!isFileInfo) {
				logger.debug("Unhandled tag: " + qName+"; movie:"+movie.getTitle());
				}
			}
			//TODO: Parse fanart tags, fanart thumbs and sets
			//TODO: Do something with fileinfo tags?

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
		 * java.lang.String, java.lang.String)
		 */
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if (qName.equalsIgnoreCase("movie")) {
				isMovie = false;
			} else if (qName.equalsIgnoreCase("id")) {
				isId = false;
			} else if (qName.equalsIgnoreCase("title")) {
				isTitle = false;
			} else if (qName.equalsIgnoreCase("originaltitle")) {
				isOriginalTitle = false;
			} else if (qName.equalsIgnoreCase("sorttitle")) {
				isSortTitle = false;
			} else if (qName.equalsIgnoreCase("tagline")) {
				isTagline = false;
			} else if (qName.equalsIgnoreCase("outline")) {
				isOutline = false;
			} else if (qName.equalsIgnoreCase("plot")) {
				isPlot = false;
			} else if (qName.equalsIgnoreCase("director")) {
				isDirector = false;
			} else if (qName.equalsIgnoreCase("credits")) {
				isCredits = false;
			} else if (qName.equalsIgnoreCase("year")) {
				isYear = false;
			} else if (qName.equalsIgnoreCase("releasedate")) {
				isReleaseDate = false;
			} else if (qName.equalsIgnoreCase("country")) {
				isCountry = false;
			} else if (qName.equalsIgnoreCase("rating")) {
				isRating = false;
			} else if (qName.equalsIgnoreCase("votes")) {
				isVotes = false;
			} else if (qName.equalsIgnoreCase("mpaa")) {
				isMpaa = false;
			} else if (qName.equalsIgnoreCase("certification")) {
				isCertification = false;
			} else if (qName.equalsIgnoreCase("genre")) {
				isGenre = false;
			} else if (qName.equalsIgnoreCase("studio")) {
				isStudio = false;
			} else if (qName.equalsIgnoreCase("runtime")) {
				isRuntime = false;
			} else if (qName.equalsIgnoreCase("actor")) {
				isActor = false;
				currentActor.addRole(currentRole);
				movie.addCast(currentRole);
			} else if (qName.equalsIgnoreCase("name")) {
				isActorName = false;
			} else if (qName.equalsIgnoreCase("role")) {
				isActorRole = false;
			} else if (qName.equalsIgnoreCase("thumb")) {
				if (isActor) {
					isActorThumb = false;
				} else {
					isMovieThumb = false;
				}
			} else if (qName.equalsIgnoreCase("top250")) {
				isTop250 = false;
			} else if (qName.equalsIgnoreCase("playcount")) {
				isPlayCount = false;
			} else if (qName.equalsIgnoreCase("trailer")) {
				isTrailer = false;
			} else if (qName.equalsIgnoreCase("fileinfo")) {
				isFileInfo = false;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
		 */
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			value += new String(ch, start, length);
			if (value.trim().isEmpty()) {
				return;
			}
			//logger.debug("Tag value: \""+value+"\"");
			if (isId) {
				movie.setImdbID(value);
			} else if (isTitle) {
				movie.setTitle(value);
			} else if (isOriginalTitle) {
				movie.setOriginalTitle(value);
			} else if (isSortTitle) {
				movie.setSortTitle(value);
			} else if (isTagline) {
				movie.setTagline(value);
			} else if (isOutline) {
				movie.setOutline(value);
			} else if (isPlot) {
				movie.setPlot(value);
			} else if (isDirector) {
				Director director = new Director(value);
				movie.addDirector(director);
			} else if (isCredits) {
				Writer writer = new Writer(value);
				movie.addWriter(writer);
			} else if (isYear) {
				int year = Integer.parseInt(value);
				movie.setYear(year);
			} else if (isReleaseDate) {
				DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
				LocalDate date = formatter.parseLocalDate(value);
				movie.setDate(date);
			} else if (isCountry) {
				Country country = new Country(value);
				movie.addCountry(country);
			} else if (isRating) {
				movie.setRating(value);
			} else if (isVotes) {
				movie.setVotes(value);
			} else if (isMpaa) {
				movie.setMpaa(value);
			} else if (isCertification) {
				movie.setCertification(value);
			} else if (isGenre) {
				Genre genre = new Genre(value);
				movie.addGenre(genre);
			} else if (isStudio) {
				Studio studio = new Studio(value);
				movie.addStudio(studio);
			} else if (isRuntime) {
				movie.setRuntime(value);
//			} else if (isActor) {
//				
			} else if (isActorName) {
				currentActor.setName(value);
			} else if (isActorRole) {
				currentRole.setRole(value);
			} else if (isActorThumb) {
				currentRole.setThumb(value);
			} else if (isMovieThumb) {
				movie.addThumb(value);
			} else if (isTop250) {
				movie.setTop250(value);
			} else if (isPlayCount) {
				int playcount = Integer.parseInt(value);
				movie.setPlaycount(playcount);
			} else if (isTrailer) {
				movie.setTrailer(value);
			}
		}
	}
}