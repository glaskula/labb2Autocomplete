

import java.nio.charset.CoderMalfunctionError;
import java.sql.Array;
import java.util.*;

public class Autocomplete {
    private Term[] dictionary;

    // Initializes the dictionary from the given array of terms.
    public Autocomplete(Term[] dictionary) {
        this.dictionary = dictionary;
        sortDictionary();
    }

    // Sorts the dictionary in *case-insensitive* lexicographic order.
    // Complexity: O(N log N), where N is the number of terms
    private void sortDictionary() {
        /* TODO */
        Comparator<Term> comparator = new Term.byLexicographicOrder();

        List<Term> d=Arrays.asList(dictionary);
        Collections.sort(d,comparator);
        for (int i = 0; i < dictionary.length; i++){
            dictionary[i] = d.get(i);
            System.out.println(dictionary[i]);
        }
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Complexity: O(log N + M log M), where M is the number of matching terms
    public Term[] allMatches(String prefix) {
        /* TODO */
        return null;
    }

    // Returns the number of terms that start with the given prefix.
    // Complexity: O(log N)
    public int numberOfMatches(String prefix) {
        /* TODO */
        Term term = new Term(prefix, 0);
        int first = RangeBinarySearch.firstIndexOf(dictionary, term, Term.byPrefixOrder(prefix.length()));
        int last = RangeBinarySearch.lastIndexOf(dictionary, term, Term.byPrefixOrder(prefix.length()));
        if(first==-1){return -1;}
        else return last-first+1;
    }

}
