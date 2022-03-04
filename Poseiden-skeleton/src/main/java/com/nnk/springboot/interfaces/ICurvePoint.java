package com.nnk.springboot.interfaces;

import java.util.List;

import com.nnk.springboot.domain.CurvePoint;

public interface ICurvePoint {
	
	public List<CurvePoint> getAllCurvePoint();
	
	public CurvePoint saveBid (CurvePoint curvePoint);
	
	public CurvePoint uptadeBid(Integer id, CurvePoint curvePoint);
	
	public void deleteBid (Integer id);

}
