import java.util.Objects;

public class Word implements Comparable<Word> {
    private String word_target;
    private String word_explain;

    public void setWord_target(String newWord) {
        this.word_target = newWord;
    }

    public void setWord_explain(String newWord_explain) {
        this.word_explain = newWord_explain;
    }

    public String getWord_target() {
        return this.word_target;
    }

    public String getWord_explain() {
        return this.word_explain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Word)) {
            return false;
        }
        Word word = (Word) o;
        return Objects.equals(word_target, word.word_target) &&
                Objects.equals(word_explain, word.word_explain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word_target, word_explain);
    }

    @Override
    public int compareTo(Word otherWord) {
        return this.word_target.compareTo(otherWord.word_target);
    }
}
