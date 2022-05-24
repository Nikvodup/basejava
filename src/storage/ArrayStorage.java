package storage;

import model.Resume;
import storage.ArrayStorage;

import java.util.Arrays;

public class ArrayStorage {
    private static int size;
    Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("model.Resume " + r.getUuid() + " does not exist");
        } else {
            storage[index] = r;
        }
    }



    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("model.Resume " + r.getUuid() + " already exists");
        } else if (size >= storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
      //  return Arrays.stream(storage).limit(size).filter(r -> r.uuid.equals(uuid)).findAny().orElse(null);
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("model.Resume " + uuid + " does not exist");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
    /*    for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = null;
                    size--;
                    for (int j = i+1; j <size+1; j++) {
                        storage[j - 1] = storage[j];
                    }
                }

                if (uuid.equals(storage[i].getUuid())){
                   storage[i] = storage[size - 1];
                   storage[size - 1] = null;
                   size--;
                } else {
                    System.out.println("model.Resume does not exist.");
                }
            } */

        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("model.Resume " + uuid + " does not exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }

        }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }


    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }


   public int size() {
        return size;
    }
}
