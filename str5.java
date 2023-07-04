public class str5 {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int compressLen = compress(chars);
        System.out.println("Compressed Length: " + compressLen);
        System.out.print("Compressed Array: ");
        for (int i = 0; i < compressLen; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int index = 0; 
        int count = 1; 

        for (int i = 1; i <= n; i++) {
            if (i < n && chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[index++] = chars[i - 1]; 

                if (count > 1) {
                    String countStr = String.valueOf(count);

                    for (char c : countStr.toCharArray()) {
                        chars[index++] = c; 
                    }
                }

                count = 1; 
            }
        }
        return index;
    }
}

