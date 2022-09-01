import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
// 못품. set으로 풀면 안된다.
public class NewsClustering {
    public int solution(String str1, String str2) {
        // 1. 두글자씩 끊어 다중집합을 만든다
        // 2. 자카드 유사도 (교집합 / 합집합)을 계산한다
        // 3. 65536을 곱해서 return 한다.

        // 대문자로 만들고 영문자 제외 모두 제거
        String str1UpperCase = str1.toUpperCase();
        String str2UpperCase = str2.toUpperCase();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (char c : str1UpperCase.toCharArray()) {
            if (c >= 'A' && c <= 'Z') sb1.append(c);
        }
        for (char c : str2UpperCase.toCharArray()) {
            if (c >= 'A' && c <= 'Z') sb2.append(c);
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < sb1.length() - 2; i++) {
            set1.add(sb1.substring(i, i + 2));
        }
        for (int i = 0; i < sb2.length() - 2; i++) {
            set1.add(sb2.substring(i, i + 2));
        }
        HashSet<String> intersection = new HashSet<>(set1);  // s1으로 intersection 생성
        HashSet<String> union = new HashSet<>(set1);
        intersection.retainAll(set2);
        union.addAll(set2);

        double j = intersection.size() / (double) union.size();
        return (int) j * 65536;
    }

    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        String str1UpperCase = str1.toUpperCase();
        String str2UpperCase = str2.toUpperCase();

        System.out.println(str1UpperCase);
        System.out.println(str2UpperCase);

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (char c : str1UpperCase.toCharArray()) {
            if (c >= 'A' && c <= 'Z') sb1.append(c);
        }
        for (char c : str2UpperCase.toCharArray()) {
            if (c >= 'A' && c <= 'Z') sb2.append(c);
        }

        System.out.println(sb1);
        System.out.println(sb2);

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < sb1.length() - 1; i++) {
            set1.add(sb1.substring(i, i + 2));
        }
        for (int i = 0; i < sb2.length() - 1; i++) {
            set2.add(sb2.substring(i, i + 2));
        }

        System.out.println(set1);
        System.out.println(set2);

        HashSet<String> intersection = new HashSet<>(set1);  // s1으로 intersection 생성
        HashSet<String> union = new HashSet<>(set1);
        intersection.retainAll(set2);
        union.addAll(set2);
        System.out.println(intersection);
        System.out.println(union);
        double j = intersection.size() / (double) union.size();
        System.out.println(j);
        System.out.println((int)(j*65536));


    }
}
