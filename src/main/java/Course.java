public class Course {
    private String name;
    private int total;
    private int slopeRating;
    private int front_9Par;
    private int back_9Par;


    public Course(String name, int front_9Par, int back_9Par, int slopeRating) {
        this.name = name;
        this.slopeRating = slopeRating;
        this.front_9Par = front_9Par;
        this.back_9Par = back_9Par;
        total = front_9Par + back_9Par;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public int getFront_9Par() {
        return front_9Par;
    }

    public int getBack_9Par() {
        return back_9Par;
    }

    public int getSlopeRating() {
        return slopeRating;
    }
}
