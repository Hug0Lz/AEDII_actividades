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

import java.util.List;
import java.util.function.Supplier;

public class MapTestData {

  private final static int NO_KEY = 100;
  private final static int KEY = 3;
  private final static String VALUE = "TRES";

  private final static List<Integer> KEYS = List.of(1, 2, KEY, 4, 5, 6);
  private final static List<String> VALUES = List.of("UNO", "DOS", VALUE, "CUATRO", "CINCO", "SEIS");

  private final Supplier<Map<Integer, String>> mapSupplier;

  public MapTestData(Supplier<Map<Integer, String>> mapSupplier) {
    this.mapSupplier = mapSupplier;
  }

  private Map<Integer, String> createMapWith(List<Integer> keys, List<String> values) {
    final Map<Integer, String> map = this.getEmptyMap();

    for (int i = 0; i < keys.size(); i++) {
      map.add(keys.get(i), values.get(i));
    }

    return map;
  }

  public Integer getKey() {
    return KEY;
  }

  public String getValue() {
    return VALUE;
  }

  public Integer getNoKey() {
    return NO_KEY;
  }

  public Map<Integer, String> getEmptyMap() {
    return this.mapSupplier.get();
  }

  public Map<Integer, String> getMap() {
    return this.createMapWith(KEYS, VALUES);
  }

  public List<Integer> getKeys() {
    return KEYS;
  }

  public List<String> getValues() {
    return VALUES;
  }

}
