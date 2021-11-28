import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume>
{

    // Unique identifier
    String uuid ;

    @Override
    public String toString() {
        return uuid;
    }




    @Override
    public int compareTo(Resume r) {
         int id = this.uuid.compareTo(r.uuid);
         return id;
    }


    /*
    @Override
    public int compare(Resume o1, Resume o2) {
        return 0;
    }

    @Override
    public Comparator<Resume> reversed() {
        return null;
    }

    @Override
    public Comparator<Resume> thenComparing(Comparator<? super Resume> other) {
        return null;
    }

    @Override
    public <U> Comparator<Resume> thenComparing(Function<? super Resume, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Resume> thenComparing(Function<? super Resume, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Resume> thenComparingInt(ToIntFunction<? super Resume> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Resume> thenComparingLong(ToLongFunction<? super Resume> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Resume> thenComparingDouble(ToDoubleFunction<? super Resume> keyExtractor) {
        return null;
    }

    */
}
