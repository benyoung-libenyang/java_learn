import java.lang.constant.Constable;

public class testYield {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public Constable calculate(Day d) {
        return switch (d) {
            case SATURDAY, SUNDAY -> "week-end";
            default -> {
                int remainingWorkDays = 5 - d.ordinal();
                yield remainingWorkDays;
            }
        };
    }

}
