package com.example.practice.npe;


import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.NonNull;

/**
 * @author Incheol Jung
 */
public class NPEExample {

    public static class DtoTemp{
        public DtoTemp(Integer size) {
            this.size = size;
        }

        @NotNull
        public Integer size;
    }

    public Integer arithmeticException(@NonNull Integer size){
        return 5/size;
    }

    public Integer dtoNullCheck(@NonNull DtoTemp temp){
        return 5/temp.size;
    }

    public boolean euqlasTest(String test){
        // test 변수가 null일 경우 NPE 발생
//        return test.equals("test");
        // non null String 기준으로 먼저 비교해야 한다.
        return "test".equals(test);
    }

    public String valueOfTest(String test){
        // test 변수가 null일 경우 NPE 발생
//        return test.toString();
        // non null String 기준으로 먼저 비교해야 한다.
        return String.valueOf(test);
    }

    public void nullCheckString(String test){
//        if(test != null){
//            System.out.println(test.toString());
//        }

        // apache.commons 라이브러리에 StringUtils 사용
        if(!StringUtils.isEmpty(test)){
            System.out.println(test.toString());
        }
    }

    public void optionalTest(Optional<String> test){
        if(test.isPresent()){
            System.out.println(test.toString());
        }
    }

    private void tryCatchTest(String test) {
        try {
            System.out.println(test.toString());
        }catch (Exception ex){
            System.out.println("catch - null pointer exception");
        }
    }

    public static void main(String[] args) {
        NPEExample example = new NPEExample();
        // case 1. @NonNull 사용
//        example.arithmeticException(null);

        // case 2. @NotNull 사용(확인 필요)
//        example.dtoNullCheck(new DtoTemp(null));

        // case 3. equals 순서 변경
//        System.out.println(example.euqlasTest(null));

        // case 4. toString -> valueOf 사용
//        System.out.println(example.valueOfTest(null));

        // case 5. null 체크, 또는 StringUtils 사용
//        example.nullCheckString(null);

        // case 6. optional 사용
        // Optional.of(T)
        // - T로 받은 non-null 값을 포함하는 Optional 객체 반환, T가 null 일 경우 NPE 발생
        // Optional.absent()
        // - 아무것도 포함하고 있지 않는 absent Optional 객체 반환
        // Optional.fromNullable(T)
        // - T로 받은 값이 non-null일 경우 present로, null일 경우 absent로 처리한 Optional 객체 반환
//        String tempString = null;
//        Optional<String> optionalString = Optional.ofNullable(tempString);
//        example.optionalTest(optionalString);

        // case 7. try / catch 사용
//        example.tryCatchTest(null);

        // case 8. method chainging 피하기
//        exmaple.getPerson().getAge().getYear();

        // case 9. List는 null 보다는 초기화 또는 emptyList
        List<Integer> items = null;
        items = new ArrayList<Integer>();
        items = Collections.emptyList();
    }


}
