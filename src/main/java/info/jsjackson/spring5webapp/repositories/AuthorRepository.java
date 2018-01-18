/**
 * 
 */
package info.jsjackson.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import info.jsjackson.spring5webapp.model.Author;

/**
 * @author josan
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
