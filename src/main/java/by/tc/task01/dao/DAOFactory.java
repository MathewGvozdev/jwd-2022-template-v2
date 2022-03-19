package by.tc.task01.dao;

import by.tc.task01.dao.impl.ApplianceDAOImpl;

public final class DAOFactory {
	private static final DAOFactory INSTANCE = new DAOFactory();

	private final ApplianceDAO applianceDAO = ApplianceDAOImpl.getInstance();
	
	private DAOFactory() {}

	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	public static DAOFactory getInstance() {
		return INSTANCE;
	}
}
