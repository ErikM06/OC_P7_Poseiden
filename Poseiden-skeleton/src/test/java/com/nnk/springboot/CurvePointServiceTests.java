package com.nnk.springboot;

import com.nnk.springboot.DTOs.CurvePointDTO;
import com.nnk.springboot.domain.CurvePoint;

import com.nnk.springboot.repositories.CurvePointRepository;

import com.nnk.springboot.services.CurvePointService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")

public class CurvePointServiceTests {

	Logger logger = LoggerFactory.getLogger(CurvePointServiceTests.class);

	@Autowired
	private CurvePointRepository curvePointRepository;

	@Autowired
	private CurvePointService curvePointService;

	@Mock
	private CurvePoint curvePoint;

	@Mock
	private CurvePointDTO curvePointDto;

	@BeforeEach
	public void setUp() {
		curvePoint = new CurvePoint(1, 20.0, 20.0);
		curvePointRepository.save(curvePoint);
		curvePointDto = new CurvePointDTO(2, 30.0, 40.0);
	}

	@AfterEach()
	public void tearDown() {
		curvePoint = null;
		curvePointDto = null;
		curvePointRepository.deleteAll();
	}

	@Test
	public void saveCurvePointTest() {
		CurvePoint curvePointToSave = curvePointService.saveCurvePoint(curvePointDto);
		assertNotNull(curvePointToSave);
		assertEquals(curvePointToSave.getValue(), curvePointDto.getValue());
	}

	@Test
	public void findAllCurvePointTest() {
		List<CurvePoint> curveList = curvePointService.getAllCurvePoint();
		assertNotNull(curveList);
		assertThat(curveList.contains(curvePoint));
	}

	@Test
	@Transactional
	public void updateCurvePointTest() {
		curvePointService.updateCurvePoint(curvePoint.getId(), curvePointDto);
		CurvePoint retrivedModifiedCurve = curvePointRepository.getById(curvePoint.getId());
		assertThat(curvePointDto.getValue().equals(retrivedModifiedCurve.getValue()));
	}

	@Test
	public void deleteCurvePointTest() throws Exception {
		curvePointService.deleteCurvePoint(curvePoint.getId());
		assertFalse(curvePointRepository.existsById(curvePoint.getId()));

	}

}
