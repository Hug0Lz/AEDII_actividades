
package es.uvigo.esei.aed2.activity6.anagrams;

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

import static es.uvigo.esei.aed2.activity6.anagrams.Anagrams.getAnagrams;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class AnagramsTestCase {
  
  @Test
  public void testGetAnagramsEmptyList() {
    List<String> words = new LinkedList<>();
        
    Set<Set<String>> anagrams = getAnagrams(words);
    
    assertThat(anagrams.isEmpty(), is(true));  
  }

  @Test
  public void testGetAnagramsList() {
    List<String> words = List.of("rat", "art", "bat", "tab", "cat", "tar");
    Set<Set<String>> setOfAnagrams = Set.of(Set.of("rat", "tar", "art"),
            Set.of("bat", "tab"),
            Set.of("cat")
    );

    Set<Set<String>> anagrams = getAnagrams(words);

    assertThat(setOfAnagrams.equals(anagrams), is(true));
  }
     
}
