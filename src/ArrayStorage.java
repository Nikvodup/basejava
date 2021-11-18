import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static AtomicInteger size= new AtomicInteger(0);
    Resume[] storage = new Resume[10000];
    //Predicate<Resume> condition = b->b!=null;
    Predicate<Resume> condition = Objects::nonNull;


    void clear() {
        Resume[] storage2 = Arrays.stream(storage).filter(condition).toArray(Resume[]::new);//storage2 is a copy of storage but without nulls.
        Arrays.fill(storage, 0, storage2.length + 1, null);
        size.set(0) ;
    }

    void save(Resume r) {
        Resume[] storage2 = Arrays.stream(storage).filter(condition).toArray(Resume[]::new);
        storage[storage2.length] = r;
         size.getAndIncrement();
    }

    Resume get(String uuid) {
        Resume[] storage2 = Arrays.stream(storage).filter(condition).toArray(Resume[]::new);
        for (Resume r : storage2) {
            if (r.uuid.equals(uuid))
                return r;
        }
        return null;
    }

    void delete(String uuid) {
        Resume[] storage2 = Arrays.stream(storage).filter(condition).toArray(Resume[]::new);
        for (Resume r : storage2) {
            if (uuid.equals(r.toString())) {
                int index = Arrays.asList(storage2).indexOf(r);
                storage[index] = null;
                for (int i = index + 1; i < storage.length; i++) {// really moves null(after deleting a resume) behind String objects
                    storage[i - 1] = storage[i];
                    storage[i] = null;
                }
            }
        }
        size.getAndDecrement();
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.stream(storage).filter(condition).toArray(Resume[]::new);
    }


    int size() {
        return size.get();
    }
}
