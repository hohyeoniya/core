package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
    /* 스프링 빈 라이프사이클 : 객체생성 -> 의존관계 주입(setter, 필드주입) (생성자 주입은 예외)*/
    /* 스프링 빈의 이벤트 라이프사이클(싱글톤)
    * :스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료 */
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + "message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    /*
    * @PostConstruct, @PreDestroy 애노테이션 특징
    * 최신 스프링에서 가장 권장하는 방법이다.
    * 어노테이션 하나만 붙이면 되므로 매우 편리하다.
    * 유일한 단점!! 외부 라이브러리에는 적용하지 못한다는 것이다.
    * 코드를 고칠 수 없는 외부 라이브러리를 초기화, 종료해야 하면 @Bean의 initMethod, destroyMethod를 사용하자.
    */
    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
