package su.dmz.fleetmsv2.parameters.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.dmz.fleetmsv2.parameters.models.State;
import su.dmz.fleetmsv2.parameters.repositories.StateRepository;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> findAll() {
        return stateRepository.findAll();
    }

    public void save(State state) {
        stateRepository.save(state);
    }

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }

    public State findById(Integer id) {
        return stateRepository.findById(id).orElse(null);
    }

}
