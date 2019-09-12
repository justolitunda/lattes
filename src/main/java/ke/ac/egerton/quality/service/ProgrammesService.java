package ke.ac.egerton.quality.service;

import ke.ac.egerton.quality.model.Programmes;

import java.util.List;

public interface ProgrammesService {
    Programmes saveProgrammes(Programmes programmes);

    Programmes updateProgrammes(Programmes programmes);

    void deleteProgrammes(Programmes programmes);

    Programmes getProgrammesById(int id);

    List<Programmes> getAllProgrammes();
}
