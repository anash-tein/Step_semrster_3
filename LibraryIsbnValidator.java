public class LibraryIsbnValidator {
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
 
        if (trimmed.length() < 3) {
            return trimmed; // too short to normalize a publisher code; validation will catch this
        }
 
        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
 
        return publisherCode + rest;
    }
 
    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }
 
        String publisherCode = code.substring(0, 3);
        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
 
        String body = code.substring(3); // 4-digit year + 6-digit catalog number
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: year and catalog number must be digits";
            }
        }
 
        String year = code.substring(3, 7);      // 4 digits
        String catalog = code.substring(7, 13);  // 6 digits
 
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(publisherCode).append("] ");
        formatted.append("YEAR: ").append(year);
        formatted.append(" | CATALOG: ").append(catalog);
 
        return formatted.toString();
    }
 
    public static void main(String[] args) {
        String code1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code1));
 
        String code2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(code2));
    } 
}
