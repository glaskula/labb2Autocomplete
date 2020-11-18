

import javax.sql.rowset.spi.SyncFactory;
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
        Comparator<Term> comparator = new Term.byLexicographicOrder();
        Arrays.sort(dictionary,comparator);
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Complexity: O(log N + M log M), where M is the number of matching terms
    public Term[] allMatches(String prefix) {
        Term term = new Term(prefix, 0);
        int first = RangeBinarySearch.firstIndexOf(dictionary, term, Term.byPrefixOrder(prefix.length()));
        if(first==-1){return new Term[0];}
        int last = RangeBinarySearch.lastIndexOf(dictionary, term, Term.byPrefixOrder(prefix.length()));
        Term[] matches = new Term[last-first+1];
        Comparator<Term> comparator = Term.byReverseWeightOrder();
        int c=0;
        for(int i = first; i<=last;i++){
            matches[c]= dictionary[i];
            c++;
        }
        Arrays.sort(matches,comparator);

        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    // Complexity: O(log N)
    public int numberOfMatches(String prefix) {
        Term term = new Term(prefix, 0);
        int first = RangeBinarySearch.firstIndexOf(dictionary, term, Term.byPrefixOrder(prefix.length()));
        if(first==-1){return 0;}
        int last = RangeBinarySearch.lastIndexOf(dictionary, term, Term.byPrefixOrder(prefix.length()));
        return last-first+1;
    }

}
