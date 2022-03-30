package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.DTOs.CurvePointDTO;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.interfaces.ICurvePointService;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.util.CurvePointMapper;

import customExceptions.CustomIdNotFoundException;

@Service
public class CurvePointService implements ICurvePointService {
	
	@Autowired
	CurvePointMapper cMapper;
	
	@Autowired
	CurvePointRepository curvePointRepo;
	
	@Override
	public List<CurvePoint> getAllCurvePoint(){	
		return curvePointRepo.findAll();	
	}
	@Override
	public CurvePoint saveCurvePoint (CurvePointDTO curvePointDto) {
		CurvePoint curvePoint = new CurvePoint();
		cMapper.updateCurvePointByCurvePointDto(curvePointDto, curvePoint);
		return curvePointRepo.save(curvePoint);	
	}

	@Override
	public CurvePoint updateCurvePoint(Integer id, CurvePointDTO curvePointDTO) {
		CurvePoint curvePointToUpdate =curvePointRepo.getById(id);
		cMapper.updateCurvePointByCurvePointDto(curvePointDTO, curvePointToUpdate);
		return curvePointRepo.save(curvePointToUpdate);
	}
	@Override
	public void deleteCurvePoint (Integer id) {
		curvePointRepo.deleteById(id);
	}
	@Override
	public CurvePoint getCurvePointById (Integer id) throws CustomIdNotFoundException {
		Optional<CurvePoint>optional = curvePointRepo.findById(id);
		if (optional.isEmpty()) {
			throw new CustomIdNotFoundException("curvePoint with id :"+id+" not found!");
		}
		return optional.get();
		
	}

}
