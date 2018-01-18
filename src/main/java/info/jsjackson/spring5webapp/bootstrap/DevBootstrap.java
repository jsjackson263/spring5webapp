/**
 * 
 */
package info.jsjackson.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import info.jsjackson.spring5webapp.model.Author;
import info.jsjackson.spring5webapp.model.Book;
import info.jsjackson.spring5webapp.repositories.AuthorRepository;
import info.jsjackson.spring5webapp.repositories.BookRepository;

/**
 * @author josan
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}
	
	private void initData() {
		Author eric = new Author("Eric", "Evans");
		/*Book ddd = new Book(title: "Domain Drvien Design", isbn: "1234", publisher: "Harper Collins");*/
		Book ddd = new Book("Domain Drvien Design", "1234", "Harper Collins");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}
	
}
