package mysource.Solution12;

public class Solution {
    public String intToRoman(int num) {
        String result = "";
        while (num > 0) {
            int count = 0;
            if (num / 1000 >= 1) {
                num = num - 1000;
                result += "M";
            } else {
                if (num/900 >= 1) {
                    num = num - 900;
                    result += "CM";
                } else {
                    if (num/500 >= 1) {
                        num = num - 500;
                        result += "D";
                    } else {
                        if (num/400 >= 1) {
                            num = num - 400;
                            result += "CD";
                        } else {
                            if (num/100 >= 1) {
                                num = num - 100;
                                result += "C";
                            } else {
                                if (num/90 >= 1) {
                                    num = num - 90;
                                    result += "XC";
                                } else {
                                    if (num/50 >= 1) {
                                        num = num - 50;
                                        result += "L";
                                    } else {
                                        if (num/40 >= 1) {
                                            num = num - 40;
                                            result += "XL";
                                        } else {
                                            if (num/10 >= 1) {
                                                num = num - 10;
                                                result += "X";
                                            } else {
                                                if (num/9 >= 1) {
                                                    num = num - 9;
                                                    result += "IX";
                                                } else {
                                                    if (num/5 >= 1) {
                                                        num = num - 5;
                                                        result += "V";
                                                    } else {
                                                        if (num/4 >= 1) {
                                                            num = num - 4;
                                                            result += "IV";
                                                        } else {
                                                            num = num - 1;
                                                            result += "I";
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
