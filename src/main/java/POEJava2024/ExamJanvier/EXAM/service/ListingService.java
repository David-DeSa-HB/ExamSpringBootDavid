package POEJava2024.ExamJanvier.EXAM.service;

import POEJava2024.ExamJanvier.EXAM.DTO.ListingDTO;
import POEJava2024.ExamJanvier.EXAM.Slugger;
import POEJava2024.ExamJanvier.EXAM.entity.Listing;
import POEJava2024.ExamJanvier.EXAM.exception.NotFoundCentralishException;
import POEJava2024.ExamJanvier.EXAM.repository.ListingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListingService {

    private ListingRepository listingRepository;
    private Slugger slugger;

    public List<Listing> findAll(){
        return listingRepository.findAll();
    }

    public Listing show(Long id){
        Optional<Listing> lOptional = listingRepository.findById(id);
        if (lOptional.isPresent()) {
            return lOptional.get();
        }
        throw new NotFoundCentralishException("Listing", "id", id);
    }

    public Listing persist(ListingDTO listingDTO, Long id){
        if (id !=null && listingRepository.findById(id).isEmpty()){
            throw new NotFoundCentralishException(
                    "Listing", "id", id
            );
        }

        Listing l = new Listing();
        l.setId(id);
        l.setTitle(listingDTO.getTitle());
        l.setModel(listingDTO.getModel());
        l.setDescription(listingDTO.getDescription());
        l.setProducedYear(listingDTO.getProducedYear());
        l.setMileage(listingDTO.getMileage());
        l.setPrice(listingDTO.getPrice());
        l.setCreatedAt(listingDTO.getCreatedAt());
        l.setImage(listingDTO.getImage());

        return listingRepository.saveAndFlush(l);

    }
}
