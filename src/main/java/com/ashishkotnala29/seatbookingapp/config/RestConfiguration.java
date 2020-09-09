package com.ashishkotnala29.seatbookingapp.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.ashishkotnala29.seatbookingapp.model.entity.Booking;
import com.ashishkotnala29.seatbookingapp.model.entity.Building;
import com.ashishkotnala29.seatbookingapp.model.entity.Employee;
import com.ashishkotnala29.seatbookingapp.model.entity.Floor;
import com.ashishkotnala29.seatbookingapp.model.entity.Room;
import com.ashishkotnala29.seatbookingapp.model.entity.Row;
import com.ashishkotnala29.seatbookingapp.model.entity.Seat;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

	private final EntityManager entityManager;

	@Autowired
	public RestConfiguration(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		HttpMethod[] unsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

		// disabling HTTP methods for the entities below: POST, PUT, DELETE
		/*
		config.getExposureConfiguration().forDomainType(Booking.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

		config.getExposureConfiguration().forDomainType(Building.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

		config.getExposureConfiguration().forDomainType(Employee.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

		config.getExposureConfiguration().forDomainType(Floor.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

		config.getExposureConfiguration().forDomainType(Row.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

		config.getExposureConfiguration().forDomainType(Room.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

		config.getExposureConfiguration().forDomainType(Seat.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
		*/
		//config.setDefaultMediaType(MediaType.APPLICATION_JSON);
        //config.useHalAsDefaultJsonMediaType(false);

		// calling an internal helper method
		exposeIds(config);

	}

	// exposing entity ids
	private void exposeIds(RepositoryRestConfiguration config) {

		// getting a list of all entity classes from the entity manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

		// creating an array of the entity types
		List<Class> entityClasses = new ArrayList<>();

		// getting the entity types for the entities
		for (EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}

		// exposing the entity ids for the array of entity/domain types
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);

	}

}
