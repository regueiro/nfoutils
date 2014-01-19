package es.regueiro.nfoutils.model;

import java.nio.file.Path;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class NfoFile {

	@XmlTransient
	private Path nfoFile;

	public Path getNfoFile() {
		return nfoFile;
	}

	public void setNfoFile(Path nfoFile) {
		this.nfoFile = nfoFile;
	}

}
