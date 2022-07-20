package ma.ensah.sprint1.dao;

import ma.ensah.sprint1.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {

}
