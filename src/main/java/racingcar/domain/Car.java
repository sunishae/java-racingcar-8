package racingcar.domain;

public class Car {

    private static final int MOVING_CONDITION = 4;
    private static final int MOVING_SIZE = 1;
    private static final int INITIAL_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVING_CONDITION) {
            this.position += MOVING_SIZE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
