package storage;

import org.junit.Assert;
import org.junit.Test;
import exception.StorageException;
import model.Resume;


public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
   protected Storage storage;
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }
}
