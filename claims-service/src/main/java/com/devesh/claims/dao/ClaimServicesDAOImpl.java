package com.devesh.claims.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devesh.claims.model.Summary;

@Component
public class ClaimServicesDAOImpl implements ClaimServicesDAO {

	@Autowired
	EntityManager em;
	
	/*@Autowired
	SessionFactory sessionFactory;*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Summary> getSummaryDetails() {
		//SessionFactory sessionFactory = em.unwrap(SessionFactory.class);
		//Session session = em.unwrap(Session.class);
		//Criteria criteria = sessionFactory.openSession().createCriteria(Summary.class);
		
		
		Session session = em.unwrap(Session.class);
		
		SessionFactory sessionFactory = session.getSessionFactory();
		
		Criteria criteria = sessionFactory.openSession().createCriteria(Summary.class);
		criteria.add(Restrictions.eq("memberId", 1690056));
		criteria.add(Restrictions.eq("subscriberId", 1690056));
		
		Conjunction conjunction1= Restrictions.conjunction();
		conjunction1.add(Restrictions.eq("accumId", "IN OPX"));
		conjunction1.add(Restrictions.eq("startDate", Date.valueOf("2018-03-10")));
		conjunction1.add(Restrictions.eq("endDate", Date.valueOf("2018-09-04")));
		
		Conjunction conjunction2= Restrictions.conjunction();
		conjunction2.add(Restrictions.eq("accumId", "IN OPX - COC"));
		conjunction2.add(Restrictions.eq("startDate", Date.valueOf("2017-01-01")));
		conjunction2.add(Restrictions.eq("endDate", Date.valueOf("2017-12-31")));
		
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(conjunction1);
		disjunction.add(conjunction2);
		
		criteria.add(disjunction);

		return criteria.list();
	}

}
