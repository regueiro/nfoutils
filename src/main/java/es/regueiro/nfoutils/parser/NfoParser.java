package es.regueiro.nfoutils.parser;

import java.nio.file.Path;

import es.regueiro.nfoutils.model.Movie;

public interface NfoParser {

	public Movie parseMovie(Path nfoFile);
}
