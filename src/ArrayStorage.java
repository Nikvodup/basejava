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
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = null;
                    size--;
                    for (int j = i + 1; j <storage.length-1; j++) {
                        storage[j - 1] = storage[j];
                    }
                }
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
