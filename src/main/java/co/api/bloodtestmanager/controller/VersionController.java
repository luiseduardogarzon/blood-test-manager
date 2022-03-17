package co.api.bloodtestmanager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	@Value("${app.version}")
	private String version;

	@Value("${app.name}")
	private String appName;

	@GetMapping("/version")
	public String getVersion() {
		return this.appName + " " + this.version;
	}
}
