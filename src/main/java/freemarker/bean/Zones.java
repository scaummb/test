package freemarker.bean;

import java.sql.Timestamp;

/**
 * @author moubin.mo
 * @date: 2020/5/17 10:44
 */

public class Zones {
	private String name;
	private Timestamp licenseEndDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLicenseEndDate() {
		return licenseEndDate;
	}

	public void setLicenseEndDate(Timestamp licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}
}
