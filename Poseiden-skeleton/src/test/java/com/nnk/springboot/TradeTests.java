package com.nnk.springboot;

import com.nnk.springboot.DTOs.TradeDTO;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.TradeService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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
public class TradeTests {

	@Autowired
	private TradeRepository tradeRepository;
	
	@Autowired
	private TradeService tradeService;
	
	@Mock
	Trade trade;
	
	@Mock
	TradeDTO tradeDTO;
	
	@BeforeEach
	private void setUp() {
		trade = new Trade("Account test","Type test");
		tradeRepository.save(trade);
		tradeDTO = new TradeDTO("TradeDto account test","TradeDto Type test", 20.0);
	}
	
	@AfterEach
	private void tearDown() {
		trade = null;
		tradeDTO = null;
		tradeRepository.deleteAll();
	}
	@Test
	public void saveTradeTest() {
		Trade tradeToSave = tradeService.saveTrade(tradeDTO);
		assertNotNull(tradeToSave);
		assertEquals(tradeToSave.getAccount(), tradeDTO.getAccount());
	}

	@Test
	public void findAllTradeTest() {
		List<Trade> tradeLs = tradeService.getAllTrade();
		assertNotNull(tradeLs);
		assertThat(tradeLs.contains(trade));
	}

	@Test
	@Transactional
	public void updateTradeTest() {
		tradeService.updateTrade(trade.getTradeId(), tradeDTO);
		Trade retrivedModifiedTrade = tradeRepository.getById(trade.getTradeId());
		assertThat(tradeDTO.getAccount().equals(retrivedModifiedTrade.getAccount()));
	}

	@Test
	public void deleteTradeTest() throws Exception {
		tradeService.deleteTrade(trade.getTradeId());
		assertFalse(tradeRepository.existsById(trade.getTradeId()));

	}
}
