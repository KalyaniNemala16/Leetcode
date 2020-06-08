class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int count = 1;
        int sum = 0;
        int val;
        int i = 0;
        while(i+1 < s.length())
        {
            count = 1;
            int diff = roman.get(s.charAt(i+1)) - roman.get(s.charAt(i));
            if(diff < 0){
                val = roman.get(s.charAt(i));
                sum = sum + val;
                i++;
            }
            else if(diff == 0){
                while(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                    count++; i++;
                }
                val = roman.get(s.charAt(i));
                val = val * count;
                sum = sum + val;
                i++;
            }
            else{
                sum = sum + diff;
                i = i+2;
            }

        }
        if(i == s.length()-1)
            sum = sum + roman.get(s.charAt(i));
        return sum;

    }
}
