package com.mindtree.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
private static	EntityManagerFactory emf;
	public static EntityManagerFactory getEntityManagerFactory()
	{
		emf= Persistence.createEntityManagerFactory("myPersistenceUnit");
		return emf;
	}

}
