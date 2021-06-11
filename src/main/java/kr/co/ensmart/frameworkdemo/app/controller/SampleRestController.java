package kr.co.ensmart.frameworkdemo.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ensmart.frameworkdemo.app.service.SampleService;
import kr.co.ensmart.frameworkdemo.common.dto.sample.Sample;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sample/api")
@RequiredArgsConstructor
public class SampleRestController {
	private final SampleService sampleService;
	
	@GetMapping("/retrieve-all-samples")
	public List<Sample> retrieveAllSamples() {
		return sampleService.retrieveAllSamples();
	}
	
	@GetMapping("/{id}")
	public Sample retrieveAllSamples(@PathVariable Integer id) {
		return sampleService.retrieveSampleById(id);
	}
	
}
