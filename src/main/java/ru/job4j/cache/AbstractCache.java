package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstraktnyj klass-shablon na osnove kotorogo budet sozdavat'sja klass
 * keshirovanija fajlov iz papki, bazy dannyh i t.p.
 *
 * @param <K> kljuch po kotoromu zapolnjaetsja kesh
 * @param <V> vozvrashhaemoe znachenie
 */
public abstract class AbstractCache<K, V> {
    public AbstractCache() {
    }

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    /**
     * @param key kljuch
     * @param value znachenie
     */
    public void put(K key, V value) {
        SoftReference<V> reference = new SoftReference<>(value);
        cache.put(key, reference);
    }

    /**
     * metod vozvrashhaet soderzhimoe fajla
     * proishodit zagruzka v kesh, esli on pustoj s pomoshh'ju metoda load() i vozvrat soderzhimogo fajla
     *
     * @param key kljuch
     * @return vozvrashhaemoe soderzhimoe fajla
     */
    public V get(K key) {
        V value = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (value == null) {
            value = load(key);
            put(key, value);
        }
        return value;
    }

    /**
     * Metod vypolnjaet zagruzku fajla v kesh
     *
     * @param key kljuch
     * @return vozvrashhaemoe znachenie
     */
    protected abstract V load(K key);
}