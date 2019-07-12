package chicago.apiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Company {
	
	private int companyId;
	private String companyName;
	private String title;
	private String startDate;
	private Address address;
	
	public Company() {
		super();
	}
	public Company(int companyId, String companyName, String title, String startDate, Address address) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.title = title;
		this.startDate = startDate;
		this.address = address;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", title=" + title + ", startDate="
				+ startDate + ", address=" + address + "]";
	}

	
}
