class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int start = 0;
        for (int end = 0; end <= arr.length; end++) {
            if (end == arr.length || arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
        }
        return cleanSpaces(arr);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    private String cleanSpaces(char[] arr) {
        int n = arr.length;
        StringBuilder st = new StringBuilder();
        int i = 0;

        while (i < n) {
            while (i < n && arr[i] == ' ') {
                i++;
            }
            while (i < n && arr[i] != ' ') {
                st.append(arr[i]);
                i++;
            }
            while (i < n && arr[i] == ' ') {
                i++;
            }
            if (i < arr.length) {
                st.append(' ');
            }
        }
        return st.toString();
    }
}