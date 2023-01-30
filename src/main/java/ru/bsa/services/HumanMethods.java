package ru.bsa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bsa.models.Human;
import ru.bsa.repositories.HumanRepo;
import java.util.List;

@Service
@Transactional
public class HumanMethods {
    @Autowired
    private HumanRepo humanRepo;

    public HumanMethods(HumanRepo humanRepo) {
        this.humanRepo = humanRepo;
    }
    public void save(Human human) {
        humanRepo.save(human);
    }
    public List<Human> listAll() {
        return humanRepo.findAll();
    }
    public void delete(Long id) {
        humanRepo.deleteById(id);
    }
}
