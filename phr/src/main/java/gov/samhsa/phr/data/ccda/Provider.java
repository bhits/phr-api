package gov.samhsa.phr.data.ccda;

public class Provider {
        public String getRole() {
                return role;
        }

        public void setRole(String role) {
                this.role = role;
        }

        public PersonName getName() {
                return name;
        }

        public void setName(PersonName name) {
                this.name = name;
        }

        public ContactInformation getContact() {
                return contact;
        }

        public void setContact(ContactInformation contact) {
                this.contact = contact;
        }

        private String role;

        private PersonName name;

        private ContactInformation contact;
}
