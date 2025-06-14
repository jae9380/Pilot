package com.step01;

public class HelloBiodome08 {
    private static String[] words;
    public static void main(String[] args) {
        words = new String[]{"hello", "where", "this", "biodome", "help", "tree", "new", "is", "problem",
                "please", "need", "we", "isn’t","there", "a", "your", "any", "thanks", "the", "for", "solution", "can", "?"};
        boolean preIsWord = false;
        StringBuilder sb = new StringBuilder();
        String input = args[0];
        int index = 0;

        while (index < input.length()) {
            String matched = null;
            for (String word : words) { // 정해진 영어 단어 기준으로 적합성 판단
                if (index + word.length() <= input.length()) {  // 특정 인덱스 기준으로 단어길이를 합하여 입력값의 길이보다 클 경우 해당하지 않는 단어로 판별
                    if(word.equals("a") && input.charAt(index+1 < input.length() ? index + 1 : index) == 'n' ) {
                        // 단어가 "a"시작일 경우 단어 사전에서 "a"를 우선적으로 탐지하는 문제 발생
                        // aaanyaaanyaa -> a a a ny a a a ny a a 출력하는 문제가 발생한다.
                        // 위 문제를 해결핫기 위해서 "a"로 시작하게 되는 경우, 다음 문자를 확인하여 문제를 방지한다.

                        String subStr = input.substring(index, index + word.length()+2);
                        if (subStr.equals(word)) {
                            matched = word;
                            preIsWord = true;
                            break;
                        }

                    }else if(word.equals("t") && input.charAt(index+3 < input.length() ? index + 3 : index) == 'r' ) {
                        // there과 the 또한 a와 any 같은 문제가 발생한다.
                        String subStr = input.substring(index, index + word.length()+4);
                        if (subStr.equals(word)) {
                            matched = word;
                            preIsWord = true;
                            break;
                        }

                    }else {
                        String subStr = input.substring(index, index + word.length());
                        if (subStr.equals(word)) {
                            matched = word;
                            preIsWord =true;
                            break;
                        }
                    }
                }
            }

            if (matched != null) {
                if (matched.equals("?")) {
                    sb.append(input.charAt(index));
                    index++;
                }else{
                    if (sb.length() > 0) sb.append(" ");
                    sb.append(matched);
                    index += matched.length();
                }
            } else {
                if (preIsWord) sb.append(" ");
                sb.append(input.charAt(index));
                index++;
            }
        }

        if (sb.charAt(sb.length()-1) != '?') sb.append(".");
        System.out.println(sb);
    }
}
/*
* 주어지는 단어의 수가 제한되어 있기에 단어 배열을 기준으로 입력값의 단어와 비교를 진행 하였다. 이러한 이유는 만약 입력값에 나타나있는 문자열이 주어지는
  단어 배열에 없을 경우 배열 전체를 돌아야 하기 때문에 단어 배열 기준으로 돌리는 것이 좋다고 판단하였다.
* 특정 인덱스에서 특정 단어의 길이를 합산한 값이 입력값의 전체 길이보다 큰 경우는 적합하지 않다고 판단하여 조건문을 작성하였다.
* 특정 인덱스에서 특정 단어의 길이 만큼을 입력값에 짤라 단어와 비교를 할 때 큰 문제가 발생한다.
  주어지는 단어 배열에서는 "any"가 "a"보다 뒤에 있기 떄문에 입력값에서 "any"단어가 있지만 코드에서는 "a"가 동일하다고 먼저 판정 되기 때문에
  입력값이 "any"일 경우 "a ny"로 출력이 된다.
  이러한 문제를 해결하기 위해서 word가 "a"일 경우 and input.charAt(i+1) == 'n'경우를 찾아 두 조건이 맞을 경우를 조건문을 작성하여 따로 관리하였다.

* 추가 수정사항
    모르는 단어가 단어 뒤에 올 경우 모르는 단어는 공백이 없어야 하며, ?으로 끝나지 않을 경우 .을 붙여줘야 하기 때문에 해당 기능을 수정해야 함
 */