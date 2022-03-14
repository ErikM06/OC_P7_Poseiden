package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.DTOs.CurvePointDTO;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.interfaces.ICurvePointService;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.util.CurvePointMapper;

@Service
public class CurvePointService implements ICurvePointService, CurvePointMapper {
	
	@Autowired
	CurvePointRepository curvePointRepo;
	
	public List<CurvePoint> getAllCurvePoint(){	
		return curvePointRepo.findAll();	
	}
	
	public CurvePoint saveBid (CurvePoint curvePoint) {
		return curvePointRepo.save(curvePoint);
		
	}

	
	public CurvePoint updateCurvePoint(Integer id, CurvePointDTO curvePointDTO) {
		CurvePoint curvePointToUpdate =curvePointRepo.getById(id);
		updateCurvePointByCurvePointDto(curvePointDTO, curvePointToUpdate);
		return curvePointRepo.save(curvePointToUpdate);
	}
	
	public void deleteBid (Integer id) {
		curvePointRepo.deleteById(id);
	}

	@Override
	public void updateCurvePointByCurvePointDto(CurvePointDTO curvePointDTO, CurvePoint curvePoint) {
		// TODO Auto-generated method stub
		
	}

}
