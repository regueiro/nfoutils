package es.regueiro.nfoutils.jaxb;

import java.nio.file.Path;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import es.regueiro.nfoutils.model.Movie;

public class Marshaller {

	public static void marshall(Movie movie) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Movie.class);
			javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(movie, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static Movie unMarshall(Path file) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Movie.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Movie movie = (Movie) jaxbUnmarshaller.unmarshal(file.toFile());

			System.out.println(movie);
			return movie;

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

}
