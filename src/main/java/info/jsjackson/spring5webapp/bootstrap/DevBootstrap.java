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
import info.jsjackson.spring5webapp.model.Publisher;
import info.jsjackson.spring5webapp.repositories.AuthorRepository;
import info.jsjackson.spring5webapp.repositories.BookRepository;
import info.jsjackson.spring5webapp.repositories.PublisherRepository;

/**
 * @author josan
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}
	
	private void initData() {
		Author eric = new Author("Eric", "Evans");
		/*Book ddd = new Book(title: "Domain Drvien Design", isbn: "1234", publisher: "Harper Collins");*/
		Publisher dddPublisher = new Publisher("Harper Collins", "32 Baines Avenue");
		publisherRepository.save(dddPublisher);;
		
		Book ddd = new Book("Domain Drvien Design", "1234", dddPublisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Publisher noEJBPublisher = new Publisher("Worx", "256 Broadway");
		publisherRepository.save(noEJBPublisher);
		
		Book noEJB = new Book("J2EE Development without EJB", "23444", noEJBPublisher);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}
	
}
