package es.uvigo.esei.aed2.activity6.topologicalordering;

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

import es.uvigo.esei.aed2.activity7.data.GraphRepository;
import es.uvigo.esei.aed2.activity6.mapofmap.MapOfMap;
import static es.uvigo.esei.aed2.activity6.topologicalordering.TopologicalOrdering.getTopologicalOrder;
import es.uvigo.esei.aed2.graph.Vertex;

import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

public class TopologicalOrderingTestCase {

  private final GraphRepository graphs = new GraphRepository(
          MapOfMap::new, MapOfMap::new);

  @Test
  public void testGetTopologicalOrderEmptyList() {
    List<Vertex<String>> expResult = List.of();

    List<Vertex<String>> result = getTopologicalOrder(graphs.getEmptyGraph());

    assertThat(result, is(expResult));
  }

  @Test
  public void testGetTopologicalOrder1() {
    List<Vertex<String>> expResult = graphs.getListOfVertices1();

    List<Vertex<String>> result = getTopologicalOrder(graphs.getGraphTopologicalOrder1());

    assertThat(result, is(expResult));
  }

  @Test
  public void testGetTopologicalOrder2() {
    List<Vertex<String>> expResult1 = graphs.getListOfVertices2();
    List<Vertex<String>> expResult2 = graphs.getListOfVertices3();
    List<Vertex<String>> expResult3 = graphs.getListOfVertices4();

    List<Vertex<String>> result = getTopologicalOrder(graphs.getGraphTopologicalOrder2());

    assertThat(result, anyOf(
            is(expResult1),
            is(expResult2),
            is(expResult3)
    ));
  }
}
