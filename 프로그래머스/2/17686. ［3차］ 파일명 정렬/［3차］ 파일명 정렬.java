import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        File[] sliceFile = new File[files.length];
        String[] answer = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            sliceFile[i] = slice(files[i]);
        }

        Arrays.sort(sliceFile, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.head.equalsIgnoreCase(o2.head)) {
                    return o1.number - o2.number;
                } else {
                    return o1.head.compareTo(o2.head);
                }
            }
        });

        for (int i = 0; i < files.length; i++) {
            answer[i] = sliceFile[i].ordinaryFileName;
        }
        
        return answer;
    }
    
    static File slice(String fileName) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        boolean check = false;
        int count = 0;

        for (int i = 0; i < fileName.length(); i++) {
            char c = fileName.charAt(i);

            if (!check && !Character.isDigit(c)) {
                if (isCharacter(c)) {
                    head.append(String.valueOf(c).toLowerCase());
                } else {
                    head.append(c);
                }
            } else {
                check = true;
            }

            if (check && Character.isDigit(c) && count < 5) {
                number.append(c);
                count++;
            } else if (check) {
                break;
            }
        }

        return new File(fileName, head.toString(), Integer.parseInt(number.toString()));
    }

    static boolean isCharacter(char c) {
        return c >= 65 && c <= 90 || 97 <= c && 122 >= c;
    }
}

class File {
    String ordinaryFileName;
    String head;
    int number;

    public File(String ordinaryFileName, String head, int number) {
        this.ordinaryFileName = ordinaryFileName;
        this.head = head;
        this.number = number;
    }
}
