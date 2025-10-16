
package es.uvigo.esei.aed2.activity6.relatedwords;

import java.util.Set;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

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

import es.uvigo.esei.aed2.graph.Edge;
import es.uvigo.esei.aed2.graph.Graph;
import es.uvigo.esei.aed2.graph.Vertex;

public class IsEqualToGraph<T,E> extends TypeSafeMatcher<Graph<T,E>> {

  private final Graph<T,E> expected;

  public IsEqualToGraph(Graph<T,E> expected) {
    this.expected = expected;
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("equal graph");
  }

  @Override
  protected boolean matchesSafely(Graph<T,E> actual) {
    // Comparar vértices
    Set<Vertex<T>> verticesActual = actual.getVertices();
    Set<Vertex<T>> verticesExpected = expected.getVertices();
    if (!verticesActual.equals(verticesExpected)) {
        return false;
    }

    // Comparar arcos
    Set<Edge<T, E>> edgesActual = actual.getEdges();
    Set<Edge<T, E>> edgesExpected = expected.getEdges();
    return edgesActual.equals(edgesExpected);
        
  }

  public static <T,E> IsEqualToGraph<T,E> equalToGraph(Graph<T,E> expected) {
    return new IsEqualToGraph<>(expected);
  }
  
}
