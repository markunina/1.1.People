import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;
    protected OptionalInt ages;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        ages = OptionalInt.empty();
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        ages = OptionalInt.of(age);
    }

    public boolean hasAge() {
        return ages.isPresent();
    }

    public boolean hasAddress() {
        return address == null ? false : true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return ages;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        sB.append(" " + name);
        sB.append(" " + surname);
        if (hasAge()) {
            sB.append(" (возраст: " + age);
        }
        if (hasAddress()) {
            sB.append(", адрес: " + address + ")");
        } else {
            sB.append(")");
        }
        return sB.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public boolean equals(Object obj) {
        Person o = (Person) obj;
        return name.equals(o.getName()) && surname.equals(o.getSurname());
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname);
    }
}

