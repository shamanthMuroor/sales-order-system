package salesordersystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import salesordersystem.model.ItemModel;


@Component
public class ItemService {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void insertItem(ItemModel itemModel) {
		this.hibernateTemplate.saveOrUpdate(itemModel);
	}

	// get single item
	@Transactional
	public ItemModel getSingleItem(int itemId) {
		return this.hibernateTemplate.get(ItemModel.class, itemId);
	}
	
	// get all items
	@Transactional
	public List<ItemModel> getItemList() {
		List<ItemModel> itemModels = this.hibernateTemplate.loadAll(ItemModel.class);
		return itemModels;
	}
	
	// delete item by id
	@Transactional
	public void deleteItem(int itemId) {
		ItemModel itemModel = this.hibernateTemplate.load(ItemModel.class, itemId);
		this.hibernateTemplate.delete(itemModel);
	}
	
	
}
