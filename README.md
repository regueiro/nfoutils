nfoutils
========

Library for parsing and creating NFO files for media content.

Usage
-----

**Read** existing nfo files by calling the method `fromFile(Path)` on a media object.

```java
es.regueiro.nfoutils.Movie movie = es.regueiro.nfoutils.Movie.fromFile(Paths.get("/media/movies/movie.nfo"));
```

Or use the `NfoFileLoader`.

```java
es.regueiro.nfoutils.Movie movie = NfoFIleLoader.loadMovie(Paths.get("/media/movies/movie.nfo"));
```

**Save** a file by setting the atribute `nfoFile` and calling the method `save()`.

```java
movie.setNfoFile(Paths.get("/media/movies/movie.nfo"));
movie.save();
```


Notes
-----

nfoutils **does not support** the following:

- Including a URL at the end of the NFO file.
- Adding the attribute `clear="true"`.


Changelog
----------

- 0.1 - 2014-01-25 -  Initial release


License
-------

Please see the **COPYING** file.
