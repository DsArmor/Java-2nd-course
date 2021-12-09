import java.util.StringTokenizer;

public class Address {

    String country;
    String region;
    String city;
    String street;
    String house;

    private String parseWord(StringBuffer word) {
        int n = word.length() / 2;
        for (int i = 0; i < n; i++) {
            if (word.charAt(0) == ' ')
                word.delete(0, 1);
            else if (word.charAt(word.length() - 1) == ' ')
                word.delete(word.length() - 1, word.length());
            else
                break;
        }
        return String.valueOf(word);
    }

    public Address(String str, String delim) {
        StringTokenizer st = new StringTokenizer(str, delim);
        country = parseWord(new StringBuffer(st.nextToken()));
        region = parseWord(new StringBuffer(st.nextToken()));
        city = parseWord(new StringBuffer(st.nextToken()));
        street = parseWord(new StringBuffer(st.nextToken()));
        house = parseWord(new StringBuffer(st.nextToken()));
    }

    public Address(String str) {
        String[] strings = str.split("\\?");
        country = parseWord(new StringBuffer(strings[0]));
        region = parseWord(new StringBuffer(strings[1]));
        city = parseWord(new StringBuffer(strings[2]));
        street = parseWord(new StringBuffer(strings[3]));
        house = parseWord(new StringBuffer(strings[4]));
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                '}';
    }
}
