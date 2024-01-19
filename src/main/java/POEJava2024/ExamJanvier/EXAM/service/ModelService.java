package POEJava2024.ExamJanvier.EXAM.service;

import POEJava2024.ExamJanvier.EXAM.DTO.ModelDTO;
import POEJava2024.ExamJanvier.EXAM.Slugger;
import POEJava2024.ExamJanvier.EXAM.entity.Model;
import POEJava2024.ExamJanvier.EXAM.exception.NotFoundCentralishException;
import POEJava2024.ExamJanvier.EXAM.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelService {

    private ModelRepository modelRepository;
    private Slugger slugger;

    public List<Model> findAll(){
        return modelRepository.findAll();
    }

    public Model show(Long id){
        Optional<Model> mOptional = modelRepository.findById(id);
        if (mOptional.isPresent()) {
            return mOptional.get();
        }
        throw new NotFoundCentralishException("Model", "id", id);
    }

    public Model persist(ModelDTO modelDTO, Long id){
        if (id !=null && modelRepository.findById(id).isEmpty()){
            throw new NotFoundCentralishException(
                    "Model", "id", id
            );
        }

        Model m = new Model();
        m.setId(id);
        m.setName(modelDTO.getName());

        return modelRepository.saveAndFlush(m);

    }
}
