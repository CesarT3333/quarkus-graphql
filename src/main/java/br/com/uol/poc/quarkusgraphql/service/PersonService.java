package br.com.uol.poc.quarkusgraphql.service;

import br.com.uol.poc.quarkusgraphql.model.Person;
import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.bson.Document;

@ApplicationScoped
public class PersonService {

  @Inject ReactiveMongoClient mongoClient;

  public Uni<List<Person>> list() {
    return getCollection().find().map(this::createPerson).collect().asList();
  }

  private Person createPerson(Document doc) {
    return new Person(doc.getString("name"), doc.getInteger("age"));
  }

  private ReactiveMongoCollection<Document> getCollection() {
    return mongoClient.getDatabase("admin").getCollection("persons");
  }
}
