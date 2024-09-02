package com.santander.chl.csvgrouped.chl_csvgrouped_trnsftask;

import org.springframework.stereotype.Component;
import org.apache.camel.builder.RouteBuilder;

@Component
public class ExecuteExecToCtl extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		/*

		getContext().getPropertiesComponent().setLocation("classpath:execparameters.properties");
		getContext().getShutdownStrategy().setTimeout(10);
		errorHandler(defaultErrorHandler().maximumRedeliveries(0));
		
		*/
		/*
		from("direct:exec-ctl-action")
			.log("Procesando exec")
			//.process(new ProcessExecDataToCtl())...
			.to("exec:sqlldr?args=userid={{exec.queryconn}} control='{{exec.control}}' data='{{exec.data}}' log='{{exec.log}}'")
		.end(); 
		*/
		
	}

}
