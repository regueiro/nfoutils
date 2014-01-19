package es.regueiro.nfoutils.media;

import java.io.IOException;

import javax.xml.bind.JAXBException;

interface Media extends NfoFile, Cleanable {

	public void save() throws IOException, JAXBException;

}
