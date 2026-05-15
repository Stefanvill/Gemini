package se.iths.stefan.demogooglelogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.stefan.demogooglelogin.model.QNA;

import java.util.Optional;

public interface QNARepository extends JpaRepository<QNA, Long> {
	Optional<QNA> findFirstByOrderByIdDesc();
}
