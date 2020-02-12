# My Pet Project

### 주제
#### 유기동물 입양, 잃어버린 반려동물 찾기 서비스

### 개발방법
    1. 요구사항을 적는다
    2. 고민한다
    3. 테스트 만든다
    4. DB를 추가한다
    5. 코딩한다
    
### 요구사항
##### 1. 유기동물 전체목록을 볼 수 있다.
    a. 전체목록 가져오기 (DB)
    b. 원하는 분류로 순서를 정렬 (함수) 
    c. 원하는 분류에 맞는 목록 출력 (함수 sortPetFromClassification) 
    
##### 2. 유기동물 상세페이지를 볼 수 있다.  
##### 3. 실종동물 전체목록을 볼 수 있다.
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