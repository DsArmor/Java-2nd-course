public class Ex5 {
    public void printMessage(String key) {
        String message = getDetails(key);
        System.out.println(message);
    }

    public String getDetails(String key) {
        try {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
        } catch (NullPointerException e){
            printMessage(key);
        }
        System.out.println();
        return "data for" + key;
    }

    public static void main(String[] args) {
        new Ex5().getDetails(null);
    }
}