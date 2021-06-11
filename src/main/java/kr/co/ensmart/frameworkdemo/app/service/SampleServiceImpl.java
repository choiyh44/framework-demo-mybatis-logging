package kr.co.ensmart.frameworkdemo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ensmart.frameworkdemo.app.dao.sample.SampleMapper;
import kr.co.ensmart.frameworkdemo.common.dto.sample.Sample;

@Service
public class SampleServiceImpl implements SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	
	@Override
	public List<Sample> retrieveAllSamples() {
		return  sampleMapper.selectAllSampleList();
	}

	@Override
	public Sample retrieveSampleById(Integer id) {
		return  sampleMapper.selectSampleById(id);
	}
}
