/**
 * 
 */
package info.jsjackson.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import info.jsjackson.spring5webapp.model.Book;

/**
 * @author josan
 *
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
