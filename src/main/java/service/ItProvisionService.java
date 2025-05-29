package service;

import data.model.ItProvision;
import data.repository.ItProvisionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import web.model.ItProvisionResponse;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ItProvisionService {
    private final ItProvisionRepository itProvisionRepository;

    public ItProvisionService(ItProvisionRepository itProvisionRepository) {
        this.itProvisionRepository = itProvisionRepository;
    }

    public List<ItProvisionResponse> getAllItProvisions() {
        List<ItProvisionResponse> itProvisionResponses = new ArrayList<>();
        List<ItProvision> itProvisions = itProvisionRepository.findAll().list();

        for (ItProvision itProvision : itProvisions) {
            ItProvisionResponse itProvisionResponse = getItProvision(itProvision);
            itProvisionResponses.add(itProvisionResponse);
        }
        return itProvisionResponses;
    }

    public ItProvisionResponse getItProvision(ItProvision itProvision) {
        return new ItProvisionResponse(
                itProvision.getId(),
                itProvision.getTipologia(),
                itProvision.getMarca(),
                itProvision.getSeriale(),
                itProvision.getMotivazione()
        );
    }
}
