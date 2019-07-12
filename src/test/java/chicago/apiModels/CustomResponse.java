package chicago.apiModels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CustomResponse {
	private List<Student> students;
	private List<Instructor> instructors;
	private String jsonResponse;
	private int addressId;
	private String street;
	private String city;
	private String state;
	private int zipCode;
	private int companyId;
	private String companyName;
	private String title;
	private String startDate;
	private Address address;
	int contactId;
	private String phone;
	private String emailAddress;
	private int id;
	private String firstName;
	private String lastName;
	private int batch;
	private Contact contact;
	private Company company;
	private String subject;
	
	public CustomResponse() {
		super();
	}
	
	
	public CustomResponse(List<Instructor> instructors, int addressId, String street, String city, String state,
			int zipCode, int companyId, String companyName, String title, String startDate, Address address,
			int contactId, String phone, String emailAddress, int id, String firstName, String lastName, int batch,
			String subject, Contact contact, Company company) {
		super();
		this.instructors = instructors;
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.companyId = companyId;
		this.companyName = companyName;
		this.title = title;
		this.startDate = startDate;
		this.address = address;
		this.contactId = contactId;
		this.phone = phone;
		this.emailAddress = emailAddress;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.batch = batch;
		this.subject = subject;
		this.contact = contact;
		this.company = company;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}


	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZipCode() {
		return zipCode;
	}


	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
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


	public int getContactId() {
		return contactId;
	}


	public void setContactId(int contactId) {
		this.contactId = contactId;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getBatch() {
		return batch;
	}


	public void setBatch(int batch) {
		this.batch = batch;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public Contact getContact() {
		return contact;
	}


	public void setContact(Contact contact) {
		this.contact = contact;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public String getJsonResponse() {
		return jsonResponse;
	}


	public void setJsonResponse(String jsonResponse) {
		this.jsonResponse = jsonResponse;
	}


	@Override
	public String toString() {
		return "CustomResponse [instructors=" + instructors + ", addressId=" + addressId + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", companyId=" + companyId
				+ ", companyName=" + companyName + ", title=" + title + ", startDate=" + startDate + ", address="
				+ address + ", contactId=" + contactId + ", phone=" + phone + ", emailAddress=" + emailAddress + ", id="
				+ id + ", firstName=" + firstName + ", lastName=" + lastName + ", batch=" + batch + ", subject="
				+ subject + ", contact=" + contact + ", company=" + company + "]";
	}
	
	

}
