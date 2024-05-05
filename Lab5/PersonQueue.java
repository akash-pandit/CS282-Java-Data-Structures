public class PersonQueue {
    private int size = 0;
    private Person[] queue = new Person[size];

    PersonQueue() {}

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
        for (int i = 1; i < size; i++) {
            outQueue[i-1] = queue[i];
        }
        Person person = queue[0];
        queue = outQueue;
        size--;
        return person;
    }

    public Person view() {
        return queue[0];
    }

    public int getLength() {
        return queue.length;
    }

    // public String toString() {
    //     String output = "[";

    //     for (int i = 0; i < queue.length - 1; i++) {
    //         output += queue[i] + ", ";
    //     }
    //     output += queue[queue.length-1] + "]";

    //     return output;
    // }
}

// 