package T01WorkingWithAbstraction.Lab.P04HotelReservation;

public enum Season {
    Spring(2),
    Summer(4),
    Autumn(1),
    Winter(3);

    private int multiplyN;

    Season(int multiplyN) {
        this.multiplyN = multiplyN;
    }

    public int getMultiplyN() {
        return this.multiplyN;
    }
}
