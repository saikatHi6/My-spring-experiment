package com.atom.webfunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFunctionApplication.class, args);
	}

	List<CloudFuntions> listOfCloudFuntions;

	public WebFunctionApplication() {
		listOfCloudFuntions = new ArrayList<CloudFuntions>();
		listOfCloudFuntions.add(new CloudFuntions("F001", "ec2 Instances", 100));
		listOfCloudFuntions.add(new CloudFuntions("F002", "s3 Bucket", 500));
		listOfCloudFuntions.add(new CloudFuntions("F003", "segmeter", 1000));
	}

	@Bean
	public Function<String, CloudFuntions> retreievFunctionDetai() {
		return value -> {
			System.out.println("Retriev Request for Cloud Services -" + value);
			return listOfCloudFuntions.stream().filter(service -> value.equals(service.getFunctionId())).findAny()
					.orElse(null);
		};
	}

	@Bean
	public Consumer<UsageRecord> processUsageDetails() {
		return value -> {
			System.out.println(
					"Recevied Usage Month and Price - " + value.getUsegMonth() + " " + value.getUsageDuration());
		};
	}

	@Bean
	public Function<UsageRecord, Mono<Void>> processToUsageRecordReactive() {
		return value -> {
			System.out.println("Recevid Rent For Month Of - " + value.getUsegMonth() + " Time Duration is "
					+ value.getUsageDuration());
			return Mono.empty();
		};
	}

	@Bean
	public Consumer<Flux<UsageRecord>> processListUsageRecordReactive() {
		return value -> {
			value.subscribe(service -> System.out.println(service.getCloudId()));
		};
	}

	@Bean
	public Supplier<Flux<CloudFuntions>> getAllTheCloudServices() {
		return () -> Flux.fromIterable(listOfCloudFuntions);
	}

}
