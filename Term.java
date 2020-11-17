


import java.nio.charset.CoderResult;
import java.util.Comparator;

public class Term {
    private String word;
    private long weight;

    // Initializes a term with a given word and weight.
    public Term(String word, long weight) {
        this.word = word;
        this.weight = weight;
    }

    // Gets the word.
    public String getWord() {
        return word;
    }

    // Gets the weight.
    public long getWeight() {
        return weight;
    }

    // Extracts a prefix from the word.
    public String getPrefix(int len) {
        if(word.length()>=len) {
            return word.substring(0, len);
        }
    return word;}

    // Compares the two terms in case-insensitive lexicographic order.
    public static Comparator<Term> byLexicographicOrder() {
        return new byLexicographicOrder();
    }


    public static class byLexicographicOrder implements Comparator<Term>{
        @Override
        public int compare(Term term1, Term term2){
            if(term1.getWord().length()>term2.getWord().length()){
                int length = term2.getWord().length();
                return term1.getWord().substring(0,length).compareToIgnoreCase(term2.getWord().substring(0,length));
            }
            return term1.getWord().compareToIgnoreCase(term2.getWord().substring(0,term1.getWord().length())); }
    }


    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return Comparator.comparingLong(Term::getWeight);
    }

    // Compares the two terms in case-insensitive lexicographic order,
    // but using only the first k characters of each word.
    public static Comparator<Term> byPrefixOrder(int k) {
        byPrefixOrder.k=k;
        return new byPrefixOrder();
    }
    public static class byPrefixOrder implements Comparator<Term>{
        private static int k;
        @Override
        public int compare(Term term1, Term term2){
            if(k>=term2.getWord().length()){
                return term1.getPrefix(k).compareToIgnoreCase(term2.getWord());
            }
        return term1.getPrefix(k).compareToIgnoreCase(term2.getPrefix(k)); }
    }


    // Returns a string representation of this term in the following format:
    // the weight, followed by whitespace, followed by the word.
    public String toString() {
        return String.format("%12d    %s", this.getWeight(), this.getWord());
    }


}
