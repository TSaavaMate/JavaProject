import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    private static int firstMissingPositive(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for (int num : nums)
            if (num > 0) numset.add(num);
        int answer = 1;
        while (numset.contains(answer)) {
            answer++;
        }
        return answer;
    }

    private static String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int maxLength = 0;
        String answer = null;
        for (int i = 0; i < s.length(); i++) {
            //when palindrome length is odd
            if (i > 0 && i < s.length() - 1 && s.charAt(i - 1) == s.charAt(i + 1)) {
                int size = 0, first = i, last = i;

                while (first > 0 && last < s.length() - 1 && s.charAt(first - 1) == s.charAt(last + 1)) {
                    size += 2;
                    first--;
                    last++;
                }
                size++;

                if (size > maxLength) {
                    maxLength = size;
                    answer = s.substring(first, last + 1);
                }
            }
            //when palindrome length is even
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                int size = 0, first = i, last = first + 1;

                while (first >= 0 && last < s.length() && s.charAt(first) == s.charAt(last)) {
                    size += 2;
                    first--;
                    last++;
                }

                first++;
                last--;

                if (size > maxLength) {
                    maxLength = size;
                    answer = s.substring(first, last + 1);
                }
            }
        }
        return (answer != null) ? answer : String.valueOf(s.charAt(0));
    }

    private static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;

        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }

    private static String convert(String s, int numRows) {
        return "failed";
    }

    private static double myPow2(double x, int n) {
        if (n == 0 || x == 1) return 1.0;
        if (x == -1 && n % 2 == 0) return 1;
        if (x == -1 && n % 2 == 1) return -1;
        if (n == -2147483648) return 0;
        double answer = 1;
        if (n > 0) {
            while (n > 1) {
                answer *= x;
                n--;
            }
            return answer * x;
        } else {
            n = -n;
            while (n > 1) {
                answer *= x;
                n--;
            }
            return 1 / (answer * x);
        }
    }

    private static double myPow(double x, int n) {
        if (n == 1)
            return x;
        return x * myPow(x, n - 1);
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        merged = Arrays.stream(merged).sorted().toArray();
        if (merged.length == 1) return merged[0];
        if (merged.length % 2 == 1) {
            return merged[(merged.length - 1) / 2];
        } else {
            System.out.println("here");
            return (merged[merged.length / 2] + merged[(merged.length / 2) - 1]) / 2.0;
        }
    }

    private static int reverse(int x) {
        try {
            if (x < 0)
                return -1 * Integer.parseInt(String.valueOf(new StringBuilder(Integer.toString(x).substring(1)).reverse()));
            return Integer.parseInt(String.valueOf(new StringBuilder(Integer.toString(x)).reverse()));

        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() <= 2) return (int) Arrays.stream(s.split("")).distinct().count();
        int longestS = 0;
        ArrayList<Integer> longests = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                if (Arrays.stream(s.substring(i, j).split("")).distinct().count() == s.substring(i, j).length()) {
                    longests.add(s.substring(i, j).length());
                }
            }
        }
        return longests.stream().max(Integer::compare).get();
    }

    private static int jojiGenerator(int start, int end) {
        return (int) Math.round(Math.random() * (end - start) + start);
    }

    private static String addBinary(String a, String b) {
        if (a.equals("0") && b.equals("0")) return "0";
        long sumA = 0;
        for (int i = a.length() - 1; i >= 0; i--)
            sumA += a.charAt(i--) - '0';
//            sumA += Integer.parseInt(String.valueOf(a.charAt(i))) *  Math.pow(2, a.length() - 1 - i);

        long sumB = 0;
        for (int i = b.length() - 1; i >= 0; i--)
            sumB += Integer.parseInt(String.valueOf(b.charAt(i))) * Math.pow(2, b.length() - 1 - i);
        long ans = sumA + sumB;
        StringBuilder answerAsStr = new StringBuilder();
        while (ans > 0) {
            long remainder = ans % 2;
            answerAsStr.append(remainder);
            ans = ans / 2;
        }
        return answerAsStr.reverse().toString();
    }

    private static int searchInsert(int[] nums, int target) {
        var list = Arrays.stream(nums).boxed().toList();
        if (list.contains(target)) return list.indexOf(target);
        if (list.contains(target - 1)) return list.indexOf(target - 1) + 1;
        if (list.contains(target + 1)) return list.indexOf(target + 1) - 1;
        if (target == 0 || list.get(0) > target) return 0;
        if (list.get(list.size() - 1) < target) return list.size();
        return 0;

    }

    private static int lengthOfLastWord(String s) {
        return s.split(" ")[s.split(" ").length - 1].length();
    }

    private static int stray(int[] numbers) {
        int[] sorted = Arrays.stream(numbers).distinct().toArray();
        return sorted[1];
    }

    private static int removeDuplicates(int[] nums) {
        return (int) Arrays.stream(nums).distinct().count();

    }

    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    private static boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        boolean valid = false;
        for (int i = 0; i < s.length() - 1; i += 2) {
            var newS = s.split("");
            if (newS[i].equals("(") && newS[i + 1].equals(")") ||
                    newS[i].equals("{") && newS[i + 1].equals("}") ||
                    newS[i].equals("[") && newS[i + 1].equals("]"))
                valid = true;
            else valid = false;

        }
        return valid;
    }

    private static int count(String str, String inStr) {
        return (int) Arrays.stream(inStr.split("")).filter(a -> (a.equals(str))).count();
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    private static int removeElement(int[] nums, int val) {
        var smth = Arrays.stream(nums).filter(it -> it != val).toArray();
        System.out.println(Arrays.toString(smth));
        return smth.length;
    }

    private static boolean isPalindrom(int x) {
        if (x < 0) return false;
        var string = new StringBuilder(Integer.toString(x)).reverse();
        try {
            return x == Integer.parseInt(String.valueOf(string));
        } catch (Exception e) {
            return x == Long.parseLong(String.valueOf(string));
        }
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reverse = 0;
        int y = x;
        while (x != 0) {
            int remainder = x % 10;
            reverse = reverse * 10 + remainder;
            x = x / 10;
        }
        return y == reverse;
    }

    private static int factorial(int num) {
        if (num == 1)
            return num;
        else
            return num * factorial(num - 1);
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 2; i++) {
            for (int j = 1 + i; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target && i != j) return new int[]{i, j};
            }
        }
        return null;
    }

    private static int romanToInt(String s) {
        int count = 0;
        count += (s.contains("IV")) ? 4 : 0;
        count += (s.contains("IX")) ? 9 : 0;
        count += (s.contains("XL")) ? 40 : 0;
        count += (s.contains("XC")) ? 90 : 0;
        count += (s.contains("CD")) ? 400 : 0;
        count += (s.contains("CM")) ? 900 : 0;
        s = s.replace("IV", "").replace("IX", "").replace("XL", "")
                .replace("XC", "").replace("CD", "").replace("CM", "");
        return count + count("I", s) + 5 * count("V", s) + 10 * count("X", s) + 50 * count("L", s) + 100 * count("C", s)
                + 500 * count("D", s) + 1000 * count("M", s);
    }

    private static String summer(int n) {
        return String.format("%.2f", IntStream.range(0, n).mapToDouble(it -> (double) 1 / (1 + 3 * it)).sum()
        );
    }

    private static void readFile2() throws FileNotFoundException {
        File myObj = new File("C:\\Users\\mmmmiiiiiiiaaaaaa\\Calc\\src\\newfile");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    }

    private static void readFile() {
        try (
                var obj = new FileReader("C:\\Users\\mmmmiiiiiiiaaaaaa\\Calc\\src\\file.txt")
        ) {
//            fileWriter.append("hhhhhhhhhexample");

            int value = obj.read();
            while (value != -1) {
                System.out.print((char) value);
                value = obj.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String longest(String s1, String s2) {
        String s = s1 + s2;
        return s.chars().distinct().sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static int mySqrt(int x) {
        return (int) Math.round(Math.sqrt(x)-0.5);
    }

    public static int[] twoSumReal(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};
    }
}
