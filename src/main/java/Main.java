import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {

        File courseFile = new File("src/main/resources/Courses.csv");
        Scanner fileReader = new Scanner(courseFile);
        List<Course> courseList = new ArrayList<>();
        while (fileReader.hasNextLine()){
            String currentCourse = fileReader.nextLine();
            String[] courseArray = currentCourse.split(",");
            String name = courseArray[0];
            int front_9Par = Integer.parseInt(courseArray[1]);
            int back_9Par = Integer.parseInt(courseArray[2]);
            int slopeRating = Integer.parseInt(courseArray[3]);
            Course course = new Course(name, front_9Par,back_9Par,slopeRating);
            courseList.add(course);
        }

        File roundFile = new File("src/main/resources/Rounds.csv");
        fileReader = new Scanner(roundFile);
        List<Round> roundList = new ArrayList<>();
        while (fileReader.hasNextLine()) {
            String currentRound = fileReader.nextLine();
            String[] roundArray = currentRound.split(",");
            String courseName = roundArray[0];
            int front_9Strokes = Integer.parseInt(roundArray[1]);
            int back_9Strokes = Integer.parseInt(roundArray[2]);
            Date datePlayed = new SimpleDateFormat("dd/MM/yyyy").parse(roundArray[3]);
            LocalDate localDate = datePlayed.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Course playedCourse = null;
            for (Course course: courseList){
                if (course.getName().toLowerCase().equals(courseName.toLowerCase())){
                    playedCourse = course;
                }
            }
            Round round = new Round(playedCourse,front_9Strokes,back_9Strokes,localDate);
            roundList.add(round);
        }
        for (Round round: roundList){
            System.out.print(round.toString());
        }
        System.out.println("Your current handicap is : "+ String.format("%.2f", handicapCalculator(roundList)));
    }

    public static Double handicapCalculator(List<Round> roundList){
        if (roundList.size() <20) {
            return null;
        }
        else {
            Double handicap = 0.0;
            List<Double> doubleList = new ArrayList<>();
            for (Round handi : roundList.subList(roundList.size()-20, roundList.size())){
                doubleList.add(handi.getHandiDifferential());
            }
            Collections.sort(doubleList);
            for (Double handi : doubleList.subList(0,9)){
                handicap += handi;
            }

            return handicap/8;
        }
    }
}
