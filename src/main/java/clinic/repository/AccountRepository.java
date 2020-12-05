package clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import clinic.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
