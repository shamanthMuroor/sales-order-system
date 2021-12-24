package salesordersystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import salesordersystem.model.ChequeModel;

@Component
public class ChequeService {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void insertCheque(ChequeModel chequeModel) {
		this.hibernateTemplate.saveOrUpdate(chequeModel);
	}
	
	// get single cheque
//	@Transactional
//	public ChequeModel getSingleCheque(int cid) {
//		return this.hibernateTemplate.get(ChequeModel.class, cid);
//	}
//	
//	@Transactional
//	public ChequeModel getSingleCheque(String chequename) {
//		return this.hibernateTemplate.get(ChequeModel.class, chequename);
//	}
//	
//	// get all cheques
//	@Transactional
//	public List<ChequeModel> getChequeList() {
//		List<ChequeModel> chequeModels =  this.hibernateTemplate.loadAll(ChequeModel.class);
//		return chequeModels;
//	}
}
