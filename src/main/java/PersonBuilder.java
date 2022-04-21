public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;
    protected boolean hasAge = false;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = age;
            hasAge = true;
        } else {
            throw new IllegalArgumentException("Возраст не может быть меньше нуля");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {

        if (name == null) {
            throw new IllegalStateException("У человека должно быть имя");
        } else if (surname == null) {
            throw new IllegalStateException("У человека должна быть фамилия");
        }

        Person person;
        if (hasAge) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        if (address != null) {
            person.setAddress(address);
        }
        return person;
    }
}
