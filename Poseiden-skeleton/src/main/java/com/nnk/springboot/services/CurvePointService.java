package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.interfaces.ICurvePoint;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointService implements ICurvePoint {
	
	@Autowired
	CurvePointRepository curvePointRepo;
	
	public List<CurvePoint> getAllCurvePoint(){	
		return curvePointRepo.findAll();	
	}
	
	public CurvePoint saveBid (CurvePoint curvePoint) {
		return curvePointRepo.save(curvePoint);
		
	}

	
	public CurvePoint uptadeBid(Integer id, CurvePoint curvePoint) {
		CurvePoint curvePointToUpdate =curvePointRepo.getById(id);
		curvePointToUpdate.setCurveId(id);
		curvePointToUpdate.setTerm(curvePoint.getTerm());
		curvePointToUpdate.setValue(curvePoint.getValue());
		
		return curvePointRepo.save(curvePointToUpdate);
	}
	public void deleteBid (Integer id) {
		curvePointRepo.deleteById(id);
	}

}
