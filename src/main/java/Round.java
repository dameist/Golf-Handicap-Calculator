import java.time.LocalDate;
import java.util.Date;

public class Round {
    private Course course;
    private double par;
    private int front_9Strokes;
    private int back_9Strokes;
    private double handiDifferential;
    private LocalDate datePlayed;
;
    public Round(Course course, int front_9Strokes, int back_9Strokes, LocalDate datePlayed) {
        this.course = course;
        this.front_9Strokes = front_9Strokes;
        this.back_9Strokes = back_9Strokes;
        this.datePlayed = datePlayed;
        par = back_9Strokes + front_9Strokes - course.getTotal();
        handiDifferential =  par * 113 / course.getSlopeRating();
    }

    public Course getCourse() {
        return course;
    }

    public double getPar() {
        return par;
    }

    public int getFront_9Strokes() {
        return front_9Strokes;
    }

    public int getBack_9Strokes() {
        return back_9Strokes;
    }

    public double getHandiDifferential() {
        return handiDifferential;
    }
    public LocalDate getDatePlayed(){
        return datePlayed;
    }

    @Override
    public String toString(){
        return "You had a par " + par + " when you played at " + course.getName() + " on " + getDatePlayed() +"\n";
    }
}
