package kr.co.ensmart.frameworkdemo.app.service;

import java.util.List;

import kr.co.ensmart.frameworkdemo.common.dto.sample.Sample;

public interface SampleService {

	public List<Sample> retrieveAllSamples();

	public Sample retrieveSampleById(Integer id);

}
