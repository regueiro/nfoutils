package es.regueiro.nfoutils.internal.model;

import java.nio.file.Path;

public class XbmcMediaFolder {

	private String name;
	private Path path;
	
	public XbmcMediaFolder(String name, Path path) {
		this.name = name;
		this.path = path;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the path
	 */
	public Path getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(Path path) {
		this.path = path;
	}


}
