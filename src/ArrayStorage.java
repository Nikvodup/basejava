import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private static int size;
    Resume[] storage = new Resume[10000];


    void clear() {
        Arrays.fill(storage, 0, size + 1, null);
        size = 0;
    }


    void save(Resume r) {
        if (r == null) {

        } else {
            storage[size] = r;
            size++;
        }

    }


    Resume get(String uuid) {
        return Arrays.stream(storage).limit(size).filter(r -> r.uuid.equals(uuid)).findAny().orElse(null);
    }


    void delete(String uuid) {
        Resume resumeToBeDeleted = Arrays.stream(storage).limit(size).filter(r -> r.uuid.equals(uuid)).findAny().orElse(null);

        Resume[] storage2;

        for (int i = 0; i < storage.length - 1 ; i++) {
            if (storage[i] == resumeToBeDeleted) {
                storage2 = new Resume[storage.length - 1];
                for (int index = 0; index < i; index++) {
                    storage2[index] = storage[index];
                }
                for (int j = i; j < storage.length - 1; j++) {
                    storage2[j] = storage[j + 1];
                }
                storage = storage2;
                break;
            }
        }

        size--;
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.stream(storage).limit(size).toArray(Resume[]::new);
    }


    int size() {
        return size;
    }
}
