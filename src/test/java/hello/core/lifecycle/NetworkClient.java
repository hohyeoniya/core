package hello.core.lifecycle;

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
    * 메서드 이름을 자유롭게 줄 수 있다.
    * 스프링 빈이 스프링 코드에 의존하지 않는다.
    * 코드가 아니라 설정 정보를 사용하기 때문에 코드를 고칠 수 없는 외부 라이브러리에도 초기화, 종료 메서드를 적용할 수 있다.
    */
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
