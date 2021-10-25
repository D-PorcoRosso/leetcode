package mysource.Solution271;

public class Solution {


    // Encodes a list of strings to a single string.
    public String encode_2021_250(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        int separater = 257;
        int empty = 258;
        for (int i = 0 ; i < strs.size(); i++) {
            if (strs.get(i).equals(""))
                builder.append((char)empty);
            else
                builder.append(strs.get(i));
            if (i != strs.size()-1 )
                builder.append((char)separater);
        }
        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode_2021_250(String s) {
        int separaterNum = 257;
        int empty = 258;
        
        String separater = Character.toString(separaterNum);
        String emptyString = Character.toString(empty);
        String[] strs = s.split(separater);
        List<String> result = new ArrayList<>();
        for (String str : strs) {
            if(str.equals(emptyString)) {
                result.add("");
            } else {
                result.add(str);
            }
        }
        return result;
    }

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
