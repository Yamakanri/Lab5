package utility;

import model.StudyGroup;

import java.util.Comparator;

/**
 * Sorter for realisation reorder command
 */
public class IdSort implements Comparator<StudyGroup> {

    @Override
    public int compare(StudyGroup o1, StudyGroup o2) {

        if (o1.getId() < o2.getId()) {
            return 1;
        } else if (o1.getId() == o2.getId()) {
            return 0;
        } else {
            return -1;
        }
    }
}
