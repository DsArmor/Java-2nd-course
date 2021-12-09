public class PhoneNumber {

    private String phone;

    private String parsePhone(StringBuffer phone) {
        if (phone.charAt(0) != '+')
            phone.insert(0, '+');
        phone.insert(phone.length() - 4, '?');
        phone.insert(phone.length() - 8, '?');
        return String.valueOf(phone);
    }

    public PhoneNumber(String phone) {
        this.phone = parsePhone(new StringBuffer(phone));
    }

    public String getPhone() {
        return phone;
    }
}
