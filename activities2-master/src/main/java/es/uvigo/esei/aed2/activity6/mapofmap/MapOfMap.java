package es.uvigo.esei.aed2.activity6.mapofmap;

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

import es.uvigo.esei.aed2.activity6.HashMap.HashMap;
import es.uvigo.esei.aed2.graph.Edge;
import es.uvigo.esei.aed2.graph.Graph;
import es.uvigo.esei.aed2.graph.Vertex;
import es.uvigo.esei.aed2.map.Map;

public class MapOfMap<T, E> implements Graph<T, E> {

  private final Map<Vertex<T>, Map<Vertex<T>, E>> mapOfVertices;

  public MapOfMap() {
    this.mapOfVertices = new HashMap<>();
  }

  public MapOfMap(Set<Vertex<T>> vertices, Set<Edge<T, E>> edges) {
    mapOfVertices = new HashMap<>();
    for (Vertex<T> v : vertices) {
      addVertex(v);
    }
    for (Edge<T, E> e : edges) {
      addEdge(e.getSource(), e.getTarget(), e.getLabel());
    }
  }

  @Override
  public boolean isEmpty() {
    return (mapOfVertices.size() == 0);
  }

  @Override
  public int numberOfVertices() {
    return mapOfVertices.size();
  }

  @Override
  public boolean containsVertex(Vertex<T> vertex) {
    return mapOfVertices.get(vertex) != null;
  }

  @Override
  public boolean containsEdge(Vertex<T> source, Vertex<T> target, E label) {
    Map<Vertex<T>, E> vertex = mapOfVertices.get(source);

    return (vertex != null && vertex.get(target) != null && vertex.get(target).equals(label));
  }

  @Override
  public Set<Vertex<T>> getVertices() {
    return mapOfVertices.getKeys();
  }

  @Override
  public Set<Edge<T, E>> getEdges() {
    Set<Edge<T, E>> edgeSet = new HashSet<>();
    for (Vertex<T> v : mapOfVertices.getKeys()) { // Sacamos cada vértice
      Map<Vertex<T>, E> vertexTargets = mapOfVertices.get(v); // Sacamos a lista de referencias a outros vértices
      for (Vertex<T> edgeVertex : vertexTargets.getKeys()) { // Iteramos sobre a lista de referencias a outros vértices
        edgeSet.add(new Edge<>(v, edgeVertex, vertexTargets.get(edgeVertex))); // Engadimos cada Edge ao noso Set
      }
    }
    return edgeSet;
  }

  @Override
  public Set<Vertex<T>> getAdjacentsVertex(Vertex<T> vertex) throws NullPointerException {
    if (vertex == null) throw new NullPointerException("El vértice introducido no existe en el grafo");
    if (!mapOfVertices.getKeys().contains(vertex))
      return new HashSet<>();
    else {
      Map<Vertex<T>, E> mapaReferencias = mapOfVertices.get(vertex);
      return mapaReferencias.getKeys();
    }
  }

  @Override
  public boolean addVertex(Vertex<T> vertex) throws NullPointerException {
    if (vertex == null) throw new NullPointerException("El vértice a añadir no puede ser nulo");
    else {
      if (mapOfVertices.getKeys().contains(vertex)) return false;
      else {
        mapOfVertices.add(vertex, new HashMap<>());
        return true;
      }
    }
  }

  @Override
  public boolean addEdge(Vertex<T> source, Vertex<T> target, E label) throws NullPointerException, IllegalArgumentException {
    if (source == null || target == null || label == null) {
      throw new NullPointerException("El valor de los vértices y del label no puede ser nulo al añadir un Edge.");
    } else if (mapOfVertices.get(source) == null || mapOfVertices.get(target) == null) {
      throw new IllegalArgumentException("Los vertices especificados deben estar en el mapa.");
    } else {
      if (mapOfVertices.get(source).get(target) != null)
        return false; // devuelve falso en caso de que ya estuviera añadido el Edge
      else {
        mapOfVertices.get(source).add(target, label);
        return true;
      }
    }
  }

  @Override
  public boolean removeVertex(Vertex<T> vertex) throws NullPointerException {
    if (vertex == null) {
      throw new NullPointerException("El vértice a eliminar es nulo o no está en el mapa.");
    } else if (mapOfVertices.get(vertex) == null) {
      return false;
    } else {
      for (Vertex<T> v : mapOfVertices.getKeys()) {
        mapOfVertices.get(v).getKeys().remove(vertex);
      }
      mapOfVertices.remove(vertex);
      return true;
    }
  }

  @Override
  public boolean removeEdge(Vertex<T> source, Vertex<T> target, E label) throws NullPointerException {
    if (source == null || target == null)
      throw new NullPointerException("Los vértices de los que se quiere eliminar el Edge no pueden ser nulos");
    else if (!mapOfVertices.getKeys().contains(source) || !mapOfVertices.getKeys().contains(target))
      return false;
    else if (mapOfVertices.get(source).get(target) != label)
      return false;
    else
      mapOfVertices.get(source).remove(target);
    return true;
  }

  @Override
  public void clear() {
    for (Vertex<T> v : mapOfVertices.getKeys()) {
      mapOfVertices.remove(v);
    }
  }
}
