package P02ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTests {
    private Database database;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person addingPersonWithSameId;

    private static final String NON_EXISTING_PERSON_NAME = "c";
    private static final String EXISTING_PERSON_NAME = "C";

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.person1 = new Person(1, "A");
        this.person2 = new Person(2, "B");
        this.person3 = new Person(3, "C");
        this.database = new Database(this.person1, this.person2, person3);
        this.addingPersonWithSameId = new Person(1, "C");
    }

    // 1. Test constructor:
    @Test
    public void testConstructor() {
        Person[] expectedPeople = {this.person1, this.person2, this.person3};
        Person[] actualPeople = this.database.getElements();
        Assert.assertArrayEquals(expectedPeople, actualPeople);
    }

    // 2. Test add method:
    @Test(expected = OperationNotSupportedException.class)
    public void testAddingPersonWithIdThatAnotherPersonHasShouldThrowExc() throws OperationNotSupportedException {
        int addingPersonId = this.addingPersonWithSameId.getId();
        Person[] peopleInDatabase = this.database.getElements();

        for (Person person : peopleInDatabase) {
            if (person.getId() == addingPersonId) {
                throw new OperationNotSupportedException();
            }
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddingNullShouldThrowExc() throws OperationNotSupportedException {
        this.database.add(null);
    }

    // 3. Test remove method:

    // 3.1:
    @Test
    public void testRemovePersonAtTheLastIndexUntilOnlyOnePersonLasts() throws OperationNotSupportedException {
        int peopleLength = this.database.getElements().length;
        int peopleExpectedLength = peopleLength;
        for (int i = 0; i < peopleLength - 1; i++) {
            Person previousLastBeforeRemoving = this.database.getElements()[peopleExpectedLength - 2];
            this.database.remove();
            peopleExpectedLength--;
            // 3.1.1 Test the removing of the last person by comparing the previous last person
            // before removing and the last person after removing:
            Person lastPersonAfterRemoving = this.database.getElements()[peopleExpectedLength - 1];
            Assert.assertEquals(previousLastBeforeRemoving, lastPersonAfterRemoving);

            // 3.1.2. Test if the length of the array decreases after deleting:
            int actualLength = this.database.getElements().length;
            Assert.assertEquals(peopleExpectedLength, actualLength);
        }
    }

    // 3.2.
    @Test
    public void testRemoveTheLastPerson() throws OperationNotSupportedException {
        this.testRemovePersonAtTheLastIndexUntilOnlyOnePersonLasts();

        this.database.remove();
        Assert.assertEquals(0, this.database.getElements().length);
    }

    // 3.3.
    @Test(expected = OperationNotSupportedException.class)
    public void testRemovingTheEmptyDatabaseShouldThrowExc() throws OperationNotSupportedException {
        this.testRemoveTheLastPerson();
        this.database.remove();
    }

    // 4. Test findByUsername method:
    // 4.1.
    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByNonExistingtUserNameCaseSensitiveShouldThrow() throws OperationNotSupportedException {
        this.database.findByUsername(NON_EXISTING_PERSON_NAME);
    }

    // 4.2.
    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonWithNullUsernameShouldThrow() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    // 4.3.
    @Test
    public void testFindPersonWithExistingUsername() throws OperationNotSupportedException {
        Person searchedPerson = this.database.findByUsername(EXISTING_PERSON_NAME);
        Assert.assertEquals(searchedPerson, this.person3);
    }

    // 4.4.
    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByNonExistingId() throws OperationNotSupportedException {
        this.database.findById(0);
    }
}
