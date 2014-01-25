package es.regueiro.nfoutils;

import java.nio.file.Path;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import es.regueiro.nfoutils.interfaces.INfoFile;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class NfoFile implements INfoFile {

	@XmlTransient
	private Path nfoFile;

	public Path getNfoFile() {
		return nfoFile;
	}

	public void setNfoFile(Path nfoFile) {
		this.nfoFile = nfoFile;
	}

}