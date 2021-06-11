package kr.co.ensmart.frameworkdemo.app.dao.sample;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ensmart.frameworkdemo.common.dto.sample.Sample;

@Repository
public interface SampleMapper {
	List<Sample> selectAllSampleList();

	Sample selectSampleById(Integer id);
}
