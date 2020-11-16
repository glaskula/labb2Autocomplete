
import java.util.Comparator;

public class RangeBinarySearch {

    // Returns the index of the *first* element in terms[] that equals the search key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N), where N is the length of the array
    public static int firstIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        if (key == null) {
            return -1;
        }
        int lo = 0;
        int hi = terms.length - 1;
        while (lo <= hi) {
            int search = lo + (hi - lo) / 2;
            if (comparator.compare(key,terms[search]) < 0) {
                hi = search - 1;
            }
            else if (comparator.compare(key,terms[search]) > 0){
                lo = search + 1;
            }
            else if (comparator.compare(key,terms[search]) == 0){
                if (search == 0) {
                    return search;
                }
                else if (comparator.compare(key,terms[search - 1]) > 0) {
                    return search;
                }
                else {
                    hi = search - 1;
                }
            }
        }
        return -1;
    }

    // Returns the index of the *last* element in terms[] that equals the search key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N)
    public static int lastIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        if (key == null) {
            return -1;
        }
        int lo = 0;
        int hi = terms.length - 1;
        while (lo <= hi) {
            int search = lo + (hi - lo) / 2;
            if (comparator.compare(key,terms[search]) > 0){
                lo = search + 1;
            }
            else if (comparator.compare(key,terms[search]) < 0) {
                hi = search - 1;
            }
            else if (comparator.compare(key,terms[search]) == 0){
                if (search == terms.length - 1) {
                    return search;
                }
                else if (comparator.compare(key,terms[search + 1]) < 0) {
                    return search;
                }
                else {
                    lo = search + 1;
                }
            }
        }
        return -1;
    }

}
