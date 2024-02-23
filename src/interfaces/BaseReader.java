package interfaces;

import model.StudyGroup;

import java.io.IOException;


/**
 * Contains method for reading file
 * Read and loads data from file
 */
public interface BaseReader {
    StudyGroup[] read(String path) throws IOException;
}

