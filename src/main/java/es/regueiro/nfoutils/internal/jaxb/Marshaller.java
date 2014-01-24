package es.regueiro.nfoutils.internal.jaxb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import es.regueiro.nfoutils.Episode;
import es.regueiro.nfoutils.Movie;
import es.regueiro.nfoutils.MultiEpisode;
import es.regueiro.nfoutils.TvShow;
import es.regueiro.nfoutils.interfaces.INfoFile;

public class Marshaller {
	private static final Logger logger = LoggerFactory.getLogger(Marshaller.class);

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private static final String ENCODING = "UTF-8";

	public static <T extends INfoFile> void marshall(T object, Class<T> type) throws IOException, JAXBException {
		if (type.equals(MultiEpisode.class)) {
			marshallMultiEpisode((MultiEpisode) object);
		} else {

			JAXBContext jaxbContext = JAXBContext.newInstance(type);
			javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, ENCODING);

			jaxbMarshaller.marshal(object, System.out);
		}
	}

	private static void marshallMultiEpisode(MultiEpisode multiEpisode) throws IOException, JAXBException {

		Path file = multiEpisode.getNfoFile();

		if (file != null) {
			try (BufferedWriter bufferedWriter = Files.newBufferedWriter(multiEpisode.getNfoFile(),
					Charset.forName(ENCODING), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);) {

				JAXBContext jaxbContext = JAXBContext.newInstance(Episode.class);
				javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT, true);
				jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, ENCODING);

				bufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>");

				for (Episode episode : multiEpisode.getEpisodes()) {
					jaxbMarshaller.marshal(episode, bufferedWriter);
					bufferedWriter.append(LINE_SEPARATOR);
				}

				bufferedWriter.toString();

			}

		} else {
			throw new IllegalArgumentException("The MultiEpisode object does not contain an nfo file path");
		}

	}

	public static <T extends INfoFile> T unMarshall(Path file, Class<T> type) throws JAXBException, IOException {
		if (type.equals(MultiEpisode.class)) {
			@SuppressWarnings("unchecked")
			T multiEpisode = (T) unMarshallMultiEpisode(file);
			return multiEpisode;
		} else {
			JAXBContext jaxbContext = JAXBContext.newInstance(type);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			@SuppressWarnings("unchecked")
			T object = (T) jaxbUnmarshaller.unmarshal(file.toFile());
			object.setNfoFile(file);

			return object;
		}
	}

	private static MultiEpisode unMarshallMultiEpisode(Path file) throws JAXBException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Episode.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		String xml = readFile(file);

		String[] episodes = xml.split("</episodedetails>");

		MultiEpisode multiEpisode = new MultiEpisode();

		for (String s : episodes) {
			if (s.contains("<episodedetails>")) {
				StringReader reader = new StringReader(s + "</episodedetails>");
				Episode episodeDetails = (Episode) jaxbUnmarshaller.unmarshal(reader);
				multiEpisode.addEpisode(episodeDetails);
			}
		}

		return multiEpisode;
	}

	private static String readFile(Path file) throws IOException {
		StringBuilder out = new StringBuilder();
		String line = null;

		BufferedReader bufferedReader = Files.newBufferedReader(file, Charset.forName(ENCODING));

		while ((line = bufferedReader.readLine()) != null) {
			out.append(line);
			out.append(LINE_SEPARATOR);
		}

		return out.toString();
	}

	public static Class<? extends INfoFile> detectFileType(Path file) throws ParserConfigurationException, SAXException,
			IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		builder = factory.newDocumentBuilder();

		try {
			Document document = builder.parse(file.toFile());

			switch (document.getFirstChild().getNodeName()) {
			case "movie":
				return Movie.class;
			case "tvshow":
				return TvShow.class;
			case "episodedetails":
				return Episode.class;
			default:
				return null;
			}

		} catch (SAXParseException e) {
			try {
				unMarshallMultiEpisode(file);
				return MultiEpisode.class;
			} catch (JAXBException e1) {
				throw e;
			}
		}
	}
}
