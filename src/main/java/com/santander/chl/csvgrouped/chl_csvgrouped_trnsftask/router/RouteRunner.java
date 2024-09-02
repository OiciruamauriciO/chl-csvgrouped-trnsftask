package com.santander.chl.csvgrouped.chl_csvgrouped_trnsftask.router;

import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RouteRunner {
	
	private static Logger log = LoggerFactory.getLogger(RouteRunner.class);
	private final FluentProducerTemplate producer;
	
	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		Exchange exchange = producer.to("direct:exec-csv-list-action").send();
		log.info("Direct Exec List Of Csvs Executed");		
		log.info(exchange.getIn().getBody(String.class));
	}

}
