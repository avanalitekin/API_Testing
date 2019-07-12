package chicago.apiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Contact {
	
	private int contactId;
	private String phone;
	private String emailAddress;
	
	public Contact() {
		super();
	}

	public Contact(int contactId, String phone, String emailAddress) {
		super();
		this.contactId = contactId;
		this.phone = phone;
		this.emailAddress = emailAddress;
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

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", phone=" + phone + ", emailAddress=" + emailAddress + "]";
	}
	
	

}
