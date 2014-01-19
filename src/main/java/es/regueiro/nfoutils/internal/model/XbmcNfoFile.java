package es.regueiro.nfoutils.internal.model;

import java.nio.file.Path;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import es.regueiro.nfoutils.media.NfoFile;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class XbmcNfoFile implements NfoFile{

	@XmlTransient
	private Path nfoFile;

	public Path getNfoFile() {
		return nfoFile;
	}

	public void setNfoFile(Path nfoFile) {
		this.nfoFile = nfoFile;
	}

}
