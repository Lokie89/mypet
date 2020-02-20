# My Pet Project

### 주제
#### 유기동물 입양, 잃어버린 반려동물 찾기 서비스

### 개발방법
    1. 요구사항을 적는다
    2. 고민한다
    3. 테스트 만든다
    4. DB를 추가한다
    5. 코딩한다
    
### 요구사항 화면입장
##### 1. 유기동물 전체목록을 볼 수 있다.
    1.요구사항을 적는다
        a. 전체목록 가져오기 (DB)
        b. 원하는 분류로 순서를 정렬 (함수) 
        c. 원하는 분류에 맞는 목록 출력 (함수 sortPetFromClassification)
        
    2. 고민한다
    // 여기선 정렬이 필요한 것이 아니라 Filter 가 필요하였음.. Sort 다 만들고 깨달아서 Filter 생성함.
    // 바뀐 내용은 Comparator 객체가 아닌 Predicate 객체로 바꿔서 보면 됨.
        정렬이라는 행위를 여러 곳에서 할 수 있다.
        그러므로 정렬 인터페이스를 만든다. -> 정렬 행위가 필요한 곳에 implements 시킨다
        정렬하기 위해선 List 와 Condition(조건) 이 필요하다.
        List 와 Condition을 받아 해당맞는 조건을 실행할 SortService를 만든다.
        Condition 내용은 여러개가 될 수 있다. if else 로 써도 분류 가능하지만 enum을 배웠으니 사용한다
        // enum 객체에 함수를 넣을 수 있더라... 처음알았음
        // enum 객체에 interface를 implements 시키면 강제로 enum의 나열된 객체상수? 안에 강제로 메소드가 주입? 하게 됨
        그래서 현재 가지고 있는 Pet, Board 에 필요한 Condition들을 나열 객체상수로 만듬
        객체상수 안에 메소드를 각 해당하는 Comparator 객체를 사용하여 정의.... 해야 ... 됨 여기 아직 안됨
        + SortService 에서 실행하는 메소드를 합치?
        
        - 매개변수 값에 따라 Comparator Reverse 
        
        - Sorter MyPetComparator 를 분리 하고 각 역할 분담을 시킴
          Sorter 는 List 와 Comparator 를 들고 sort 해줌
          PetComparator, BoardComparator 를 묶기 위해 MyPetComparator를 사용
          MyPetComparator 는 각 Condition에 맞는 Comparator 객체를 반환하게 함
          
        + // TODO : PetComparator, BoardComparator 에 MyPetComparator 를 implements 시켰음
                    어떤 condition을 던지던 그에 맞는 condition 을 찾아 해당 comparator 를 반환하게 만들고 싶다.
        - // 어떤 condition이든 해당 condition을 찾으면 안됨, 동일 이름의 condition이 있을 수 있음.
             이것까지 수용하려면 Pet 과 Board 의 공통 분모를 만들어야함
        
    3. 테스트를 만든다
        SortServiceTest
    4. DB를 추가한다
    5. 코딩한다 ...  4 2 5 3 순서로 했음..
    
    
##### 2. 유기동물 상세페이지를 볼 수 있다.
    1. 요구사항을 적는다.
        a. 해당 Pet 의 id를 받는다
        b. 해당 Pet 의 정보를 전달한다.
    2. 고민한다
        
##### 3. 실종동물 전체목록을 볼 수 있다.
    요구사항 1번과 동일
##### 4. 실종동물 상세페이지를 볼 수 있다.
##### 5. 게시판 글을 쓸 수 있다.
##### 6. 게시판 글을 수정할 수 있다.
##### 7. 게시판 글을 삭제할 수 있다.(해당회원, 관리자만)
##### 8. 게시판 글을 제목, 내용, 글쓴이 ID로 검색할 수 있다.
##### 9. 게시판 글에 동물 발견 위치를 넣을 수 있다.
##### 10. 동물 종에 따른 게시판 글을 볼 수 있다.
##### 11. 동물 발견 위치에 따른 게시판 글을 볼 수 있다.
##### 12. 게시판은 분양, 입양, 실종, 임시보호 로 분류하여 볼 수 있다.
##### 13. 실종신고 회수 가능하다.
 


## Spring boot, Gradle, JPA

### gradle 설정
    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
        implementation 'org.springframework.boot:spring-boot-starter-web'
        compileOnly 'org.projectlombok:lombok'
        compile group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.12.1'
        runtimeOnly 'mysql:mysql-connector-java'
        annotationProcessor 'org.projectlombok:lombok'
        testImplementation('org.springframework.boot:spring-boot-starter-test') {
            exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
        }
    }

- Spring web, jpa, mysql, lombok 추가
- 써보고싶어서 log4j 추가

### JPA 설정
    spring:
      datasource:
        url: jdbc:mysql://localhost:3306/mypet?useSSL=false&serverTimezone=UTC
        username: root
        password: 1111
      jpa:
        hibernate:
          ddl-auto: update
          naming:
            physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
        show-sql: true
    server:
      port: 8081
- 기본 datasource
- jpa - hibernate - naming :컬럼 값을 자동으로 snakeCase 로 변경해주는것을 camelCase 로 설정하기 위함