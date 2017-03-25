package petClinics;

import java.util.Iterator;

/**
 * Created by Venelin on 25.3.2017 г..
 */
public class Clinic implements Iterable<Pet> {

    private String name;
    private Pet[] pets;

    public Clinic(String name, int roomsCount) {
        this.name = name;
        this.setPets(roomsCount);
    }

    public boolean addPet(Pet pet) {
        PetAddIterator iterator = new PetAddIterator();

        while (iterator.hasNext()) {
            int index = iterator.next();
            if (pets[index] == null) {
                pets[index] = pet;
                return true;
            }
        }

        return false;
    }

    public boolean releasePet() {
        PetReleaseIterator iterator = new PetReleaseIterator();

        while (iterator.hasNext()) {
            int index = iterator.next();
            if (pets[index] != null) {
                pets[index] = null;
                return true;
            }
        }

        return false;
    }

    public boolean hasEmptyRooms() {
        for (Pet pet : this) {
            if (pet == null) {
                return true;
            }
        }
        return false;
    }

    public String print(int roomIndex) {
        roomIndex--;
        if (this.pets[roomIndex] == null) {
            return "Room empty";
        }
        return this.pets[roomIndex].toString();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Pet pet : this) {
            if (pet == null) {
                sb.append("Room empty");
            } else {
                sb.append(pet.toString());
            }
           sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    private void setPets(int roomsCount) {
        if (roomsCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.pets = new Pet[roomsCount];
    }

    @Override
    public Iterator<Pet> iterator() {
        return new PetIterator();
    }

    private final class PetIterator implements Iterator<Pet> {
        private int counter;

        public PetIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return this.counter < pets.length;
        }

        @Override
        public Pet next() {
            return pets[counter++];
        }
    }

    private final class PetAddIterator implements Iterator<Integer> {
        private int leftCounter;
        private int rightCounter;
        private boolean isMovingLeft;

        private PetAddIterator() {
            this.leftCounter = pets.length / 2 - 1;
            this.rightCounter = pets.length / 2;
            this.isMovingLeft = false;
        }

        @Override
        public boolean hasNext() {
            return this.leftCounter >= 0 || this.rightCounter < pets.length;
        }

        @Override
        public Integer next() {
            if (this.isMovingLeft) {
                this.isMovingLeft = false;
                return this.leftCounter--;
            }
            this.isMovingLeft = true;
            return this.rightCounter++;
        }
    }

    private final class PetReleaseIterator implements Iterator<Integer> {

        private int counter;
        private boolean isCounterReset;

        private PetReleaseIterator() {
            this.counter = pets.length / 2;
            this.isCounterReset = false;
        }

        @Override
        public boolean hasNext() {
            return !(this.counter == pets.length / 2 + 1 && isCounterReset);
        }

        @Override
        public Integer next() {
            if (this.counter >= pets.length) {
                this.isCounterReset = true;
                this.counter = 0;
            }
            return counter++;
        }
    }

}
