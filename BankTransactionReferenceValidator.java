public class BankTransactionReferenceValidator {
    
    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
 
        if (trimmed.length() < 3) {
            return trimmed; // too short to normalize a bank code; validation will catch this
        }
 
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
 
        return bankCode + rest;
    }
 
    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }
 
        String bankCode = reference.substring(0, 3);
        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
 
        String body = reference.substring(3); // 6-digit date + 5-digit sequence
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: date and sequence number must be digits";
            }
        }
 
        String datePart = reference.substring(3, 9);   // ddMMyy
        String seqPart = reference.substring(9, 14);    // 5-digit sequence
 
        String day = datePart.substring(0, 2);
        String month = datePart.substring(2, 4);
        String year = datePart.substring(4, 6);
 
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] ");
        formatted.append("DATE: ").append(day).append("/").append(month).append("/").append(year);
        formatted.append(" | SEQ: ").append(seqPart);
 
        return formatted.toString();
    }
 
    public static void main(String[] args) {
        String ref1 = normalizeReference(" hdf03022600042  ");
        System.out.println(validateAndFormat(ref1));
 
        String ref2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(ref2));
    }
}
