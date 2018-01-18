/**
 * 
 */
package info.jsjackson.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import info.jsjackson.spring5webapp.model.Publisher;

/**
 * @author josan
 *
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
