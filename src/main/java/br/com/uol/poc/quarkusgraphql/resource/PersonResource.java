package br.com.uol.poc.quarkusgraphql.resource;

import br.com.uol.poc.quarkusgraphql.model.Person;
import br.com.uol.poc.quarkusgraphql.service.PersonService;
import io.smallrye.mutiny.Uni;
import java.util.List;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class PersonResource {

  private final PersonService personService;

  public PersonResource(PersonService personService) {
    this.personService = personService;
  }

  @Query("allPersons")
  @Description("Get all persons")
  public Uni<List<Person>> getAllFilms() {
    return personService.list();
  }
}
