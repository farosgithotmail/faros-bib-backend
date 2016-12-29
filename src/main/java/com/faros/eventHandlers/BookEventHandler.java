package com.faros.eventHandlers;

import com.faros.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by juchtdi on 29/12/2016.
 */
@Component
@RepositoryEventHandler(Book.class)
public class BookEventHandler {

    private final SimpMessagingTemplate template;

    private final EntityLinks entityLinks;

    @Autowired
    public BookEventHandler(SimpMessagingTemplate template, EntityLinks entityLinks) {
        this.template = template;
        this.entityLinks = entityLinks;
    }

    @HandleAfterDelete
    public void doAfterDelete(Book book){
        this.template.convertAndSend("/topic/booksDeleted", getPath(book));
    }

    @HandleAfterCreate
    public void doAfterCreate(Book book){
        this.template.convertAndSend("/topic/booksCreated", getPath(book));
    }

    private String getPath(Book book) {
        return this.entityLinks.linkForSingleResource(book.getClass(),
                book.getId()).toUri().getPath();
    }
}
