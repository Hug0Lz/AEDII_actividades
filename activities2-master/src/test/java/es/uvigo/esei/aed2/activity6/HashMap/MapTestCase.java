package es.uvigo.esei.aed2.activity6.HashMap;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public abstract class MapTestCase {

  private final MapTestData data;

  public MapTestCase(Supplier<Map<Integer, String>> newEmptyMap) {
    this.data = new MapTestData(newEmptyMap);
  }

  /**
   * Test of size method, of class HashMap.
   */
  @Test
  public void testSizeEmptyMap() {
    final Map<Integer, String> map = this.data.getEmptyMap();

    assertThat(map.size(), is(0));
  }

  @Test
  public void testSizeMap() {
    final Map<Integer, String> map = this.data.getMap();

    assertThat(map.size(), is(6));
  }

  /**
   * Test of get method, of class HashMap.
   */
  @Test
  public void testGetNullKey() {
    final Map<Integer, String> map = this.data.getEmptyMap();

    assertThat(map.get(null), nullValue());
  }

  @Test
  public void testGetEmptyMap() {
    final Map<Integer, String> map = this.data.getEmptyMap();

    assertThat(map.get(this.data.getKey()), nullValue());
  }

  @Test
  public void testGetMapNoKey() {
    final Map<Integer, String> map = this.data.getMap();

    assertThat(map.get(this.data.getNoKey()), nullValue());
  }

  @Test
  public void testGetMap() {
    final Map<Integer, String> map = this.data.getMap();

    assertThat(map.get(this.data.getKey()), is(this.data.getValue()));
  }

  /**
   * Test of add method, of class HashMap.
   */
  @Test
  public void testAddNullKey() {
    final Map<Integer, String> map = this.data.getEmptyMap();

    assertThrows(NullPointerException.class, () -> map.add(null, this.data.getValue()));
  }

  @Test
  public void testAddKeyRepeated() {
    final Map<Integer, String> map = this.data.getMap();

    map.add(this.data.getKey(), "");

    assertThat(map.size(), is(this.data.getMap().size()));
    assertThat(map.get(this.data.getKey()), is(""));
  }

  @Test
  public void testAddKey() {
    final Map<Integer, String> map = this.data.getMap();

    map.add(this.data.getNoKey(), "");

    assertThat(map.size(), is(this.data.getMap().size() + 1));
    assertThat(map.get(this.data.getNoKey()), is(""));
  }

  /**
   * Test of remove method, of class HashMap.
   */
  @Test
  public void testRemoveNullKey() {
    final Map<Integer, String> map = this.data.getMap();

    String value = map.remove(null);

    assertThat(value, is(nullValue()));
    assertThat(map.size(), is(this.data.getMap().size()));
  }

  @Test
  public void testRemoveKey() {
    final Map<Integer, String> map = this.data.getMap();

    String value = map.remove(this.data.getKey());

    assertThat(value, is(this.data.getValue()));
    assertThat(map.size(), is(this.data.getMap().size() - 1));
  }

  @Test
  public void testRemoveNoKey() {
    final Map<Integer, String> map = this.data.getMap();

    String value = map.remove(this.data.getNoKey());

    assertThat(value, nullValue());
    assertThat(map.size(), is(this.data.getMap().size()));
  }

  /**
   * Test of getKeys method, of class HashMap.
   */
  private <T> List<T> toList(Iterator<T> iterator) {
    List<T> list = new ArrayList<>();
    while (iterator.hasNext()) {
      list.add(iterator.next());
    }
    return list;
  }

  @Test
  public void testGetKeysEmptyMap() {
    final Map<Integer, String> map = this.data.getEmptyMap();

    Set<Integer> keys = map.getKeys();

    assertThat(keys.isEmpty(), is(true));
    
  }

  @Test
  public void testGetKeysMap() {
    final Map<Integer, String> map = this.data.getMap();
    
    Set<Integer> keys = map.getKeys();

    Set<Integer> expected = new HashSet<>(this.data.getKeys());

    assertThat(keys, is(expected));
  }

  /**
   * Test of getValues method, of class HashMap.
   */
  @Test
  public void testGetValuesEmptyMap() {
    final Map<Integer, String> map = this.data.getEmptyMap();
    
    Iterator<String> iteratorValues = map.getValues();

    assertThat(iteratorValues.hasNext(), is(false));
  }

  @Test
  public void testGetValuesMap() {
    final Map<Integer, String> map = this.data.getMap();

    Iterator<String> iteratorValues = map.getValues();
    List<String> valuesList = new ArrayList<>(toList(iteratorValues));
    Collections.sort(valuesList);

    List<String> expected = new ArrayList<>(this.data.getValues());
    Collections.sort(expected);

    assertThat(valuesList, is(expected));
  }

  /**
   * Test of clear method, of class HashMap.
   */
  @Test
  public void testClearEmptyMap() {
    final Map<Integer, String> map = this.data.getEmptyMap();

    map.clear();

    assertThat(map.size(), is(0));
  }

  public void testClearMap() {
    final Map<Integer, String> map = this.data.getMap();

    map.clear();

    assertThat(map.size(), is(0));
  }

}
