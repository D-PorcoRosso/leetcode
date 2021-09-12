package mysource.Solution271;

public class Solution {

    // Encodes a list of strings to a single string.
    public String encode_usingoutchar(List<String> strs) {
        if (strs.size() == 0) return Character.toString((char)257);
        String d = Character.toString((char)258);
        StringBuilder sb = new StringBuilder();
        for ( String s : strs ) {
            sb.append(s);
            sb.append(d);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode_usingoutchar(String s) {
        String d = Character.toString((char)257);
        if (s.equals(d)) return new ArrayList();
        
        d = Character.toString((char)258);
        return Arrays.asList(s.split(d,-1));
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String encoded = "";
        for ( String str : strs ) {
            char[] strArray = str.toCharArray();
            if (strArray.length == 0) {
                encoded = encoded + " ";
            } else {
                for ( int i = 0 ; i < strArray.length ; i++ ) {
                    int temp = strArray[i];
                    encoded = encoded + temp + ",";
                }
            }
            encoded = encoded + ";";
        }
        return encoded;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] decodeChars = s.split(";");
        List<String> decodedString = new ArrayList<>();
        for ( int i = 0 ; i < decodeChars.length ; i++ ) {
            String temp = "";
            if (!decodeChars[i].equals(" ")) {
                String[] chars = decodeChars[i].split(",");
                for(int j = 0 ; j < chars.length ; j++) {
                    int t = Integer.parseInt(chars[j]);
                    temp = temp + (char)t;
                }
            }
            decodedString.add(temp);
        }
        return decodedString;
    }
}
