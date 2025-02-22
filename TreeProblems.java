/*
 * *** YOUR NAME GOES HERE / YOUR SECTION NUMBER ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

import java.util.*;

public class TreeProblems {

  /**
   * Method different()
   *
   * Given two TreeSets of integers, return a TreeSet containing all elements 
   * that are NOT in both sets. In other words, return a TreeSet of all the
   * elements that are in one set but not the other.
   */
  
  public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {
    Set<Integer> tempA = new TreeSet<>(setA); // Copy of setA
    Set<Integer> tempB = new TreeSet<>(setB); // Copy of setB

    tempA.removeAll(setB); // Remove elements from setA that are also in setB
    tempB.removeAll(setA); // Remove elements from setB that are also in setA

    setA.clear();  // Clear original setA
    setA.addAll(tempA); // Add remaining elements from tempA
    setA.addAll(tempB); // Add remaining elements from tempB

    return setA;
  }


  /**
   * Method removeEven()
   *
   * Given a treeMap with the key as an integer, and the value as a String,
   * remove all <key, value> pairs where the key is even. 
   */

  public static void removeEven(Map<Integer, String> treeMap) {

    Set<Integer> evenKeys = new HashSet<>(treeMap.keySet()); // Copy all keys

    evenKeys.removeIf(key -> key % 2 != 0); // Keep only even keys
    evenKeys.forEach(treeMap::remove); // Remove even keys from the TreeMap

    return;
  }


  /**
   * Method treesEqual()
   *
   * Given two treeMaps, each with the key as an integer, and the value as a String,
   * return a boolean value indicating if the two trees are equal or not.
   */

  public boolean treesEqual(Map<Integer, String> tree1,Map<Integer, String> tree2 ) {
    if (tree1 == null && tree2 == null) {
      return true;
  }
  
  // If only one of them is null, they are not equal
  if (tree1 == null || tree2 == null) {
      return false;
  }

  // Compare sizes first; if different, they are not equal
  if (tree1.size() != tree2.size()) {
      return false;
  }

  // Compare the key-value pairs of both maps
  for (Map.Entry<Integer, String> entry : tree1.entrySet()) {
      if (!tree2.containsKey(entry.getKey()) || !tree2.get(entry.getKey()).equals(entry.getValue())) {
          return false;
      }
  }

  return true; // If all checks pass, the maps are equal
}
  

} // end treeProblems class
