package com.nt.service;

import com.nt.dao.ProductDAO;
import com.nt.dto.productDTO;
import com.nt.entity.ProductDAOimpl;
import com.nt.entity.product;

public class ProductMgmServiceImpl implements ProductMgmSerivce {
	private ProductDAO dao;

	public ProductMgmServiceImpl() {
		dao = new ProductDAOimpl();

	}

	@Override
	public productDTO fetchProduct(int pid) {
		// TODO Auto-generated method stub
		product p = null;
		productDTO dto = null;
		p = (product) dao.getproduct(pid);
		if (p != null) {
			dto = new productDTO();
			dto.setPid(p.getPid());
			dto.setPname(p.getPname());
			dto.setPrice(Math.round(p.getPrice()));
			dto.setQty(Math.round(p.getQty()));
			if (dto.getPrice() < 1000) {
				dto.setCategory("Affordable");
			} else {
				dto.setCategory("premium");

			}
			return dto;
		} else {
			return null;
		}
	}

}
