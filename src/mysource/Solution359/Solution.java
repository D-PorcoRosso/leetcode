package mysource.Solution359;

class Logger {

    HashMap<String, Integer> mapping = new HashMap();
    /** Initialize your data structure here. */
    public Logger() {
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (mapping.containsKey(message)) {
            if(timestamp - mapping.get(message) >= 10) {
                mapping.put(message,timestamp);
                return true;
            } else 
                return false;
        } else {
            mapping.put(message,timestamp);
            return true;
        }
    }
}
