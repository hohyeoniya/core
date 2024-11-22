package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        /* 권장! 프로젝트 시작루트에 메인 설정 정보를 두고 @ComponentScan 을 붙이고, basePackages 지정은 생략한다.*/
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
