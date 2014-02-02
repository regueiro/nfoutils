nfoutils
========

Library for parsing and creating NFO files for media content. Built in Groovy and compatible with Java.

Usage
-----

**Read** existing nfo files by calling the method `fromFile(String)`,  `fromXml(String)` or  `fromReader(Reader)`  on a media object.


```java
def movie = Movie.fromFile '/media/movies/movie.nfo'
def movie = Movie.fromXml '<movie>...</movie>'
def show = TvShow.fromReader(bufferedReader)

```
```java
Movie movie = Movie.fromFile("/media/movies/movie.nfo");
Movie movie = Movie.fromXml("<movie>...</movie>");
TvShow show = TvShow.fromReader(bufferedReader);
```

**Save** a nfo file by calling the method `toFile(String)` or `toXml(String)`.

```java
movie.toFile '/media/movies/movie.nfo'
movie.toXml()
```

```java
movie.toFile("/media/movies/movie.nfo");
movie.toXml();
```


Notes
-----

nfoutils **does not support** the following:

- Including a URL at the end of the NFO file.
- Adding the attribute `clear="true"`.


Changelog
----------

- 0.2-SNAPSHOT - 2014-02-02 
	-  Ported to Groovy. 
	-  Added methods to read from and write to Files, Strings and Readers/Writers

- 0.1 - 2014-01-25 
	-  Initial release


License
-------

Please see the **LICENSE** file.
