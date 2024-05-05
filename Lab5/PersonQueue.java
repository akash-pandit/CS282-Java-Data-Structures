public class PersonQueue {
    private int size = 0;
    private Person[] queue = new Person[size];

    PersonQueue() {}

    PersonQueue(int size) {
        this.size = size;
    }

    PersonQueue(Person person) {
        this.size = 1;
        add(person);
    }

    PersonQueue(Person[] people) {
        this.size = people.length;
        for (int i = 0; i < size; i++) {
            add(people[i]);
        }
    }

    public void add(Person person) {
        Person[] outQueue = new Person[size + 1];

        for (int i = 0; i < size; i++) {
            outQueue[i] = queue[i];
        }
        outQueue[size] = person;
        size++;
        queue = outQueue;
    }

    public Person pop() {
        if (size == 0) {
            System.err.println("Warning");
            return null;
        }
        Person[] outQueue = new Person[size - 1];
        Person person = queue[size - 1];
        queue = outQueue;
        size--;
        return person;
    }
}