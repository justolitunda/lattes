package ke.ac.egerton.quality.service;

import ke.ac.egerton.quality.Repository.ProgrammesRepository;
import ke.ac.egerton.quality.model.Programmes;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public abstract   class ProgrammeServiceImpl implements ProgrammesService {

    @Autowired
    private ProgrammesRepository repository;

    public ProgrammesRepository getRepository() {
        return repository;
    }

    public void setRepository(ProgrammesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Programmes saveProgrammes(Programmes programmes){
        return  repository.save(programmes);
    }
    @Override
    public Programmes updateProgrammes(Programmes programmes){
        return repository.save(programmes);
    }
    @Override
    public void deleteProgrammes(Programmes programmes){
        repository.delete(programmes);
    }
@Override
    public Programmes getProgrammesById(int id) {
        return repository.findById(id);
    }

    public List<Programmes> getAllProgrammes(){
        return  repository.findAll();
    }
}




