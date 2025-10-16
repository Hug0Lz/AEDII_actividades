package es.uvigo.esei.aed2.activity6.HashMap;

import java.util.*;

/*-
 * #%L
 * AEDII - Activities
 * %%
 * Copyright (C) 2025 Rosalía Laza Fidalgo, María Reyes Pavón Rial,
 * Florentino Fernández Riverola, María Novo Lourés, and Miguel Reboiro Jato
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import es.uvigo.esei.aed2.map.Map;

public class HashMap<K, V> implements Map<K, V> {
  private static final int CAPACITY = 50;

  private int size;
  private List<Pair<K, V>>[] map;

  public HashMap() {
    this(CAPACITY);
  }

  @SuppressWarnings("unchecked")
  private HashMap(int capacity) throws IllegalArgumentException {
    map = new List[capacity];
    size = 0;
    for (int i = 0; i < capacity; i++) {
      map[i] = new LinkedList<>();
    }
  }

  // Métodos lanzan excepción
  @Override
  public int size() {
 /*   int size = 0;
    for (List<Pair<K, V>> pairList : map) {
      for (Pair<K, V> kvPair : pairList) {
        size++;
      }
    }
    return size;*/
    return size;
  }

  @Override
  public V get(K key) {
    int listkey = calculateKey(key);
    if (listkey == -1) return null;
    for (Pair<K, V> pairList : map[calculateKey(key)]) {
      if (pairList.getKey().equals(key)) return pairList.getValue();
    }
    return null;
  }

  @Override
  public void add(K key, V value) throws NullPointerException {
    boolean inserted = false;
    int listPosition = calculateKey(key);
    if (calculateKey(key) == -1) throw new NullPointerException("");
    for (Pair<K, V> pair : map[listPosition]) {
      if (pair.getKey().equals(key)) {
        map[listPosition].set(map[listPosition].indexOf(pair), new Pair<>(key, value));
        inserted = true;
      }
    }
    if (!inserted) {
      map[listPosition].add(new Pair<>(key, value));
      size++;
    }
  }

  /**
   * Modifica: this
   * Produce: elimina la clave del map y su valor asociado, el cual se retorna.
   * Si la clave no existe devuelve null.
   *
   */
  @Override
  public V remove(K key) {
    int keyIdx = calculateKey(key);
    if (keyIdx == -1) return null;
    for (Pair<K, V> pair : map[keyIdx]) {
      if (pair.getKey().equals(key)) {
        V returnValue = pair.getValue();
        Pair<K, V> newPair = new Pair<>(key, returnValue);
        map[keyIdx].remove(newPair);
        size--;
        return returnValue;
      }
    }
    return null;
  }

  /**
   * @return Posición del array en la que se debería encontrar la clave (key)
   */
  private int calculateKey(K key) {
    if (key == null) return -1;
    return Math.abs(key.hashCode() % map.length);
  }

  /**
   * Produce: devuelve un conjunto con las claves del map
   */
  @Override
  public Set<K> getKeys() {
    Set<K> keySet = new HashSet<>();
    for (List<Pair<K, V>> pairList : map) {
      for (Pair<K, V> kvPair : pairList) {
        keySet.add(kvPair.getKey());
      }
    }
    return keySet;
  }

  /**
   * Produce: devuelve un iterator sobre los valores del map, de forma que el iterador devuelto
   * accede directamente a la estructura interna del mapa, sin realizar copias. Esto implica que las
   * modificaciones a través del iterador afectan directamente al estado del mapa.
   *
   */
  @Override
  public Iterator<V> getValues() {
    ArrayList<V> valuesIterator = new ArrayList<>();
    for (List<Pair<K, V>> pairList : map) {
      for (Pair<K, V> kvPair : pairList) {
        valuesIterator.add(kvPair.getValue());
      }
    }
    return valuesIterator.iterator();
  }

  /**
   * Produce: elimina todos los elementos del map, convirtiéndolo en un map vacío.
   */
  @Override
  public void clear() {
    for (List<Pair<K, V>> pairList : map) {
      pairList.clear();
    }
    size = 0;
  }

  private static class Pair<K, V> {

    private final K k;
    private V v;

    public Pair(K k, V v) {
      this.k = k;
      this.v = v;
    }

    public K getKey() {
      return k;
    }

    public V getValue() {
      return v;
    }

    public void setValue(V v) {
      this.v = v;
    }

    @Override
    public boolean equals(Object other) {
      if (other instanceof Pair) {
        Pair<?, ?> hp = (Pair<?, ?>) other;
        return this.k.equals(hp.k) && this.v.equals(hp.v);
      } else {
        return false;
      }
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(this.k) ^ Objects.hashCode(this.v);
    }
  }

}
