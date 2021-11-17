import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    //Predicate<Resume> condition = b->b!=null;
    Predicate<Resume> condition = Objects::nonNull;

    Resume[] storage = new Resume[10000];

    void clear() {
        Resume[] storage2 = Arrays.stream(storage).filter(condition).toArray(Resume[]::new);
        Arrays.fill(storage, 0, storage2.length + 1, null);
    }

    void save(Resume r) {

        Resume[] storage2 = Arrays.stream(storage).filter(condition).toArray(Resume[]::new);
        storage[storage2.length] = r;
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
        for (Resume r : storage) {
            if (uuid.equals(r.uuid)) {
    int index = Arrays.asList(storage).indexOf(r);
    storage[index] = null;
    for (int i = index + 1; i < storage.length; i++) {// really moves null behind String objects
        storage[i - 1] = storage[i];
        storage[i] = null;
         }
       }
     }
   }



    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
            return Arrays.stream(storage).filter(condition).toArray(Resume[]::new);
    }

    int size() {
        Resume[] storage2 = Arrays.stream(storage).filter(condition).toArray(Resume[]::new);
        return storage2.length;
    }
}
