package com.santander.chl.csvgrouped.chl_csvgrouped_trnsftask;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.santander.chl.csvgrouped.chl_csvgrouped_trnsftask.dto.Rutas;

@Component
public class ExecuteExecListOfCsv extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		getContext().getPropertiesComponent().setLocation("classpath:execparameters.properties");
		getContext().getShutdownStrategy().setTimeout(10);
		errorHandler(defaultErrorHandler().maximumRedeliveries(0));
		
		from("direct:exec-csv-list-action").routeId("main")
			.pollEnrich("file:target/list/?fileName=csvjsonlist.json&noop=true&idempotent=false")
			.unmarshal()
			.json(JsonLibrary.Jackson, Rutas.class)
			.split().simple("body.rutas")
			.to("log:inputOrderItem")
				.choice().when().simple("'ruta001'").to("direct:ruta001")
				.choice().when().simple("'ruta002'").to("direct:ruta002")
				.choice().when().simple("'ruta003'").to("direct:ruta003")
				.choice().when().simple("'ruta004'").to("direct:ruta004")
				.choice().otherwise().to("direct:sinruta");
		
		from("direct:ruta001").routeId("ruta001")
			.log("Ruta 001")
			.log("Procesando exec Ruta 001")
			//.process(new ProcessExecDataToCtl())...
			.to("exec:sqlldr?args=userid={{exec.queryconn}} control='{{exec.control.route001}}' data='{{exec.data.route001}}' log='{{exec.log.route001}}'")
		.end();
		
		from("direct:ruta002").routeId("ruta002")
			.log("Ruta 002")
			.log("Procesando exec Ruta 002")
			//.process(new ProcessExecDataToCtl())...
			.to("exec:sqlldr?args=userid={{exec.queryconn}} control='{{exec.control.route002}}' data='{{exec.data.route002}}' log='{{exec.log.route002}}'")
		.end();
		
		from("direct:ruta003").routeId("ruta003").log("Ruta 003").end();
		from("direct:ruta004").routeId("ruta004").log("Ruta 004").end();
		from("direct:sinruta").routeId("sinruta").log("Ruta inexistente").end();

	}

}
