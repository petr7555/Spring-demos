package hello;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Petr Janik 485122
 * @since 05/08/2019
 */
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Integer> {

}
