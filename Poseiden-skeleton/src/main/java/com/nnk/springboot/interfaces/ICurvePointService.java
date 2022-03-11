package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.DTOs.CurvePointDto;
import com.nnk.springboot.domain.CurvePoint;

public interface ICurvePointService {
	
	public List<CurvePoint> getAllCurvePoint();
	
	public CurvePoint saveBid (CurvePoint curvePoint);
	
	public CurvePoint updateCurvePoint(Integer id, CurvePointDto curvePointDto);
	
	public void deleteBid (Integer id);

}
