package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Person[] PEOPLE = {new Person(1, "Boris"), new Person(2, "Peter"), new Person(3, "Miroslav")};
    private static final int MORE_THAN_16_ELEMENTS = 17;
    private static final int LESS_THAN_1_ELEMENT = 0;
    private static final Person NEW_PERSON_FOR_ADDING = new Person(4, "Desi");
    private static final Person LAST_PERSON = new Person(2, "Peter");
    private static final String NAME_OF_THE_PERSON = "Peter";
    private static final int ID_OF_THE_PERSON = 2;

    private Database database;

    @Before
    public void prepareDataBase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorHasCreateValidObject() {
        Person[] elements = database.getElements();
        Assert.assertArrayEquals(elements, PEOPLE);

        Assert.assertEquals(elements.length, PEOPLE.length);
        for (int i = 0; i < elements.length; i++) {
            Assert.assertEquals(elements[i], PEOPLE[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[MORE_THAN_16_ELEMENTS];
        database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[LESS_THAN_1_ELEMENT];
        database = new Database(people);
    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        database.add(NEW_PERSON_FOR_ADDING);
        Person[] people = database.getElements();
        Assert.assertEquals(people.length, PEOPLE.length + 1);
        Assert.assertEquals(people[people.length - 1], NEW_PERSON_FOR_ADDING);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowNewParam() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {

        database.remove();
        Person[] people = database.getElements();
        Assert.assertEquals(people.length, PEOPLE.length - 1);
        Assert.assertEquals(people[people.length - 1].getUsername(), LAST_PERSON.getUsername());
        Assert.assertEquals(people[people.length - 1].getId(), LAST_PERSON.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowEmptyDataBase() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }

        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUserNameThrowExceptionNullParam() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test()
    public void testFindByUserName() throws OperationNotSupportedException {
        Person person = database.findByUsername(NAME_OF_THE_PERSON);
        Assert.assertEquals(ID_OF_THE_PERSON, person.getId());
        Assert.assertEquals(NAME_OF_THE_PERSON, person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowEmptyDatabase() throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername(NAME_OF_THE_PERSON);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameMoreThanOnePerson() throws OperationNotSupportedException {
        database.add(new Person(4, "Miroslav"));
        database.findByUsername("Miroslav");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameInvalidName() throws OperationNotSupportedException {
        database.findByUsername("Pesho");
    }

    @Test
    public void testGetById() throws OperationNotSupportedException {
        Person person = database.findById(ID_OF_THE_PERSON);
        Assert.assertEquals(person.getId(), ID_OF_THE_PERSON);
        Assert.assertEquals(person.getUsername(), NAME_OF_THE_PERSON);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdMoreThanOneId() throws OperationNotSupportedException {
        database.add(new Person(ID_OF_THE_PERSON, NAME_OF_THE_PERSON));
        database.findById(ID_OF_THE_PERSON);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdEmptyData() throws OperationNotSupportedException {
        database = new Database();
        database.findById(ID_OF_THE_PERSON);
    }
}