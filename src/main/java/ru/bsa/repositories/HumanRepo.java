package ru.bsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bsa.models.Human;
@Repository
public interface HumanRepo extends JpaRepository <Human, Long>{
}
