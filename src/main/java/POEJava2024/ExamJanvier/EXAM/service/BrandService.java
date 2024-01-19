package POEJava2024.ExamJanvier.EXAM.service;

import POEJava2024.ExamJanvier.EXAM.DTO.BrandDTO;
import POEJava2024.ExamJanvier.EXAM.Slugger;
import POEJava2024.ExamJanvier.EXAM.entity.Brand;
import POEJava2024.ExamJanvier.EXAM.exception.NotFoundCentralishException;
import POEJava2024.ExamJanvier.EXAM.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService {

    private BrandRepository brandRepository;
    private Slugger slugger;

    public List<Brand> findAll(){
        return brandRepository.findAll();
    }

    public Brand show(Long id){
        Optional<Brand> bOptional = brandRepository.findById(id);
        if (bOptional.isPresent()) {
            return bOptional.get();
        }
        throw new NotFoundCentralishException("Brand", "id", id);
    }

    public Brand persist(BrandDTO brandDTO, Long id){
        if (id !=null && brandRepository.findById(id).isEmpty()){
            throw new NotFoundCentralishException(
                    "Brand", "id", id
            );
        }

        Brand b = new Brand();
        b.setId(id);
        b.setName(brandDTO.getName());

        return brandRepository.saveAndFlush(b);

    }
}
