package es.regueiro.nfoutils.interfaces;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public interface Media extends INfoFile, Cleanable {

	public void save() throws IOException, JAXBException;

}
