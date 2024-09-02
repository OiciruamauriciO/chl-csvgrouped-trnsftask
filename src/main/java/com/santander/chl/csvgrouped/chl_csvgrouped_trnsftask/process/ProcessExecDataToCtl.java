package com.santander.chl.csvgrouped.chl_csvgrouped_trnsftask.process;

import org.springframework.stereotype.Component;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ProcessExecDataToCtl implements Processor {
	
	private static Logger log = LoggerFactory.getLogger(ProcessExecDataToCtl.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {

		String data = exchange.getIn().getBody(String.class);

		if (data != null) {
			log.info("DATA TO SPLIT");
			log.info(data);
		} else {
			log.info(" Data está no lista (null)");
		}
		
	}

}
