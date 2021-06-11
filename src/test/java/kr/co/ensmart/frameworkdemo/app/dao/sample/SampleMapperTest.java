package kr.co.ensmart.frameworkdemo.app.dao.sample;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import kr.co.ensmart.frameworkdemo.common.dto.sample.Sample;
import lombok.extern.slf4j.Slf4j;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
class SampleMapperTest {
	@Autowired
	private SampleMapper sampleMapper;

	@Test
	void selectAllSampleList() {
		List<Sample> sampleList = sampleMapper.selectAllSampleList();
		Assertions.assertNotNull(sampleList);
		Assertions.assertTrue(sampleList.size() > 0);
		
		log.info("sampleList: {}", sampleList);
	}

}
