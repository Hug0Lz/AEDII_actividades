package es.uvigo.esei.aed2.activity6.relatedwords;

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
import es.uvigo.esei.aed2.activity6.mapofmap.MapOfMap;
import java.util.List;
import es.uvigo.esei.aed2.graph.Graph;
import es.uvigo.esei.aed2.graph.Vertex;
import es.uvigo.esei.aed2.map.Map;
import java.util.ArrayList;


public class RelatedWords {

    /**
     * Construye un grafo que representa las relaciones entre las palabras.
     *
     * @param words palabras a relacionar.
     * @return grafo de palabras relacionadas.
     */
    public static Graph<String, Integer> buildGraph(List<String> words) {
        // TODO: Implementa la construcción del grafo de palabras relacionadas

  Graph<String, Integer> graph = new MapOfMap<>();  
  
    if (words == null || words.isEmpty()) {
        return graph;
    }
    
    // 1. Añadir vértices
    for (String word : words) {
        graph.addVertex(new Vertex<>(word));
    }
    
    // 2. Crear diccionario de patrones
    Map<String, List<String>> diccionario = llenarMapa(words);

    // 3. Conectar vértices (forma simple sin verificar duplicados)
    for (String key : diccionario.getKeys()) {
        List<String> lista = diccionario.get(key);
        
        if (lista.size() > 1) {
            // Conectar todos los pares posibles en esta lista
            for (int i = 0; i < lista.size(); i++) {
                for (int j = i + 1; j < lista.size(); j++) {

                        graph.addEdge(new Vertex<>(lista.get(i)), new Vertex<>(lista.get(j)), 0);
                        graph.addEdge(new Vertex<>(lista.get(j)), new Vertex<>(lista.get(i)), 0);
                }
            }
        }
    }
    
    return graph;
    }
private static Map<String, List<String>> llenarMapa(List<String> words) {

           Map<String, List<String>> mapa = new HashMap<>();
    
    for (String word : words) {

        
        for (int i = 0; i < word.length(); i++) {
            String k = word.substring(0, i) + "_" + word.substring(i + 1);
            
            List<String> lista = mapa.get(k);
            if (lista == null) {
                lista = new ArrayList<>();
            }
            lista.add(word);
            mapa.add(k, lista);
        }
    }
        return mapa;
    }
}
