package org.example.lamdba.advance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    @Test
    void test() {

        // DB에서 가져온 회원정보 리스트
        List<User> userList = Arrays.asList(
                new User("1", "222@naver.com", "1234", "닉닉1"),
                new User("2", "333@naver.com", "5678", "닉닉2"),
                new User("3", "444@naver.com", "9012", "닉닉3"),
                new User("4", "555@naver.com", "3456", "닉닉4")
        );
        /*
        // 클라이언트에 보낼 리스트
        List<UserDTO> response = new ArrayList<>();
        for (User user: userList
             ) {
            UserDTO dto = new UserDTO(user);
            response.add(dto);
        }
         */
        List<UserDTO> response = userList.stream().map(UserDTO::new).collect(Collectors.toList());// ctrl + p 누르면 뭐넣어야하는지 나옴
        // ctrl alt v
        response.forEach(System.out::println);

        /*
            .stream 연계 메서드
            1. forEach : 컬렉션의 내부 요소들 하나씩 소비
            2. filter : 컬렉션 내부요소들을 하나씩 검사하여 필터링한 새로운 컬렉션 반환
            3. map : 컬렉션 내부요소들을 하나씩 주어진 조건대로 맵핑하여 새로운 컬렉션 반환

            ex) arr.filter(n -> n % 2 == 0)
            => 숫자배열에서 짝수들만 뽑아서 새배열 리턴
            [1, 2, 3, 4, 5]
            [2, 4]

            arr.map(n -> n * 2)
            => 숫자배열의 모든 원소들을 2배씩 늘려놓은 새배열 리턴
            [1, 2, 3, 4, 5]
            [2, 4, 6, 8, 10]
        */


    }


}