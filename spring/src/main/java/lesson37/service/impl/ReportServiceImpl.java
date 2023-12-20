package lesson37.service.impl;

import lesson37.dao.ReportDao;
import lesson37.model.Report;
import lesson37.service.ReportService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j
@Component
public class ReportServiceImpl implements ReportService {

//    private final List<ReportDao> reportDaos;
    private final Map<String, ReportDao> reportDaoMap;
    private final String hello;

    @Setter(onMethod_ = @Autowired)
    private ReportService self;

    public ReportServiceImpl(List<ReportDao> reportDaos, String hello) {
//        this.reportDaos = reportDaos;
        this.reportDaoMap = reportDaos.stream().collect(
                Collectors.toMap(
                        ReportDao::getBeanName,
                        Function.identity(),
                        (oldValue, newValue) -> newValue
                )
        );
        this.hello = hello;
    }

//    @Autowired
//    public ReportServiceImpl(@Qualifier("defaultReportDao") ReportDao reportDao, @Value("${hello}") String hello
////                             @Lazy @Autowired(required = false) Optional<ReportService> reportService
//    ) {
//        this.reportDao = reportDao;
//        this.hello = hello;
////        this.self = reportService.orElse(null);
////        Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{ReportService.class}, new InvocationHandler() {
////            @Override
////            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////                //todo: предусловие
////                Object invoke = method.invoke(this, args);
////                //todo: постусловие
////                return invoke;
////            }
////        });
//    }

    @PostConstruct
    public void init() {
        log.info("Component was initialized and successfully started");
    }

    @PreDestroy
    public void destroy() {
        log.info("Component was destroyed");
    }

//    public ReportServiceImpl(ReportDao reportDao) {
//        this.reportDaos = List.of(reportDao);
//        this.hello = "hello";
//        this.self = new ReportServiceImpl(reportDaos, hello);
////        this.self = new ReportServiceImpl(reportDao, hello, null);
//    }

//    public ReportServiceImpl(@Qualifier("defaultReportDao") ReportDao reportDao, String hello) {
//        this.reportDao = reportDao;
//        this.hello = hello;
//    }

    @Override
    public void generateAndSave() {
        Report report = new Report(1L, "Annual report");
        reportDaoMap.values().stream().findAny()
                .stream()
                .peek(it -> it.save(report));
    }

    @Override
    public void generateSomeAndSave() {
//        log.info("ReportServiceImpl#generateSomeAndSave began");
        List<Report> reports = List.of(
                new Report(1L, "Annual report"),
                new Report(2L, "Monthly report"),
                new Report(3L, "Daily report"),
                new Report(4L, hello)
        );
        int index = new Random().nextBoolean() ? 0 : 1;
        log.info("index for report " + index);
        String key = new ArrayList<>(reportDaoMap.keySet()).get(index);
        log.info("bean name for report " + key);
        ReportDao reportDao = reportDaoMap.get(key);
        reports.forEach(reportDao::save);
        log.info(reportDao);
//        log.info("ReportServiceImpl#generateSomeAndSave end");
    }
}
