import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static AtomicInteger size = new AtomicInteger();
    Resume[] storage = new Resume[10000];
   // Resume r = new Resume();


    void clear() {
        Arrays.fill(storage, 0, size() + 1, null);
        size.set(0);
    }


    void save(Resume r) {
        storage[size()] = r;
        size.getAndIncrement();
    }


    Resume get(String uuid) {
        //   return  Arrays.stream(storage).filter(r-> r.uuid.equals(uuid)).findAny().orElse(null);
        for (Resume r : storage) {
            if (r != null) {
                if (uuid.equals(r.uuid)) {
                    int index = Arrays.asList(storage).indexOf(r);
                    return storage[index];
                }
            }
        }
        return null;
    }


    void delete(String uuid) {
        Resume[] storage2 = Arrays.stream(storage).limit(size()).toArray(Resume[]::new);
        for (Resume r : storage2) {
            if (uuid.equals(r.uuid)) {
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
        return Arrays.stream(storage).limit(size()).toArray(Resume[]::new);
    }


    int size() {
        return size.get();
    }
}
