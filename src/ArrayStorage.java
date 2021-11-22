import java.util.Arrays;
import java.util.Objects;


public class ArrayStorage {

    private static int size;
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        return Arrays.stream(storage).limit(size).filter(r -> r.uuid.equals(uuid)).findAny().orElse(null);
    }

    void delete(String uuid) {
        Resume resumeToBeDeleted = Arrays.stream(storage).limit(size).filter(r -> r.uuid.equals(uuid)).findAny().orElse(null);
        Resume[] storage2;
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] == resumeToBeDeleted) {
                storage2 = new Resume[storage.length - 1];
                System.arraycopy(storage, 0, storage2, 0, i);
                if (storage.length - 1 - i >= 0) System.arraycopy(storage, i + 1, storage2, i, size - 1 - i);
                storage = storage2;
                size--;
                break;
            }  else if(uuid==null) {return;}
         }
     }



    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
