package ru.job4j.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Klass, v kotorom vypolnjaetsja chtenie fajla iz papki i zapis' ego soderzhimogo v kesh
 */
public class DirFileCache extends AbstractCache<String, String> {
    private static final Logger LOG = LoggerFactory.getLogger(DirFileCache.class.getName());
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    /**
     * Metod, chitajushhij iz ukazannogo fajla i zapisyvajushhij v kesh     *
     *
     * @param key kljuch (imja fajla)
     * @return vozvrashhaemoe soderzhimoe fajla
     */
    @Override
    protected String load(String key) {
        String value = null;
        try {
            value = Files.readString(Path.of(cachingDir, key));
        } catch (IOException e) {
            LOG.error("Wrong path... ", e);
        }
        return value;
    }
}